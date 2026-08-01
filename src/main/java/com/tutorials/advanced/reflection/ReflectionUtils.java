package com.tutorials.advanced.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectionUtils {
    // Walks every public method, checks for @Loggable via reflection, and
    // invokes only the annotated ones — the kind of generic, type-blind
    // processing that annotations + reflection make possible and that
    // ordinary polymorphism cannot express.
    public static List<String> invokeLoggableMethods(Object target)
            throws InvocationTargetException, IllegalAccessException {
        List<String> invoked = new ArrayList<>();
        for (Method method : target.getClass().getMethods()) {
            if (method.isAnnotationPresent(Loggable.class) && method.getParameterCount() == 0) {
                Object result = method.invoke(target);
                invoked.add(method.getName() + " -> " + result);
            }
        }
        return invoked;
    }

    // setAccessible(true) bypasses the normal `private` access check — a
    // capability real code should reserve for frameworks (serializers, DI
    // containers, test tools), never everyday business logic.
    public static Object readPrivateField(Object target, String fieldName)
            throws NoSuchFieldException, IllegalAccessException {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(target);
    }

    public static <T> T instantiate(Class<T> type) throws ReflectiveOperationException {
        return type.getDeclaredConstructor().newInstance();
    }
}
