package com.example.config;

import com.example.member.Member;
import com.example.orders.Orders;
import com.example.relational.order.RelationalOrders;
import io.r2dbc.spi.Row;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.time.LocalDateTime;

@ReadingConverter
public class OrderReadingConverter implements Converter<Row, RelationalOrders> {

    @Override
    public RelationalOrders convert(Row source) {
        var member = Member.builder()
                .id((Long)source.get("memberId"))
                .name((String) source.get("memberName"))
                .createdAt((LocalDateTime) source.get("memberCreatedAt"))
                .build();

        return RelationalOrders.builder()
                .id((Long) source.get("id"))
                .member(member)
                .createdAt((LocalDateTime) source.get("createdAt"))
                .build();
    }
}
