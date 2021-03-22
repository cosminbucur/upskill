package com.sda.hibernate.associations.one_to_many_uni;

import java.util.List;

public class DemoOneToManyUnidirectional {

    public static void main(String[] args) {
        // create mother
        Mother mother = new Mother("mother");

        // create daughters
        Daughter daughter1 = new Daughter("daughter1");
        Daughter daughter2 = new Daughter("daughter2");

        // add child to parent
        mother.setDaughters(List.of(daughter1, daughter2));

        // version 2
//        mother.getDaughters().add(daughter1);
//        mother.getDaughters().add(daughter2);

        // save
        MotherDao motherDao = new MotherDao();
        motherDao.create(mother);
    }
}
