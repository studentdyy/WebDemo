package com.demo.pojo;

import java.io.Serializable;

public class fruit implements Serializable {
    int uid;
    String name;
    int price;
    int number;

    public fruit(int uid, String name, int price, int number) {
        this.uid = uid;
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
