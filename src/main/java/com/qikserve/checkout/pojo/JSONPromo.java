package com.qikserve.checkout.pojo;

public class JSONPromo {
    String id, type;
    int price, required_qty, free_qty, amount;

    public JSONPromo() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRequired_qty() {
        return required_qty;
    }

    public void setRequired_qty(int required_qty) {
        this.required_qty = required_qty;
    }

    public int getFree_qty() {
        return free_qty;
    }

    public void setFree_qty(int free_qty) {
        this.free_qty = free_qty;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
