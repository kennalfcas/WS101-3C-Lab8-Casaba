package com.casaba.lab8;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ProductMutationController {

    private final ProductService productService;

    public ProductMutationController(ProductService productService) {
        this.productService = productService;
    }

    @MutationMapping
    public Product createProduct(@Argument ProductInput product) {
        Product newProduct = new Product();
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        return productService.createProduct(newProduct);
    }

    @MutationMapping
    public Product updateProduct(@Argument Long id, @Argument ProductInput product) {
        Product updated = new Product();
        updated.setName(product.getName());
        updated.setPrice(product.getPrice());
        return productService.updateProduct(id, updated);
    }

    @MutationMapping
    public boolean deleteProduct(@Argument Long id) {
        return productService.deleteProduct(id);
    }
}
