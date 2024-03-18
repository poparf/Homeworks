package ro.ase.acs.models;

import java.util.*;

public class EnGrosProduct extends Product implements Cloneable {
    private float discount;

    static HashMap<String, EnGrosProduct> stock = new HashMap<>();
    // same product based on price and name
    static public void addProduct(EnGrosProduct newProduct) {
        if(stock.containsKey(newProduct.name + newProduct.price)) {
            EnGrosProduct foundProd = stock.get(newProduct.name + newProduct.price);
            EnGrosProduct newProd = new EnGrosProduct(foundProd.name, foundProd.price, foundProd.quantity + newProduct.quantity);
            stock.remove(newProduct.name + newProduct.price);
            stock.put(newProd.name + newProd.price, newProd);
            return;
        } // POPA ROBERT FLORIAN !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        stock.put(newProduct.name + newProduct.price,newProduct);
    }

    static public String printStock() {
        StringBuilder message = new StringBuilder();
        float totalValue = 0;
        for( EnGrosProduct prod : stock.values()) {
            message.append(prod.toString());
            message.append("\n");
            totalValue += prod.price * prod.quantity;
        }
        message.append("\n");
        message.append("The total value of the stock without discount: ");
        message.append(totalValue);
        return message.toString();
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("> ");
        sb.append(this.name);
        sb.append(" ");
        sb.append(this.price);
        sb.append(" ");
        sb.append(this.quantity);
        sb.append(" ");
        if(this.discount == 0.0f) {
            sb.append("0% ");
        } else if(this.discount == 0.05f) {
            sb.append("5% ");
        } else {
            sb.append("10% ");
        }
        sb.append(this.price * this.quantity);
        sb.append(" ");
        sb.append(this.price * this.quantity - this.quantity * this.getDiscount());
        return sb.toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        EnGrosProduct copy = (EnGrosProduct)super.clone();
        copy.discount = discount;
        return copy;
    }

    public EnGrosProduct(String name, float price, int quantity) {
        super(name, price, quantity);
        if(quantity < 10) {
            this.discount = 0;
        } else if(quantity >= 10 && quantity < 20) {
            this.discount = 0.05f;
        } else {
            this.discount = 0.1f;
        }
    }

    @Override
    public float getDiscount() {
        return this.discount * this.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnGrosProduct that = (EnGrosProduct) o;
        return Float.compare(discount, that.discount) == 0;
    }

    @Override
    public int hashCode() {
        return (int)(Math.ceil(100.0 * this.price + (float)this.name.hashCode())); // e o problema la xyz
    }
}