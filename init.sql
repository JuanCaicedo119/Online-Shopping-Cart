DROP DATABASE IF EXISTS coffeeshop;

CREATE DATABASE coffeeshop;
USE coffeeshop;

CREATE TABLE CUSTOMERS (
	id int auto_increment PRIMARY KEY,
    first_name varchar(30),
    last_name varchar(30),
    phone_number varchar(10)
);

CREATE TABLE CATEGORIES (
	id int PRIMARY KEY,
    category_name varchar(30),
    category_description varchar(200)
);

CREATE TABLE ORDERS (
	id int PRIMARY KEY,
    customer_id int,
    order_date varchar(30),
    FOREIGN KEY (customer_id) REFERENCES CUSTOMERS(id)
);

CREATE TABLE PRODUCTS (
	id int PRIMARY KEY,
    product_name varchar(30),
    category_id int, 
    unit_price decimal(5,2),
    FOREIGN KEY (category_id) REFERENCES CATEGORIES(id)
);

CREATE TABLE ORDER_DETAILS (
	order_id int, 
    product_id int,
    quantity int,
    FOREIGN KEY (order_id) REFERENCES ORDERS(id),
    FOREIGN KEY (product_id) REFERENCES PRODUCTS(id)
);


-- sample data
insert into customers (id, first_name, last_name, phone_number)
values (1001, 'Juan', 'Caicedo', '1234567891');

insert into orders (id, customer_id, order_date)
values (879, '1001', "2022-08-12");

select * from customers;
select * from orders;