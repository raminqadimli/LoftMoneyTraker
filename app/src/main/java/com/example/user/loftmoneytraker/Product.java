package com.example.user.loftmoneytraker;

public class Product {

    private String _name;
    private String _createDate;
    private int _sum;

    public Product(String name, String createDate, int sum) {
        this._name = name;
        this._createDate = createDate;
        this._sum = sum;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getCreatedDate() {
        return _createDate;
    }

    public void setCreatedDate(String createDate) {
        this._createDate = createDate;
    }

    public int getSum() {
        return _sum;
    }

    public void setSum(int sum) {
        this._sum = sum;
    }



}
