package com.example.user.loftmoneytraker;

public class Transaction {

    private String name;
    private String createDate;
    private int sum;

    public Transaction(String name, String createDate, int sum) {
        this.name = name;
        this.createDate = createDate;
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedDate() {
        return createDate;
    }

    public void setCreatedDate(String createDate) {
        this.createDate = createDate;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }


}
