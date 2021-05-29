use stock_manager;

create table stock(
	id varchar(10) primary key not null
);

create table quote(
	id bigint primary key auto_increment not null,
    value double not null,
    date date not null,
    stock_id varchar(10)
);

alter table quote add constraint stock_quote_id foreign key (stock_id) references stock(id);

