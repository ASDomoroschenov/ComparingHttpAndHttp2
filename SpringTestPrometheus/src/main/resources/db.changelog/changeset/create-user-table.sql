create table if not exists table_user
(
    id        bigserial primary key,
    firstname varchar(20) not null,
    lastname  varchar(20) not null,
    weight    numeric(3)  not null,
    height    numeric(3)  not null
);