package domain;

import java.security.InvalidParameterException;
import java.util.Objects;

public class Person {

    private final String name;

    private int age;

    public Person(String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new InvalidParameterException("The 'name' parameter is NULL or empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 120) {
            throw new InvalidParameterException("The 'age' parameter is negative or NULL or empty.");
        }
        this.age = age;
    }
}
