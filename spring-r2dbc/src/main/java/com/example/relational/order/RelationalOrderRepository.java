package com.example.relational.order;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface RelationalOrderRepository extends R2dbcRepository<RelationalOrders, Long> {
    @Query("""
                SELECT  o.id as orderId,
                        o.created_at as orderCreatedAt,
                        m.id as memberId,
                        m.name as memberName,
                        m.createdAt as memberCreatedAt
                FROM Relational_Orders o
                INNER JOIN member m
                ON o.member_id = m.id
            """)
    Flux<RelationalOrders> findAllWithMember();
}
