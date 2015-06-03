package com.example.user.loftmoneytraker;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.Date;

@Table(name = "Transactions")
public class Transaction extends Model {

    @Column(name = "Name")
    private String comment;

    @Column(name = "Sum")
    private int sum;

    @Column(name = "CreateDate")
    private Date trDate;

    public Transaction() {

    }

    public Transaction(String name, int sum, Date createDate) {
        this.comment = name;
        this.trDate = createDate;
        this.sum = sum;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String name) {
        this.comment = name;
    }

    public Date getCreatedDate() {
        return trDate;
    }

    public void setCreatedDate(Date createDate) {
        this.trDate = createDate;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }


}
