package urise.webapp;

import urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume r = new Resume("name1");
        Class resumeClass = r.getClass();
        Field field = resumeClass.getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new uuid");
        System.out.println(r);

        field.set(r, "new uuid test invoke");
        Method method = resumeClass.getMethod("toString");
        Object objectInvoke = method.invoke(r);
        System.out.println(objectInvoke);
    }
}
