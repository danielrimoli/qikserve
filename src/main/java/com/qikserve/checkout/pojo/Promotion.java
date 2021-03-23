package com.qikserve.checkout.pojo;

public abstract class Promotion {

    // This was the least ugly way possible to transform the JSON promotion objects,
    // which had no common properties or interfaces to much more manageable Java
    // classes with proper hierarchy and common interfaces.
    // This also allows for much easier extension of the supported promotion types
    // in the future
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

    // This method should be used to calculate the total money saved by the user,
    // according to the mechanics of the specific promotion in question, the total
    // quantity of the same product that was added to the basket and the unit price
    // of the product
    // Return should be the actual savings, in absolute value, represented in
    // pennies.
    public abstract int getSavings(int quantity, int price);
}
