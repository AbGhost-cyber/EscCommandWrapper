package com.crushtech.esccommandwrapper;

public class OrderItem {
    private int qty;
    private String itemName;
    private String unit;
    private String taste;

    public OrderItem(int qty, String itemName, String unit) {
        this.qty = qty;
        this.itemName = itemName;
        this.unit = unit;
    }

    public OrderItem(int qty, String itemName, String unit, String taste) {
        this.qty = qty;
        this.itemName = itemName;
        this.unit = unit;
        this.taste = taste;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }
}
