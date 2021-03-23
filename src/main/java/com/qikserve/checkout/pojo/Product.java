package com.qikserve.checkout.pojo;

import java.util.List;

public class Product {
    String name;
    int price;
    Promotion promo;
    String id;
    List<JSONPromo> promotions;

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

    public void processPromotions() {
        if ((this.promotions != null) && (this.promotions.size() > 0)) {
            promo = Promotion.getPromotionFromJSON(this.promotions.get(0));
        }
    }

    @Override
    public boolean equals(Object prod) {
        return this.id.equals(((Product) prod).getId());
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
}
