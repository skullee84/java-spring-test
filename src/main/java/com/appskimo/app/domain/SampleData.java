package com.appskimo.app.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by dominic.lee on 2016. 11. 15..
 */
@Data
@ToString(of = {"data"})
public class SampleData implements Serializable {
    private static final long serialVersionUID = 4249773485628514892L;

    private String data;
}
