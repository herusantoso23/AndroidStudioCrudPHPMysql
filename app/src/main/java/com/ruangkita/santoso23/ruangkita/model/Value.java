package com.ruangkita.santoso23.ruangkita.model;

import java.util.List;

/**
 * Created by santoso on 8/8/17.
 */

public class Value {
    private String value;
    private String message;
    List<Pengguna> result;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Pengguna> getResult() {
        return result;
    }

    public void setResult(List<Pengguna> result) {
        this.result = result;
    }
}
