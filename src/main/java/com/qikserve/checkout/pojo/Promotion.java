package com.qikserve.checkout.pojo;

public abstract class Promotion {

    public static final Promotion getPromotionFromJSON(JSONPromo promo) {
        if (promo != null) {
            switch (promo.getType()) {
            case "QTY_BASED_PRICE_OVERRIDE":
                return new PromotionOverride(promo);
            case "BUY_X_GET_Y_FREE":
                return new PromotionGetFree(promo);
            case "FLAT_PERCENT":
                return new PromotionFlat(promo);
            }
        }
        return null;
    }

    int required, value;

    public Promotion(int requiredQuantity, int value) {
        this.required = requiredQuantity;
        this.value = value;
    }

    public abstract int getSavings(int quantity, int price);
}
