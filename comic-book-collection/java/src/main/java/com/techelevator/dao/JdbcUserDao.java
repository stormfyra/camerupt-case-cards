package com.techelevator.dao;

import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcUserDao implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int findIdByUsername(String username) {
        return jdbcTemplate.queryForObject("select user_id from users where username = ?", int.class, username);
    }

	@Override
	public User getUserById(Long userId) {
		String sql = "SELECT * FROM users\n" +
                "JOIN profile_pokemons ON users.profile_pokemon = profile_pokemons.image_id\n" +
                "WHERE user_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
		if(results.next()) {
			return mapRowToUser(results);
		} else {
			throw new RuntimeException("userId "+userId+" was not found.");
		}
	}

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users\n" +
                "JOIN profile_pokemons ON users.profile_pokemon = profile_pokemons.image_id\n";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            User user = mapRowToUser(results);
            users.add(user);
        }

        return users;
    }

    @Override
    public User findByUsername(String username) throws UsernameNotFoundException {
        for (User user : this.findAll()) {
            if( user.getUsername().toLowerCase().equals(username.toLowerCase())) {
                return user;
            }
        }
        throw new UsernameNotFoundException("User " + username + " was not found.");
    }

    @Override
    public boolean create(String username, String password, String role) {
        boolean userCreated = false;

        // create user
        String insertUser = "insert into users (username,password_hash,role,profile_pokemon) values(?,?,?,1)";
        String password_hash = new BCryptPasswordEncoder().encode(password);
        String ssRole = "ROLE_" + role.toUpperCase();

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        String id_column = "user_id";
        userCreated = jdbcTemplate.update(con -> {
                    PreparedStatement ps = con.prepareStatement(insertUser, new String[]{id_column});
                    ps.setString(1, username);
                    ps.setString(2, password_hash);
                    ps.setString(3, ssRole);
                    return ps;
                }
                , keyHolder) == 1;
        int newUserId = (int) keyHolder.getKeys().get(id_column);

        return userCreated;
    }

    @Override
    public void updateUserProfile(String email, String fullName, String shippingAddress, String bio, int userId, String pokemonName) {
        if (email.length() == 0) {
            email = null;
        }
        if (fullName.length() == 0) {
            fullName = null;
        }
        if (shippingAddress.length() == 0) {
            shippingAddress = null;
        }
        if (bio.length() == 0) {
            bio = null;
        }
        String sqlQuery = "UPDATE users SET\n" +
                "\temail = ?,\n" +
                "\tfull_name = ?,\n" +
                "\tshipping_address = ?,\n" +
                "\tbio = ?\n" +
                "\tprofile_pokemon = (SELECT image_id from profile_pokemons WHERE pokemon = ?)\n" +
                "WHERE user_id = ?;";
        jdbcTemplate.update(sqlQuery, email, fullName, shippingAddress, bio, userId, pokemonName);
    }

    private User mapRowToUser(SqlRowSet rs) {
        User user = new User();
        user.setId(rs.getLong("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password_hash"));
        user.setAuthorities(rs.getString("role"));
        user.setActivated(true);
        user.setEmail(rs.getString("email"));
        user.setFullName(rs.getString("full_name"));
        user.setShippingAddress(rs.getString("shipping_address"));
        user.setBio(rs.getString("bio"));
        user.setProfilePokemon(rs.getString("pokemon"));
        return user;
    }
}
