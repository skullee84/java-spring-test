package com.appskimo.app.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by dominic.lee on 2016. 10. 17..
 */
@Data
@ToString
@Builder
public class Dummy implements Serializable {
    private static final long serialVersionUID = -8221435406130374769L;

    private Long id;
    private String name;

}
