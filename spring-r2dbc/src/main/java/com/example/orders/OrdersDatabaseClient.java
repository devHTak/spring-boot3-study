package com.example.orders;

import com.example.item.Item;
import com.example.member.Member;
import com.example.orders.dto.OrderInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
@RequiredArgsConstructor
public class OrdersDatabaseClient {

    private final DatabaseClient databaseClient;

    public Flux<OrderInfoDto> findByMemberId(Member member) {
        var sql = """
                SELECT O.ID AS ORDER_ID
                     , O.ITEM_ID
                     , O.MEMBER_ID
                     , M.NAME AS MEMBER_NAME
                     , I.NAME AS ITEM_NAME
                FROM   ORDERS O
                INNER JOIN MEMBER M
                    ON O.MEMBER_ID = M.ID
                INNER JOIN ITEM I
                    ON O.ITEM_ID = I.ID
                WHERE M.ID = :memberId
                """;
        Flux<OrderInfoDto> result = databaseClient
                .sql(sql)
                .bind("memberId", member.getId())
                .fetch().all()
                .map(row -> new OrderInfoDto(
                        (Long) row.get("ORDER_ID"),
                        (Long) row.get("ITEM_ID"),
                        (Long) row.get("MEMBER_ID"),
                        (String) row.get("MEMBER_NAME"),
                        (String) row.get("ITEM_NAME")
                ));

        return result;
    }
}
