package com.example.demo.pojo;

public class NameByWeight {

    private int weight;
    private String value;

    public NameByWeight(int weight, String value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
