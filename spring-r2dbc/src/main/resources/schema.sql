create table item (
    id BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(500) NOT NULL,
    created_at datetime NOT NULL
);

create table member (
    id BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(500) NOT NULL,
    created_at datetime NOT NULL
);

create table orders (
    id BIGINT AUTO_INCREMENT NOT NULL,
    member_id BIGINT NOT NULL,
    item_id BIGINT NOT NULL,
    created_at datetime NOT NULL
);

create table relational_orders (
    id BIGINT AUTO_INCREMENT NOT NULL,
    member_id BIGINT NOT NULL,
    item_id BIGINT NOT NULL,
    created_at datetime NOT NULL
);
