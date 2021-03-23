package com.qikserve.checkout.pojo;

import java.util.List;

// To be able to automatically convert the JSON object to Java using RestTemplate, the Java object must have fields
// with the exact same name as the JSON objects
public class Product {
    String name;
    int price;
    String id;
    // We use this list to hold the promotions retrieved in JSON format, before
    // converting them to the more functional Promotion class
    List<JSONPromo> promotions;

    // This field is used to hold the more functional Promotion object, after being
    // converted from the JSON format stored in JSONPromo list
    Promotion promo;

    public Product() {
    }

    public Product(String name, int price, Promotion promo, String id) {
        this.name = name;
        this.price = price;
        this.promo = promo;
        this.id = id;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSavings(int quantity) {
        if (this.promo == null) {
            return 0;
        }
        return this.promo.getSavings(quantity, this.price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<JSONPromo> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<JSONPromo> promotions) {
        this.promotions = promotions;
    }

    // Convert the JSONPromo object retrieved with the REST API, which is not very
    // functional, to the internal Promotion class, with proper hierarchy and
    // standard interface
    public void processPromotions() {
        if ((this.promotions != null) && (this.promotions.size() > 0)) {
            promo = Promotion.getPromotionFromJSON(this.promotions.get(0));
        }
    }

    // Override equals method to allow hashmap lookup when using different instances
    // of the same product, which should still be treated as equal by the
    // application
    @Override
    public boolean equals(Object prod) {
        return this.id.equals(((Product) prod).getId());
    }

    // Override hashCode method to allow hashmap lookup when using different
    // instances of the same product, which should still be treated as
    // equal by the application
    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
}
