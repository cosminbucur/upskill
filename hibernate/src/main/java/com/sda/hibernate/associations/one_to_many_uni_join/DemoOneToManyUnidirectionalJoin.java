package com.sda.hibernate.associations.one_to_many_uni_join;

import java.util.List;

public class DemoOneToManyUnidirectionalJoin {

    public static void main(String[] args) {
        // create father
        Father father = new Father("father");

        // create sons
        Son son1 = new Son("son1");
        Son son2 = new Son("son2");

        // add child to parent
        father.setSons(List.of(son1, son2));

        // save
        FatherDao fatherDao = new FatherDao();
        fatherDao.create(father);
    }
}
