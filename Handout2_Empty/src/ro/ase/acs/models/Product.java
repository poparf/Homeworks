package ro.ase.acs.models;

import ro.ase.acs.contracts.Saleable;

public abstract class Product implements Saleable {
    protected String name;
    protected float price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected int quantity;

    public Product(String name, float price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract float getDiscount();
}
