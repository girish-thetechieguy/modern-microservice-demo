package com.techstarter.inventoryservice.controller;

import com.techstarter.inventoryservice.dto.InventoryResponse;
import com.techstarter.inventoryservice.model.Inventory;
import com.techstarter.inventoryservice.repository.InventoryRepository;
import com.techstarter.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;


    // http://localhost:8083/api/inventory?skuCode=iphone12&iphone13-red
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInstock(@RequestParam List<String> skuCode){
        return inventoryService.isInStock(skuCode);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository){
        return args -> {
            Inventory inventory1 = new Inventory();
            inventory1.setSkuCode("iphone-13");
            inventory1.setQuantity(13);

            Inventory inventory2 = new Inventory();
            inventory2.setSkuCode("iphone-14");
            inventory2.setQuantity(0);

            inventoryRepository.save(inventory1);
            inventoryRepository.save(inventory2);

        };
    }

}
