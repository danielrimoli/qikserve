package com.qikserve.checkout.layout;

import com.qikserve.checkout.Basket;
import com.qikserve.checkout.pojo.Product;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ProductsLayout extends VerticalLayout {

    VerticalLayout labels, values, buttons;

    public ProductsLayout(Product[] products, Basket basket) {

        for (Product prod : products) {
            HorizontalLayout layout = new HorizontalLayout(new Label(prod.getName()), new PriceLabel(prod.getPrice()),
                    new Button("Add to basket", e -> basket.add(prod)));
            layout.setDefaultVerticalComponentAlignment(Alignment.CENTER);
            add(layout);
        }
    }
}
