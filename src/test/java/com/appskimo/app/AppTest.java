package com.appskimo.app;

import com.appskimo.app.domain.User;
import com.appskimo.app.annotation.AspectTestAnnotation;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

@Slf4j
public class AppTest {
    private static final int PRIVATE_STATIC_FINAL = Modifier.PRIVATE + Modifier.STATIC + Modifier.FINAL;

    @SneakyThrows
    public static void main(String[] args) {
        Class<User> clazz = User.class;
        Field[] fields = clazz.getDeclaredFields();
        display(fields);

        AspectTestAnnotation annotation = clazz.getAnnotation(AspectTestAnnotation.class);
        display(annotation);
    }

    private static void display(Object obj) {
        log.info("{}", obj.toString());
    }

    private static void display(Object[] objs) {
        for (Object obj : objs) {
            log.info("{}", obj.toString());
        }
    }

}
