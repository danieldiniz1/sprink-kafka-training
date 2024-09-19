create schema if not exists shop;
create table tb_product (
                              id bigserial primary key,
                              product_identifier varchar(100) not null,
                              amount int not null
);