package com.mansourappdevelopment.androidapp.savearraylistusinggsonandsharedprefrences;

public class Operation {
    private String name;
    private String sign;

    public Operation(String name, String sign) {
        this.name = name;
        this.sign = sign;
    }

    public String getName() {
        return name;
    }

    public String getSign() {
        return sign;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
