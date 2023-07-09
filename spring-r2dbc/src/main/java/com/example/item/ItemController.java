package com.example.item;

import com.example.item.dto.ItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/items")
    public Mono<Item> createItem(@RequestParam String itemName) {
        return itemService.save(itemName);
    }

    @GetMapping("/items/{itemName}")
    public Flux<ItemResponse> getItemByName(@PathVariable String itemName) {
        return itemService.findByName(itemName)
                .doOnNext(itemResponse -> System.out.println("ITEM NAME: " + itemResponse.name()))
                .doOnComplete(() -> System.out.println("END"));
    }
}
