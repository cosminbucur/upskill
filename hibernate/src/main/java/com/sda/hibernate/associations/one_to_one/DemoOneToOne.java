package com.sda.hibernate.associations.one_to_one;

public class DemoOneToOne {

    public static void main(String[] args) {
        Employee employee = new Employee("test@gmail.com");

        Account account = new Account("230");
        account.setEmployee(employee);

        employee.setAccount(account);

        AccountDao accountDao = new AccountDao();
        accountDao.create(account);
    }
}
