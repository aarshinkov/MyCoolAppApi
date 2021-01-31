package com.aarshinkov.rest.mycoolapp.controllers;

import java.util.List;
import com.aarshinkov.rest.mycoolapp.entities.ProductEntity;
import com.aarshinkov.rest.mycoolapp.models.ProductModel;
import com.aarshinkov.rest.mycoolapp.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Atanas Yordanov Arshinkov
 * @since 1.0.0
 */
@RestController
public class ProductsController {

    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductEntity> getProducts() {

        return productsRepository.findAll();
    }

    @GetMapping(value = "/products/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductEntity getProduct(@PathVariable("productId") Long productId) {

        return productsRepository.findByProductId(productId);
    }

    @PostMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductEntity createProduct(ProductModel pcm) {

        ProductEntity product = new ProductEntity();
        product.setName(pcm.getName());
        product.setPrice(pcm.getPrice());
        product.setQuantity(pcm.getQuantity());
        product.setNumber(pcm.getNumber());
        product.setBarcode(pcm.getBarcode());

        ProductEntity createdProduct = productsRepository.save(product);
        return createdProduct;
    }

    @PutMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductEntity editProduct(@RequestParam(name = "productId", required = true) Long productId, ProductModel pcm) {

        ProductEntity product = new ProductEntity();
        product.setProductId(productId);
        product.setName(pcm.getName());
        product.setPrice(pcm.getPrice());
        product.setQuantity(pcm.getQuantity());
        product.setNumber(pcm.getNumber());
        product.setBarcode(pcm.getBarcode());

        ProductEntity editedProduct = productsRepository.save(product);
        return editedProduct;
    }

    @DeleteMapping(value = "/products/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean deleteProduct(@PathVariable("productId") Long productId) {

        ProductEntity product = productsRepository.findByProductId(productId);

        try {
            productsRepository.delete(product);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
