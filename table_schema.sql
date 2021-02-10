-- dealership.carlot definition

-- Drop table

-- DROP TABLE dealership.carlot;

CREATE TABLE dealership.carlot (
	car_id serial NOT NULL,
	make varchar NOT NULL,
	model varchar NOT NULL,
	"year" varchar NOT NULL,
	color varchar NOT NULL,
	"condition" varchar NOT NULL,
	price int8 NOT NULL,
	status varchar NOT NULL DEFAULT 'Available'::character varying,
	"owner" varchar NOT NULL DEFAULT 'None'::character varying,
	CONSTRAINT carlot_pk PRIMARY KEY (car_id)
);

CREATE TABLE dealership.customer (
	customer_id serial NOT NULL,
	first_name varchar NOT NULL,
	last_name varchar NOT NULL,
	drivers_license int8 NOT NULL,
	email varchar NOT NULL,
	"password" varchar NOT NULL,
	CONSTRAINT customer_pk PRIMARY KEY (customer_id)
);

CREATE TABLE dealership.employee (
	employee_id serial NOT NULL,
	first_name varchar NOT NULL,
	last_name varchar NOT NULL,
	email varchar NOT NULL,
	"password" varchar NULL,
	CONSTRAINT employee_pk PRIMARY KEY (employee_id)
);


CREATE TABLE dealership.offers (
	offer_id int4 NOT NULL DEFAULT nextval('dealership.bids_bid_id_seq'::regclass),
	"date" date NOT NULL,
	customer_id int4 NOT NULL,
	car_id int4 NOT NULL,
	offer_price int8 NOT NULL,
	pending_offer varchar NOT NULL DEFAULT 'Pending'::character varying,
	CONSTRAINT bids_pk PRIMARY KEY (offer_id)
);


-- dealership.offers foreign keys

ALTER TABLE dealership.offers ADD CONSTRAINT bids_car_id_fk FOREIGN KEY (car_id) REFERENCES dealership.carlot(car_id);
ALTER TABLE dealership.offers ADD CONSTRAINT bids_customer_id_fk FOREIGN KEY (customer_id) REFERENCES dealership.customer(customer_id);


CREATE TABLE dealership.customercars (
	car_id int4 NOT NULL,
	customer_id int4 NOT NULL,
	date_purchased date NOT NULL,
	make varchar(255) NOT NULL,
	model varchar(255) NOT NULL,
	"year" int4 NOT NULL,
	color varchar(255) NOT NULL,
	payments_left int8 NOT NULL,
	CONSTRAINT carsowned_pk PRIMARY KEY (car_id)
);


-- dealership.customercars foreign keys

ALTER TABLE dealership.customercars ADD CONSTRAINT carsowned_fk FOREIGN KEY (customer_id) REFERENCES dealership.customer(customer_id);