package com.appskimo.app;

import org.junit.Ignore;
import org.junit.Test;

import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by dominic.lee on 2016. 11. 15..
 */
@Ignore
public class MainTest {

    @Test
    public void testReduce() {
        Stream.generate(Math::random).limit(10).reduce((a, b) -> a + b).ifPresent(System.out::println);
    }

    @Test
    public void testStream() {
        OptionalDouble average = IntStream.range(0, 10).average();
        if(average.isPresent())
            System.out.println(average.getAsDouble());
    }

}
