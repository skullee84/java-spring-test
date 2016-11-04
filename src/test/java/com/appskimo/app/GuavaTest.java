package com.appskimo.app;


import com.google.common.base.Preconditions;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Optional;

@Slf4j
@Ignore
public class GuavaTest {

    @Test
    public void test() {
        String temp = "data";
        Optional<String> possible = Optional.of(temp);

        possible.ifPresent(this::display);

        Optional.of("sample").ifPresent(this::display);

        int i = 10;
        Preconditions.checkArgument(i < 11, "i is %s..", i);

        Table<String, String, Long> records = HashBasedTable.create();
        records.put("number", "one", 1L);
        records.put("number", "two", 1L);
        records.put("alpha", "one", 2L);
        records.put("alpha", "a", 1L);
        records.put("alpha", "b", 1L);

        display(records);
        display(records.row("number"));
        display(records.column("one"));
    }

    private void display(Object o) {
        log.info(o.toString());
    }

}
