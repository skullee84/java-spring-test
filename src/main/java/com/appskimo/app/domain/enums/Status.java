package com.appskimo.app.domain.enums;

import lombok.Getter;

/**
 * Created by dominic.lee on 2016. 10. 24..
 */
@Getter
public enum Status {

    EXPIRED("00", "미유효"),
    STOPPED("01", "정지"),
    USED("02" , "사용됨");

    private String code;
    private String status;

    Status(String code, String status) {
        this.code = code;
        this.status = status;
    }

}
