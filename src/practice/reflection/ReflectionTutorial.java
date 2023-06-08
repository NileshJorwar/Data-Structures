package src.practice.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTutorial {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {

        var person = new Person("Sachin", 28);

        var fields = person.getClass().getDeclaredFields();
        for (Field f :
                fields) {
            System.out.println(f.getName());
            if(f.getName().equals("name")){
                f.setAccessible(true);
                f.set(person, "Nilesh");
            }
        }

        System.out.println(person);
        var methods = person.getClass().getDeclaredMethods();
        for (Method m: methods
             ) {
            System.out.println(m.getName());
            if(m.getName().equals("printName")){
                m.setAccessible(true);
                m.invoke(person);
            }
        }
    }
}
