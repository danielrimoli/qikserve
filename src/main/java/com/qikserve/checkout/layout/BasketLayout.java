package com.qikserve.checkout.layout;

import java.util.HashMap;
import java.util.Map;

import com.qikserve.checkout.Basket;
import com.qikserve.checkout.pojo.Product;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class BasketLayout extends VerticalLayout {
    Map<String, HorizontalLayout> contents = new HashMap<String, HorizontalLayout>();
    Button checkoutButton;
    Basket basket;
    Label emptyLabel;

    public BasketLayout(Basket basket) {
        this.basket = basket;
        emptyLabel = new Label("Basket Empty");
        add(new H1("Basket Contents"), emptyLabel);
        addClassName("BasketContents");
        checkoutButton = new Button("Checkout", e -> basket.checkout());
    }

    // We want to re-use the layout elements to make it simpler to maintain visual
    // order of products in the UI
    public void add(Product prod, int qty) {
        // If basket is empty, we assume the "empty" label is still visible and remove
        // it
        if (contents.size() == 0) {
            remove(emptyLabel);
        }

        HorizontalLayout layout = contents.get(prod.getId());

        // If a layout element for this product doesn't exist already, create one and
        // store it in the map
        if (layout == null) {
            layout = new HorizontalLayout();
            contents.put(prod.getId(), layout);
            add(layout);

            add(checkoutButton);
            setHorizontalComponentAlignment(Alignment.CENTER, checkoutButton);
        }

        // Clear out contents and add new label with current quantity;
        layout.removeAll();
        layout.add(new Label(Integer.toString(qty) + "x " + prod.getName()));
    }
}
