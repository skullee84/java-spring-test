package com.appskimo.app;

import static org.joor.Reflect.on;

public class JoorProxyTest {

    private static final String CLASS_STRING = "java.lang.String";

    public static void main(String[] args) {

        String substring = on(CLASS_STRING)
            .create("Hello World")
            .as(StringProxy.class)
            .substring(6)
            .concat("???");


        display(substring);
    }



    public interface StringProxy {
        String concat(String str);
        String substring(int beginIndex);
    }

    private static void display(Object obj) {
        System.out.println(obj.toString());
    }

}
