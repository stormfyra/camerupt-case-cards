
INSERT INTO profile_pokemons (pokemon) VALUES ('Camerupt');

-- insert users table data
INSERT INTO users (user_id, username, password_hash, role, email, profile_pokemon) VALUES (1, 'user',
    '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'fake@fake.com', 1);
INSERT INTO users (user_id, username, password_hash, role, email, profile_pokemon) VALUES (3, 'admin',
    '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN','fake@fake.com', 1);
INSERT INTO users (user_id, username, password_hash, role, email, full_name, shipping_address, bio, profile_pokemon)
    VALUES (2, 'testuser', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER','fake@fake.com',
    'User User', '1000 User Ave NE WA', 'Hello! Im a friendly user.', 1);

ALTER SEQUENCE seq_user_id RESTART WITH 4;

-- insert ??? table data
INSERT INTO card (card_id, name, large_image, small_image) VALUES ('dp3-3', 'Charizard', 'https://images.pokemontcg.io/dp3/3_hires.png',
    'https://images.pokemontcg.io/dp3/3.png');
INSERT INTO card (card_id, name, large_image, small_image) VALUES ('pl1-1', 'Ampharos', 'https://images.pokemontcg.io/pl1/1_hires.png',
    'https://images.pokemontcg.io/pl1/1.png');
INSERT INTO card (card_id, name, large_image, small_image) VALUES ('det1-1', 'Bulbasaur', 'https://images.pokemontcg.io/det1/1_hires.png',
    'https://images.pokemontcg.io/det1/1.png');

INSERT INTO collection (user_id, name, description) VALUES (1, 'Three Starters', 'A test of our database');
INSERT INTO collection (user_id, name, description) VALUES (3, 'Just Bulbasaur',
    'This collection should only have Bulbasaur');
INSERT INTO collection (user_id, name, description, is_private) VALUES (3, 'Set To Private',
    'This collection should be set to private', true);

INSERT INTO collection_card (collection_id, card_id, quantity) VALUES (1, 'dp3-3', 5);
INSERT INTO collection_card (collection_id, card_id, quantity) VALUES (1, 'pl1-1', 5);
INSERT INTO collection_card (collection_id, card_id, quantity) VALUES (1, 'det1-1', 5);
INSERT INTO collection_card (collection_id, card_id) VALUES (2, 'det1-1');
INSERT INTO collection_card (collection_id, card_id) VALUES (3, 'dp3-3');
INSERT INTO collection_card (collection_id, card_id) VALUES (3, 'det1-1');

INSERT INTO profile_pokemons (pokemon) VALUES ('Bulbasaur');
INSERT INTO profile_pokemons (pokemon) VALUES ('Squirtle');
INSERT INTO profile_pokemons (pokemon) VALUES ('Charmander');
INSERT INTO profile_pokemons (pokemon) VALUES ('Pikachu');
INSERT INTO profile_pokemons (pokemon) VALUES ('Chikorita');
INSERT INTO profile_pokemons (pokemon) VALUES ('Totodile');
INSERT INTO profile_pokemons (pokemon) VALUES ('Cyndaquil');
INSERT INTO profile_pokemons (pokemon) VALUES ('Treecko');
INSERT INTO profile_pokemons (pokemon) VALUES ('Mudkip');
INSERT INTO profile_pokemons (pokemon) VALUES ('Torchic');
