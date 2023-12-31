package com.example.orders;

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
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

    @Id
    private Long id;
    private Long memberId;
    private Long itemId;
    private LocalDateTime createdAt;

}
