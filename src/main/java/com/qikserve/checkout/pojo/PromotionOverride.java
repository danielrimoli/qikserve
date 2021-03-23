package com.qikserve.checkout.pojo;

public class PromotionOverride extends Promotion {

    public PromotionOverride(JSONPromo promo) {
        super(promo.getRequired_qty(), promo.getPrice());
    }

    @Override
    // This promotion requires the purchase of products in "bundles" of "required"
    // quantity, to get a discount.
    // The "value" field holds the reduced price of a complete bundle.
    public int getSavings(int quantity, int price) {
        // Calculate the number of times the user has added the required quantity to get
        // a discount
        // Storing the result of the simple division into an integer gives us the whole
        // number of complete bundles
        int groups = quantity / this.required;

        // Calculate the actual discount for each complete bundle
        int unit = (this.required * price - value);

        // Multiply by number of complete bundles
        return unit * groups;
    }

}
