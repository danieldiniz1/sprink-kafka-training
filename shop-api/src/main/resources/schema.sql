create table tb_shops
(
    id         bigserial primary key,
    identifier varchar not null,
    status     varchar not null,
    date_shop  date
);
create table tb_shop_items
(
    id                 bigserial primary key,
    p_product_identifier varchar(100) not null,
    amount             int          not null,
    price              float        not null,
    shop_id            bigint REFERENCES tb_shops (id)
);