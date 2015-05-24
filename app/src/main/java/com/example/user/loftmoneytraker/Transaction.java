package com.example.user.loftmoneytraker;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.Date;

@Table(name = "Transactions")
public class Transaction extends Model {

    @Column(name = "Name")
    private String name;

    @Column(name = "Sum")
    private int sum;

    @Column(name = "CreateDate")
    private Date createDate;

    public Transaction() {

    }

    public Transaction(String name, int sum, Date createDate) {
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

    public Date getCreatedDate() {
        return createDate;
    }

    public void setCreatedDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }


}
