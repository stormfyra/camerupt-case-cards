
-- insert users table data
INSERT INTO users (user_id, username,password_hash,role, email) VALUES (1, 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'fake@fake.com');
INSERT INTO users (user_id, username,password_hash,role, email) VALUES (3, 'admin', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN','fake@fake.com');
ALTER SEQUENCE seq_user_id RESTART WITH 3;

-- insert ??? table data
INSERT INTO card (name, large_image, small_image) VALUES ('Charizard', 'https://images.pokemontcg.io/swsh4/25_hires.png', 'https://images.pokemontcg.io/swsh4/25.png');
INSERT INTO card (name, large_image, small_image) VALUES ('Ampharos', 'https://images.pokemontcg.io/pl1/1.png', 'https://images.pokemontcg.io/pl1/1_hires.png');
INSERT INTO card (name, large_image, small_image) VALUES ('Bulbasaur', 'https://images.pokemontcg.io/det1/1.png', 'https://images.pokemontcg.io/det1/1_hires.png');

INSERT INTO collection (user_id, name, description) VALUES (1, 'Three Starters', 'A test of our database');
INSERT INTO collection (user_id, name, description) VALUES (3, 'Just Bulbasaur', 'This collection should only have Bulbasaur');
INSERT INTO collection (user_id, name, description, private) VALUES (3, 'Set To Private', 'This collection should be set to private', true);

INSERT INTO collection_card (collection_id, card_id) VALUES (1, 1);
INSERT INTO collection_card (collection_id, card_id) VALUES (1, 2);
INSERT INTO collection_card (collection_id, card_id) VALUES (1, 3);
INSERT INTO collection_card (collection_id, card_id) VALUES (2, 2);
INSERT INTO collection_card (collection_id, card_id) VALUES (3, 1);
INSERT INTO collection_card (collection_id, card_id) VALUES (3, 3);
