package com.appskimo.app;

import com.appskimo.app.domain.enums.Status;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by dominic.lee on 2016. 10. 24..
 */
@Slf4j
public class EnumTest {

    public static void main(String[] args) {

        log.info("{}", Status.USED);
        log.info("{}", Status.USED.name());
        log.info("{}", Status.USED.getCode());
        log.info("{}", Status.USED.getStatus());

        log.info("{}", Status.valueOf("USED"));


        for(Status s : Status.values()) {
            log.info("{} {}", s.getCode(), s.getStatus());
        }

    }


}
