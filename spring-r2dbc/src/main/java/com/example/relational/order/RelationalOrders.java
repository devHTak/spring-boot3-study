package com.example.relational.order;

import com.example.item.Item;
import com.example.member.Member;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RelationalOrders {

    @Id
    private Long id;

    private Long memberId;
    private Long itemId;

    @Transient
    private Member member;

    @Transient
    private Set<Item> items = new HashSet<>();

    private LocalDateTime createdAt;
}
