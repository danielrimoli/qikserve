package com.qikserve.checkout;

import java.util.HashMap;
import java.util.Map;

import com.qikserve.checkout.layout.BasketLayout;
import com.qikserve.checkout.layout.TotalsLayout;
import com.qikserve.checkout.pojo.Product;

public class Basket {
    JSONService service;

    public Basket(JSONService service) {
        this.service = service;
    }

    Map<Product, Integer> contents = new HashMap<Product, Integer>();
    BasketLayout layout;
    TotalsLayout totals;

    // Add a product to the user's basket and update current basket state on UI
    public void add(Product prod) {
        // Clear totals to avoid displaying misleading information
        totals.clear();

        // Check if we already have this product in the basket
        Integer qty = contents.get(prod);

        // If not in the basket, we must retrieve the full product details before adding
        // it to the basket
        // Otherwise, simply increase the quantity
        if (qty == null) {
            qty = 1;
            prod = service.getProduct(prod.getId());
        } else {
            qty++;
        }

        // Save changes to basket
        contents.put(prod, qty);

        // Add product to basket on UI
        layout.add(prod, qty);
    }

    // Calculate totals for user's basket and update values on UI
    public void checkout() {
        int total = 0;
        int savings = 0;
        int payable = 0;

        // Iterate over products in basket and add up totals and savings
        for (Product prod : contents.keySet()) {
            int qty = contents.get(prod);
            prod.processPromotions();
            total += prod.getPrice() * qty;
            savings += prod.getSavings(qty);
        }

        payable = total - savings;

        totals.displayTotals(total, savings, payable);
    }

    // Store reference to layout elements to be controlled during the operation
    public void setLayouts(BasketLayout basketContents, TotalsLayout totals) {
        this.layout = basketContents;
        this.totals = totals;
    }
}
