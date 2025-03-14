package urise.webapp;

import urise.webapp.model.SectionType;

import java.sql.SQLOutput;

public class TestSingleton {
    private static TestSingleton instance; // = new TestSingleton();

    public static TestSingleton getInstance() {
        if (instance == null) {
            instance = new TestSingleton();
        }
        return instance;
    }

    private TestSingleton() {

    }

    public static void main(String[] args) {
        TestSingleton.getInstance().toString();
        Singleton instance = Singleton.valueOf("INSTANCE");
        System.out.println(instance.ordinal());

        for (SectionType type: SectionType.values()) {
            System.out.println(type.getTitle());
        }

    }

    public enum Singleton {
        INSTANCE
    }
}
