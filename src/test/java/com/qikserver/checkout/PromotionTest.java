package com.qikserver.checkout;

import org.junit.Assert;
import org.junit.Test;

import com.qikserve.checkout.pojo.Promotion;
import com.qikserve.checkout.pojo.PromotionFlat;
import com.qikserve.checkout.pojo.PromotionGetFree;
import com.qikserve.checkout.pojo.PromotionOverride;

public class PromotionTest {

    @Test
    public void testOverrridePromotionNoDiscount() {
        Promotion promo = new PromotionOverride(2, 1700);
        Assert.assertEquals(0, promo.getSavings(1, 1000));
    }

    @Test
    public void testOverridePromotionGivesDiscount() {
        Promotion promo = new PromotionOverride(2, 1700);
        Assert.assertEquals(300, promo.getSavings(2, 1000));

        promo = new PromotionOverride(4, 3500);
        Assert.assertEquals(500, promo.getSavings(6, 1000));

        promo = new PromotionOverride(2, 1700);
        Assert.assertEquals(600, promo.getSavings(4, 1000));
    }

    @Test
    public void testGetFreePromotionNoDiscount() {
        Promotion promo = new PromotionGetFree(2, 1);
        Assert.assertEquals(0, promo.getSavings(2, 1000));
    }

    @Test
    public void testGetFreePromotionGivesDiscount() {
        Promotion promo = new PromotionGetFree(2, 1);
        Assert.assertEquals(1000, promo.getSavings(3, 1000));

        promo = new PromotionGetFree(6, 2);
        Assert.assertEquals(2000, promo.getSavings(8, 1000));

        promo = new PromotionGetFree(6, 2);
        Assert.assertEquals(2000, promo.getSavings(10, 1000));

        promo = new PromotionGetFree(6, 2);
        Assert.assertEquals(4000, promo.getSavings(16, 1000));

        promo = new PromotionGetFree(5, 3);
        Assert.assertEquals(6000, promo.getSavings(20, 1000));
    }

    @Test
    public void testFlatPromotionGiverDiscount() {
        Promotion promo = new PromotionFlat(2, 10);
        Assert.assertEquals(300, promo.getSavings(3, 1000));

        promo = new PromotionFlat(5, 20);
        Assert.assertEquals(400, promo.getSavings(2, 1000));
    }
}
