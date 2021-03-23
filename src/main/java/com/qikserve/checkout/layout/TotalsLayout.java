package com.qikserve.checkout.layout;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class TotalsLayout extends VerticalLayout {

    VerticalLayout labels, values;

    public TotalsLayout() {
        add(new H1("Expected Totals"));

        labels = new VerticalLayout(new Label("Total:"), new Label("Total Promos:"), new Label("Total Payable:"));
        values = new VerticalLayout();

        HorizontalLayout contents = new HorizontalLayout(labels, values);
        contents.setSizeFull();
        add(contents);
    }

    public void displayTotals(int total, int savings, int payable) {
        clear();
        values.addAndExpand(new PriceLabel(total), new PriceLabel(savings), new PriceLabel(payable));
    }

    public void clear() {
        values.removeAll();
    }
}
