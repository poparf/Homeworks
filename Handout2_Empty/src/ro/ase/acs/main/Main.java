package ro.ase.acs.main;

import ro.ase.acs.models.EnGrosProduct;
import ro.ase.acs.models.Product;

public class Main {

	public static void main(String[] args) {
		//Playground
		//here you can test your code manually
		EnGrosProduct product1 = new EnGrosProduct("ABCD", 100.2F, 11);
		EnGrosProduct product2 = new EnGrosProduct("ABCD", 100.7F, 15);
		EnGrosProduct product3 = new EnGrosProduct("ABCD", 100.2F, 19);
		EnGrosProduct product4 = new EnGrosProduct("XYZ", 50.0F, 10);
		EnGrosProduct product5 = new EnGrosProduct("XYZ", 50.0F, 20);
		EnGrosProduct.addProduct(product1);
		EnGrosProduct.addProduct(product2);
		EnGrosProduct.addProduct(product3);
		EnGrosProduct.addProduct(product4);
		EnGrosProduct.addProduct(product5);
		String result = EnGrosProduct.printStock();
		System.out.println(result);
	}

}
