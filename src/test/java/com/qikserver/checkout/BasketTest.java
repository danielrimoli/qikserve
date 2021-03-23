package com.qikserver.checkout;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;

import com.qikserve.checkout.Basket;
import com.qikserve.checkout.JSONService;
import com.qikserve.checkout.layout.BasketLayout;
import com.qikserve.checkout.layout.TotalsLayout;
import com.qikserve.checkout.pojo.Product;
import com.qikserve.checkout.pojo.Promotion;

public class BasketTest {

    Product pizza, burger, fries;
    JSONService service;
    BasketLayout basketLayout;
    TotalsLayout totalsLayout;

    public void setupMocks() {
        pizza = new Product("Pizza", 1000, null, "1");
        Promotion promo = mock(Promotion.class);

        when(promo.getSavings(anyInt(), anyInt())).thenReturn(100);

        burger = new Product("Burger", 1500, promo, "2");
        fries = new Product("Fries", 500, null, "3");

        service = mock(JSONService.class);
        when(service.getProduct(pizza.getId())).thenReturn(pizza);
        when(service.getProduct(burger.getId())).thenReturn(burger);

        basketLayout = mock(BasketLayout.class);
        totalsLayout = mock(TotalsLayout.class);
    }

    @Test
    public void testAddToBasket() {
        setupMocks();

        Basket basket = new Basket(service);
        basket.setLayouts(basketLayout, totalsLayout);
        basket.add(pizza);

        verify(service).getProduct(pizza.getId());
        verify(basketLayout).add(pizza, 1);

        Assert.assertEquals(basket.getCount(), 1);
    }

    @Test
    public void testAddToBasketClearsTotals() {
        setupMocks();

        Basket basket = new Basket(service);
        basket.setLayouts(basketLayout, totalsLayout);
        basket.add(pizza);

        verify(totalsLayout).clear();
    }

    @Test
    public void testAddTwiceToBasket() {
        setupMocks();

        Basket basket = new Basket(service);
        basket.setLayouts(basketLayout, totalsLayout);
        basket.add(pizza);
        basket.add(pizza);

        Assert.assertEquals(basket.getCount(), 1);
    }

    @Test
    public void testAddTwoProductsToBasket() {
        setupMocks();

        Basket basket = new Basket(service);
        basket.setLayouts(basketLayout, totalsLayout);
        basket.add(pizza);
        basket.add(burger);

        Assert.assertEquals(basket.getCount(), 2);
    }

    @Test
    public void testCheckoutCalculateTotals() {
        setupMocks();

        Basket basket = new Basket(service);
        basket.setLayouts(basketLayout, totalsLayout);
        basket.add(pizza);
        basket.add(burger);
        basket.checkout();

        verify(totalsLayout).displayTotals(2500, 100, 2400);
    }
}
