import domain.Person;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {

        // Создаем объект Person
        Person person = new Person("Sergey");

        // Присваиваем возраст
        person.setAge(20);

        // Показываем возраст в консоле
        System.out.println("Age:" + person.getAge());

        // С помощью рефлексии устанавливаем не корректное значение
        try {
            Field field = Person.class.getDeclaredField("age");
            field.setAccessible(true);
            field.setInt(person, 130);
            System.out.println("New age:" + person.getAge());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        try {
            Field field = Person.class.getDeclaredField("age");
            field.setAccessible(true);
            System.out.println(field.get(person));
            System.out.println("New age:" + person.getAge());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}