DROP TABLE IF EXISTS item;
create table item (
                      id bigint not null auto_increment primary key ,
                      name varchar(255),
                      price integer not null,
                      stock integer not null
);