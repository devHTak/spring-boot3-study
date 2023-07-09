package com.example.item;

import com.example.item.dto.ItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public Flux<ItemResponse> getAll() {
        return itemRepository.findAll()
                .map(ItemResponse::from);
    }

    public Mono<ItemResponse> getById(Long id) {
        return itemRepository.findById(id)
                .map(ItemResponse::from);
    }

    public Mono<Item> save(String itemName) {
        Item item = Item.builder()
                .name(itemName)
                .createdAt(LocalDateTime.now())
                .build();

        return itemRepository.save(item);
    }

    public Flux<ItemResponse> findByName(String name) {
        return itemRepository.findByName(name)
                .map(ItemResponse::from);
    }
}
