package com.sda.hibernate.associations.one_to_many_bi;

public class DemoOneToManyBidirectional {

    public static void main(String[] args) {
        // create parent
        Parent parent = new Parent("parent");

        // create children
        Child child1 = new Child("child1");
        Child child2 = new Child("child2");

        // add child to parent
        parent.addChild(child1);
        parent.addChild(child2);

        // save
        ParentDao parentDao = new ParentDao();
        parentDao.create(parent);
    }
}
