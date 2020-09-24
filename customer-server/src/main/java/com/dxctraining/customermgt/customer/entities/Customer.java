package com.dxctraining.customermgt.customer.entities;

import javax.persistence.*;

@Entity
@Table(name = "customers")//table name
public class Customer {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private double balance;

    public Customer() {

    }

    public Customer(String name,double balance) {
        this.name = name;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer that = (Customer) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
