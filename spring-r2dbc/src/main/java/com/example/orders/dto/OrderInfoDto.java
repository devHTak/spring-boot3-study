package com.example.orders.dto;

public record OrderInfoDto(Long orderId,
                           Long memberId,
                           Long itemId,
                           String memberName,
                           String itemName) {
}
