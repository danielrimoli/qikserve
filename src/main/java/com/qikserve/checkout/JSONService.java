package com.qikserve.checkout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.qikserve.checkout.pojo.Product;

@Service
public class JSONService {

    @Autowired
    private RestTemplate restTemplate;

    // Get list of all products
    public Product[] getProducts() {
        // Use restTemplate to automatically convert JSON response to POJO
        // getForEntity method is needed to handle unnamed arrays in JSON object
        ResponseEntity<Product[]> response = restTemplate.getForEntity("http://localhost:8081/products",
                Product[].class);
        Product[] products = response.getBody();

        return products;
    }

    // Get full info for specific product
    public Product getProduct(String id) {
        // getForObject method can convert in a single step in general cases
        Product product = restTemplate.getForObject("http://localhost:8081/products/" + id, Product.class);

        return product;
    }

}
