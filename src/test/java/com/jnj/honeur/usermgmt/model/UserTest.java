package com.jnj.honeur.usermgmt.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class UserTest {

    private User user;

    @Before
    public void setup() {
        this.user = new User();
        user.setId(1);
        user.setName("username");

        Role role = new Role();
        role.setId(1);
        role.setName("role");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setUserRoles(userRoles);
        user.setUserRoles(userRoles);
    }

    @Test
    public void serializeDeserialize() throws IOException {
        String serializedUser = new ObjectMapper().writeValueAsString(user);

        System.out.println(serializedUser);

        assertThat(serializedUser, containsString("userRoles"));
        assertThat(serializedUser, containsString("user"));
        assertThat(serializedUser, containsString("role"));

        User deserializedUser = new ObjectMapper().readValue(serializedUser, User.class);

        assertEquals(user, deserializedUser);


    }
}