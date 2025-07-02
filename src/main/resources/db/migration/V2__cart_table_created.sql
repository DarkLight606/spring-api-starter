create table cart
(
    id          BINARY(16) default (uuid_to_bin(uuid())) not null
        primary key,
    dateCreated date       default (curdate())           not null
);

