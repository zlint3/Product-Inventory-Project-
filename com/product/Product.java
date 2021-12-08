package com.product;

import java.util.*;

public class Product {
    private final int id;
    private Money price;
    private int qty;

    public Product(int id, Money price, int qty) {
        this.id = id;
        this.price = price;
        this.qty = qty;
    }

    public void addStock(int howMany){
        this.qty += howMany;
    }

    public boolean removeStock(int howMany){
        if (howMany > this.qty){
            return false;
        }
        else{
            this.qty -= howMany;
            return true;
        }
    }

    public int getId() {
        return id;
    }

    public Money getTotalValue(){
        return this.price.multiplyBy(this.qty);
    }

    public void updatePrice(Money newPrice){
        this.price = newPrice;
    }

    public int getQty() {
        return qty;
    }


}