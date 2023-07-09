package com.example.relational.order;

import com.example.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RelationalOrderDatabaseClient {
    private final DatabaseClient client;

    public Flux<RelationalOrders> findAllWithItems() {
        var sqlWithPost = """
                SELECT 
                    O.ID AS orderId, o.created_at as orderCreatedAt,
                    I.id AS itemId, I.name as itemName, i.created_at as itemCreatedAt 
                FROM RELATIONAL_ORDERS O
                INNER JOIN ITEM I
                    ON O.ITEM_ID = I.ID
                """;

        return client.sql(sqlWithPost)
                .fetch().all()
                .sort(Comparator.comparing(result -> (Long) result.get("orderId"))) // (1)
                .bufferUntilChanged(result -> result.get("orderId")) // (2)
                .map(result -> {
                    var items = result.stream()
                            .map(row -> Item.builder()
                                    .id((Long) row.get("itemId"))
                                    .name((String) row.get("itemName"))
                                    .createdAt((LocalDateTime) row.get("itemCreatedAt"))
                                    .build())
                            .collect(Collectors.toSet());
                    var row = result.get(0);
                    return RelationalOrders.builder()
                            .id((Long) row.get("orderId"))
                            .createdAt((LocalDateTime) row.get("orderCreatedAt"))
                            .items(items)
                            .build();
                });
    }
}
