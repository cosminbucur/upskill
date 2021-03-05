package com.sda.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// jdbc with prepared statements
public class BookJdbcDao implements BookRepository {

    public static final String URL = "jdbc:mysql://localhost:3306/jdbc_tutorial";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

    @Override
    public Book create(Book book) {
        String query = "INSERT INTO book (title, author, publish_date) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            // set parameters
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getPublishedDate().toString());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("insert failed, no rows affected");
            }

            // get last inserted id
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    long generatedId = generatedKeys.getLong(1);
                    book.setId(generatedId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }

    @Override
    public List<Book> findAll() {
        List<Book> result = new ArrayList<>();
        String query = "SELECT * FROM book";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            // iterate result set, create books and return
            while (resultSet.next()) {
                Book bookInDb = new Book();
                bookInDb.setId(resultSet.getLong(1));
                bookInDb.setTitle(resultSet.getString(2));
                bookInDb.setAuthor(resultSet.getString(3));
                bookInDb.setPublishedDate(resultSet.getDate(4).toLocalDate());

                result.add(bookInDb);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        String query = "SELECT * FROM book WHERE author = ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query);
        ) {

            statement.setString(1, author);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Book bookInDb = new Book();
                bookInDb.setId(resultSet.getLong(1));
                bookInDb.setTitle(resultSet.getString(2));
                bookInDb.setAuthor(resultSet.getString(3));
                bookInDb.setPublishedDate(resultSet.getDate(4).toLocalDate());

                result.add(bookInDb);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Optional<Book> findById(Long id) {
        String query = "SELECT * FROM book WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            Book bookInDb = null;
            while (resultSet.next()) {
                bookInDb = new Book();
                bookInDb.setId(resultSet.getLong(1));
                bookInDb.setTitle(resultSet.getString(2));
                bookInDb.setAuthor(resultSet.getString(3));
                bookInDb.setPublishedDate(resultSet.getDate(4).toLocalDate());
            }
            return Optional.ofNullable(bookInDb);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        String query = "SELECT * FROM book WHERE title = ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, title);
            ResultSet resultSet = statement.executeQuery();

            Book bookInDb = null;
            while (resultSet.next()) {
                bookInDb = new Book();
                bookInDb.setId(resultSet.getLong(1));
                bookInDb.setTitle(resultSet.getString(2));
                bookInDb.setAuthor(resultSet.getString(3));
                bookInDb.setPublishedDate(resultSet.getDate(4).toLocalDate());
            }
            return Optional.ofNullable(bookInDb);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Book update(Long id, Book book) {
        String query = "UPDATE book SET title = ?, author = ?, publish_date = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setDate(3, Date.valueOf(book.getPublishedDate()));
            statement.setLong(4, id);

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("update failed, no rows affected");
            } else {
                book.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public void delete(Long id) {
        String query = "DELETE FROM book WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("delete failed, no rows affected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
