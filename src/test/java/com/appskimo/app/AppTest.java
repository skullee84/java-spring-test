package com.appskimo.app;

import com.appskimo.app.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;

import java.lang.reflect.Field;

@Slf4j
@Ignore
public class AppTest {

    @Test
    public void test() {
        Class<User> clazz = User.class;
        Field[] fields = clazz.getDeclaredFields();
        display(fields);
    }

    private static void display(Object[] objs) {
        for (Object obj : objs) {
            log.info("{}", obj.toString());
        }
    }

}
