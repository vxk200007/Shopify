create table inventory_items(
item_id number not null,
item_name varchar2(50) not null,
item_description varchar2(140) not null
);

insert into inventory_items values(1,'Item1','Item1 description');