package com.qikserve.checkout.pojo;

public class PromotionGetFree extends Promotion {

    public PromotionGetFree(JSONPromo promo) {
        super(promo.getRequired_qty(), promo.getFree_qty());
    }

    public PromotionGetFree(int requiredQuantity, int value) {
        super(requiredQuantity, value);
    }

    @Override
    // This requires the purchase of products in "bundles" of "required" quantity,
    // to get a part of them for free
    // In practice, the user has to add the "required" quantity + the "free"
    // quantity to the basket, to allow us to
    // discount the value of the "free" products from the total.
    // The "value" field holds the number of free products awarded for a complete
    // bundle.
    public int getSavings(int quantity, int price) {
        // Calculate the number of times the user added the "required" quantity + the
        // "free" quantity to the basket
        int times = quantity / (this.required + this.value);

        // Get the total value saved, based on the number of bundles, free products per
        // bundle and product price.
        return times * this.value * price;
    }

}
