package day12.utils;

import day12.models.Person;

public class Helper {
    public static void greeting(Person p) {
        System.out.println("Hello " + p.getName());
        InternalUtil.log("Greetings! " + p.getName());
    }
}
