package com.techstarter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techstarter.dto.request.ProductRequest;
import com.techstarter.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
//@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ProductRepository productRepository;

//	@Container
//	//static MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:4.0.10"));
//	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.2.2");
//

//	@DynamicPropertySource
//	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
//		dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
//
//	}

//	@Test
//	void shouldCreateProduct() throws Exception {
//		ProductRequest productRequest = getProductDetails();
//		String productRequestString = objectMapper.writeValueAsString(productRequest);
//		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(productRequestString))
//				.andExpect(status().isCreated());
//		Assertions.assertEquals(2,productRepository.findAll().size());
//	}
//
//	@Test
//	void shouldFetchProduct() throws Exception {
//		ProductRequest productRequest = getProductDetails();
//		String productRequestString = objectMapper.writeValueAsString(productRequest);
//		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content(productRequestString));
//		mockMvc.perform(MockMvcRequestBuilders.get("/api/product"))
//				.andExpect(status().isOk());
//		Assertions.assertEquals(1,productRepository.findAll().size());
//	}
//
//	private ProductRequest getProductDetails() {
//		return ProductRequest.builder()
//				.name("iPhone 13 Pro max")
//				.description("iPhone has very big description")
//				.price(BigDecimal.valueOf(2344.23)
//				).build();
//	}

}
