package com.qikserve.checkout.pojo;

public class PromotionFlat extends Promotion {

    public PromotionFlat(JSONPromo promo) {
        super(promo.getRequired_qty(), promo.getAmount());
    }

    public PromotionFlat(int requiredQuantity, int value) {
        super(requiredQuantity, value);
    }

    @Override
    // This has no minimum requirement. We just apply the flat rate for all
    // products.
    // The "value" field holds the discount percentage.
    public int getSavings(int quantity, int price) {
        // Simply multiple the total value of the products by the discount rate
        return quantity * price * this.value / 100;
    }

}
