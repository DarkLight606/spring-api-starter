create table cart_items
(
    id         bigint auto_increment
        primary key,
    cart_uuid  binary(16) default (uuid_to_bin(uuid())) not null,
    product_id bigint                                   not null,
    quantity   int        default 1                     not null,
    constraint cart_items_cart_product_unique
        unique (cart_uuid, product_id),
    constraint cart_items_cart_id_fk
        foreign key (cart_uuid) references cart (id)
            on delete cascade,
    constraint cart_items_products_id_fk
        foreign key (product_id) references products (id)
            on delete cascade
);

