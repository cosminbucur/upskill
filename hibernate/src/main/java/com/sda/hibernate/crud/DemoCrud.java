package com.sda.hibernate.crud;

public class DemoCrud {

    public static void main(String[] args) {
        Person person = new Person();
        person.setFirstName("jon");
        person.setLastName("snow");
        person.setEmail("jonsnow@gmail.com");
        person.setCountry("westeros");

        PersonDao personDao = new PersonDao();

        personDao.create(person);

        Person newPerson = personDao.findById(person.getId());
        newPerson.setFirstName("test");
        newPerson.setLastName("test");
        newPerson.setEmail("test");
        newPerson.setCountry("test");

        personDao.update(newPerson);

        personDao.findAll();

        Person updatedPerson = personDao.findById(newPerson.getId());

        personDao.delete(updatedPerson);
    }
}
