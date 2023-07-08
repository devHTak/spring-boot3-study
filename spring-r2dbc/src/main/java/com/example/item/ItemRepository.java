package com.example.item;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ItemRepository extends ReactiveCrudRepository<Item, Long> {
    // name 으로 쿼리되는지 확인
    Flux<Item> findByName(String name);
}
