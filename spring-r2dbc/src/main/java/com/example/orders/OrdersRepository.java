package com.example.orders;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface OrdersRepository extends ReactiveCrudRepository<Orders, Long> {
    @Query("""
            SELECT o.id
                , m.id AD memberId
                , o.item_id as itemId
            FROM ord o,
            INNER JOIN MEMBER M
                ON o.member_id = m.id
            """)
    Flux<Orders> findOrderJoinMember();
}
