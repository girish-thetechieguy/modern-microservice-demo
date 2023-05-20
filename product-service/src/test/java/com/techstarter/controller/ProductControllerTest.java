package com.techstarter.controller;

import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techstarter.dto.request.ProductRequest;
import com.techstarter.model.Product;
import com.techstarter.repository.ProductRepository;
import com.techstarter.service.ProductService;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ProductController.class, ProductService.class})
@ExtendWith(SpringExtension.class)
class ProductControllerTest {
    @Autowired
    private ProductController productController;

    @MockBean
    private ProductRepository productRepository;

    /**
     * Method under test: {@link ProductController#createProduct(ProductRequest)}
     */
    @Test
    void testCreateProduct() throws Exception {
        when(productRepository.findAll()).thenReturn(new ArrayList<>());

        ProductRequest productRequest = new ProductRequest();
        productRequest.setDescription("The characteristics of someone or something");
        productRequest.setName("Name");
        productRequest.setPrice(BigDecimal.valueOf(42L));
        String content = (new ObjectMapper()).writeValueAsString(productRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ProductController#createProduct(ProductRequest)}
     */
    @Test
    void testCreateProduct2() throws Exception {
        Product product = new Product();
        product.setDescription("The characteristics of someone or something");
        product.setId("42");
        product.setName("?");
        product.setPrice(BigDecimal.valueOf(42L));

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        when(productRepository.findAll()).thenReturn(productList);

        ProductRequest productRequest = new ProductRequest();
        productRequest.setDescription("The characteristics of someone or something");
        productRequest.setName("Name");
        productRequest.setPrice(BigDecimal.valueOf(42L));
        String content = (new ObjectMapper()).writeValueAsString(productRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":\"42\",\"name\":\"?\",\"description\":\"The characteristics of someone or something\",\"price\":42}]"));
    }

    /**
     * Method under test: {@link ProductController#createProduct(ProductRequest)}
     */
    @Test
    void testCreateProduct3() throws Exception {
        Product product = new Product();
        product.setDescription("The characteristics of someone or something");
        product.setId("42");
        product.setName("?");
        product.setPrice(BigDecimal.valueOf(42L));

        Product product1 = new Product();
        product1.setDescription("?");
        product1.setId("?");
        product1.setName("Name");
        product1.setPrice(BigDecimal.valueOf(42L));

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product);
        when(productRepository.findAll()).thenReturn(productList);

        ProductRequest productRequest = new ProductRequest();
        productRequest.setDescription("The characteristics of someone or something");
        productRequest.setName("Name");
        productRequest.setPrice(BigDecimal.valueOf(42L));
        String content = (new ObjectMapper()).writeValueAsString(productRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":\"?\",\"name\":\"Name\",\"description\":\"?\",\"price\":42},{\"id\":\"42\",\"name\":\"?\",\"description\":\"The"
                                        + " characteristics of someone or something\",\"price\":42}]"));
    }

    /**
     * Method under test: {@link ProductController#fetchAllProducts()}
     */
    @Test
    void testFetchAllProducts() throws Exception {
        when(productRepository.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/product");
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ProductController#fetchAllProducts()}
     */
    @Test
    void testFetchAllProducts2() throws Exception {
        Product product = new Product();
        product.setDescription("The characteristics of someone or something");
        product.setId("42");
        product.setName("?");
        product.setPrice(BigDecimal.valueOf(42L));

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        when(productRepository.findAll()).thenReturn(productList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/product");
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":\"42\",\"name\":\"?\",\"description\":\"The characteristics of someone or something\",\"price\":42}]"));
    }

    /**
     * Method under test: {@link ProductController#fetchAllProducts()}
     */
    @Test
    void testFetchAllProducts3() throws Exception {
        Product product = new Product();
        product.setDescription("The characteristics of someone or something");
        product.setId("42");
        product.setName("?");
        product.setPrice(BigDecimal.valueOf(42L));

        Product product1 = new Product();
        product1.setDescription("?");
        product1.setId("?");
        product1.setName("Name");
        product1.setPrice(BigDecimal.valueOf(42L));

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product);
        when(productRepository.findAll()).thenReturn(productList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/product");
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":\"?\",\"name\":\"Name\",\"description\":\"?\",\"price\":42},{\"id\":\"42\",\"name\":\"?\",\"description\":\"The"
                                        + " characteristics of someone or something\",\"price\":42}]"));
    }
}

