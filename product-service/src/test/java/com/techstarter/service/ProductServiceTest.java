package com.techstarter.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.techstarter.dto.request.ProductRequest;
import com.techstarter.dto.response.ProductResponse;
import com.techstarter.model.Product;
import com.techstarter.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ProductService.class})
@ExtendWith(SpringExtension.class)
class ProductServiceTest {
    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    /**
     * Method under test: {@link ProductService#createProduct(ProductRequest)}
     */
    @Test
    void testCreateProduct() {
        Product product = new Product();
        product.setDescription("The characteristics of someone or something");
        product.setId("42");
        product.setName("Name");
        product.setPrice(BigDecimal.valueOf(42L));
        when(productRepository.save((Product) any())).thenReturn(product);
        productService.createProduct(new ProductRequest());
        verify(productRepository).save((Product) any());
    }

    /**
     * Method under test: {@link ProductService#createProduct(ProductRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateProduct2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techstarter.service.ProductService.createProduct(ProductService.java:23)
        //   See https://diff.blue/R013 to resolve this issue.

        Product product = new Product();
        product.setDescription("The characteristics of someone or something");
        product.setId("42");
        product.setName("Name");
        product.setPrice(BigDecimal.valueOf(42L));
        when(productRepository.save((Product) any())).thenReturn(product);
        productService.createProduct(null);
    }

    /**
     * Method under test: {@link ProductService#getAllProducts()}
     */
    @Test
    void testGetAllProducts() {
        when(productRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(productService.getAllProducts().isEmpty());
        verify(productRepository).findAll();
    }

    /**
     * Method under test: {@link ProductService#getAllProducts()}
     */
    @Test
    void testGetAllProducts2() {
        Product product = new Product();
        product.setDescription("The characteristics of someone or something");
        product.setId("42");
        product.setName("Name");
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        product.setPrice(valueOfResult);

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        when(productRepository.findAll()).thenReturn(productList);
        List<ProductResponse> actualAllProducts = productService.getAllProducts();
        assertEquals(1, actualAllProducts.size());
        ProductResponse getResult = actualAllProducts.get(0);
        assertEquals("The characteristics of someone or something", getResult.getDescription());
        BigDecimal price = getResult.getPrice();
        assertSame(valueOfResult, price);
        assertEquals("Name", getResult.getName());
        assertEquals("42", getResult.getId());
        assertEquals("42", price.toString());
        verify(productRepository).findAll();
    }

    /**
     * Method under test: {@link ProductService#getAllProducts()}
     */
    @Test
    void testGetAllProducts3() {
        Product product = new Product();
        product.setDescription("The characteristics of someone or something");
        product.setId("42");
        product.setName("Name");
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        product.setPrice(valueOfResult);

        Product product1 = new Product();
        product1.setDescription("Description");
        product1.setId("Id");
        product1.setName("com.techstarter.model.Product");
        product1.setPrice(BigDecimal.valueOf(42L));

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product);
        when(productRepository.findAll()).thenReturn(productList);
        List<ProductResponse> actualAllProducts = productService.getAllProducts();
        assertEquals(2, actualAllProducts.size());
        ProductResponse getResult = actualAllProducts.get(0);
        BigDecimal price = getResult.getPrice();
        assertEquals(valueOfResult, price);
        ProductResponse getResult1 = actualAllProducts.get(1);
        BigDecimal price1 = getResult1.getPrice();
        assertEquals(price, price1);
        assertEquals("Description", getResult.getDescription());
        assertEquals("com.techstarter.model.Product", getResult.getName());
        assertEquals("The characteristics of someone or something", getResult1.getDescription());
        assertEquals("Id", getResult.getId());
        assertEquals("42", getResult1.getId());
        assertEquals("Name", getResult1.getName());
        assertEquals("42", price1.toString());
        assertEquals("42", price.toString());
        verify(productRepository).findAll();
    }

    /**
     * Method under test: {@link ProductService#getAllProducts()}
     */
    @Test
    void testGetAllProducts4() {
        Product product = mock(Product.class);
        when(product.getDescription()).thenReturn("The characteristics of someone or something");
        when(product.getId()).thenReturn("42");
        when(product.getName()).thenReturn("Name");
        when(product.getPrice()).thenReturn(BigDecimal.valueOf(42L));
        doNothing().when(product).setDescription((String) any());
        doNothing().when(product).setId((String) any());
        doNothing().when(product).setName((String) any());
        doNothing().when(product).setPrice((BigDecimal) any());
        product.setDescription("The characteristics of someone or something");
        product.setId("42");
        product.setName("Name");
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        product.setPrice(valueOfResult);

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        when(productRepository.findAll()).thenReturn(productList);
        List<ProductResponse> actualAllProducts = productService.getAllProducts();
        assertEquals(1, actualAllProducts.size());
        ProductResponse getResult = actualAllProducts.get(0);
        assertEquals("The characteristics of someone or something", getResult.getDescription());
        BigDecimal price = getResult.getPrice();
        assertEquals(valueOfResult, price);
        assertEquals("Name", getResult.getName());
        assertEquals("42", getResult.getId());
        assertEquals("42", price.toString());
        verify(productRepository).findAll();
        verify(product).getDescription();
        verify(product).getId();
        verify(product).getName();
        verify(product).getPrice();
        verify(product).setDescription((String) any());
        verify(product).setId((String) any());
        verify(product).setName((String) any());
        verify(product).setPrice((BigDecimal) any());
    }
}

