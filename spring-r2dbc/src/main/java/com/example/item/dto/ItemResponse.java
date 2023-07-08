package com.example.item.dto;

import com.example.item.Item;

public record ItemResponse(Long id, String name) {

    public static ItemResponse from(Item item) {
        return new ItemResponse(
                item.getId(),
                item.getName()
        );
    }

}
