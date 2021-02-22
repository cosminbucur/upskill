package com.sda.advanced.functional.method_reference.static1;

import java.util.function.BiFunction;
import java.util.function.Function;

public class DemoStaticMethod {

    public static void main(String[] args) {
//        Function<Integer, Integer> healUp = (amount) -> Darius.healUp(amount);

        // method reference
        Function<Integer, Integer> healUpFunction = Darius::healUp;
        System.out.println(healUpFunction.apply(50));
//
//        BiFunction<Integer, Integer, Integer> dealDmg =
//                (attackDamage, trueDamage) -> Darius.dealDmg(attackDamage, trueDamage);
        BiFunction<Integer, Integer, Integer> dealDmgFunction = Darius::dealDmg;
        System.out.println(dealDmgFunction.apply(20, 30));
    }
}
