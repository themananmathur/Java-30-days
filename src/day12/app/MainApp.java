package day12.app;

import day12.models.Person;
import day12.utils.Helper;

public class MainApp {
    public static void main(String[] args) {
        Person p = new Person("Manan");
        Helper.greeting(p);
    }
}
