package com.qikserve.checkout.layout;

import com.vaadin.flow.component.html.Label;

public class PriceLabel extends Label {
    // Prices are stored in pennies, so we need to add the decimal point dinamically
    // for display
    public static String format(Integer price) {

        // Base case with not enough digits for proper formatting
        if (price == 0) {
            return ("£0.00");
        }

        // Add leading 0 for prices lower than 1 pound.
        String full = (price < 10 ? "0" : "") + (price < 100 ? "0" : "") + Integer.toString(price);

        int point = full.length() - 2;
        // Format string to display Pound simple and add decimal point before the last 2
        // digits.
        return String.format("£%1$s.%2$s", full.substring(0, point), full.substring(point, point + 2));
    }

    public PriceLabel(Integer price) {
        super(format(price));
    }
}
