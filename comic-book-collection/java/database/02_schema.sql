DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS card;
DROP TABLE IF EXISTS collection;
DROP TABLE IF EXISTS collection_card;

DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	email varchar(40) NOT NULL,
    full_name varchar(40),
    shipping_address varchar(150),
    bio varchar(800),
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE card (
    card_id SERIAL PRIMARY KEY,
    name varchar(30) NOT NULL,
    large_image varchar(200) NOT NULL,
    small_image varchar(200) NOT NULL
);

CREATE TABLE collection (
    collection_id SERIAL PRIMARY KEY,
    user_id int,
    name varchar(50) NOT NULL,
    description varchar(250),
    private boolean default false,
    CONSTRAINT FK_collection_user FOREIGN KEY(user_id) REFERENCES users(user_id)
);

CREATE TABLE collection_card (
    collection_id int ,
    card_id int,
    CONSTRAINT FK_collection_card_collection FOREIGN KEY(collection_id) REFERENCES collection(collection_id),
    CONSTRAINT FK_collection_card_card FOREIGN KEY(card_id) REFERENCES card(card_id)
);

-- Add seed data in the 03_data.sql script file

-- Add Foreign key constraints in the 04_constraints.sql script file
