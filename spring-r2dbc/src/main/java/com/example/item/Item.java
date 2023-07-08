package com.example.item;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table
@Getter
@Setter
@Builder
public class Item {
    @Id
    private Long id;
    private String name;
    private LocalDateTime createdAt;
}
