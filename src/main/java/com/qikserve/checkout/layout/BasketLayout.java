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

    public void add(Product prod, int qty) {
        if (contents.size() == 0) {
            remove(emptyLabel);
        }

        HorizontalLayout layout = contents.get(prod.getId());

        if (layout == null) {
            layout = new HorizontalLayout();
            contents.put(prod.getId(), layout);
            add(layout);

            add(checkoutButton);
            setHorizontalComponentAlignment(Alignment.CENTER, checkoutButton);
        }

        layout.removeAll();
        layout.add(new Label(Integer.toString(qty) + "x " + prod.getName()));
    }
}
