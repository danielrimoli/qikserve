package com.qikserve.checkout;

import org.springframework.beans.factory.annotation.Autowired;

import com.qikserve.checkout.layout.BasketLayout;
import com.qikserve.checkout.layout.ProductsLayout;
import com.qikserve.checkout.layout.TotalsLayout;
import com.qikserve.checkout.pojo.Product;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

/**
 * The default view and entry point of the web-app
 * <p>
 * A new instance of this class is created for every new user and every browser
 * tab/window.
 */
@Route
@PWA(name = "QikServe Checkout Web App", shortName = "Checkout Web", description = "This is a web-based Checkout system for supermarkets", enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
@Theme(value = Lumo.class, variant = Lumo.DARK)
public class MainView extends VerticalLayout {

    public MainView(@Autowired JSONService service) {

        // Get product list via REST API
        Product[] products = service.getProducts();

        // Initialize basket
        Basket basket = new Basket(service);

        // Build layout
        ProductsLayout productsLayout = new ProductsLayout(products, basket);
        BasketLayout basketContents = new BasketLayout(basket);
        TotalsLayout totals = new TotalsLayout();

        basket.setLayouts(basketContents, totals);

        HorizontalLayout columns = new HorizontalLayout(
                new VerticalLayout(new H1("Available Products"), productsLayout),
                new VerticalLayout(new H1("BasketContents"), basketContents),
                new VerticalLayout(new H1("Expected Totals"), totals));
        columns.setWidthFull();

        add(columns);
        setSizeFull();
    }
}
