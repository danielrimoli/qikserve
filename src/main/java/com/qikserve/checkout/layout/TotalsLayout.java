package com.qikserve.checkout.layout;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class TotalsLayout extends HorizontalLayout {

    VerticalLayout labels, values;

    public TotalsLayout() {
        labels = new VerticalLayout(new Label("Total:"), new Label("Total Promos:"), new Label("Total Payable:"));

        values = new VerticalLayout();

        addAndExpand(labels, values);

    }

    public void displayTotals(int total, int savings, int payable) {
        values.removeAll();
        values.addAndExpand(new PriceLabel(total), new PriceLabel(savings), new PriceLabel(payable));
    }

    public void clear() {
        values.removeAll();
    }
}
