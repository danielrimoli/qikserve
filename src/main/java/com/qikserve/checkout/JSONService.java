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

    public Product[] getProducts() {
        ResponseEntity<Product[]> response = restTemplate.getForEntity("http://localhost:8081/products",
                Product[].class);
        Product[] products = response.getBody();

        return products;
    }

    public Product getProduct(String id) {
        Product product = restTemplate.getForObject("http://localhost:8081/products/" + id, Product.class);

        return product;
    }

}
