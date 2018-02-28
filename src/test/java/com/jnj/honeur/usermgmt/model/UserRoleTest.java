package com.jnj.honeur.usermgmt.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserRoleTest {

    @Test
    public void equals() {
        UserRole ur1 = new UserRole();
        ur1.setRole(new Role());
        UserRole ur2 = new UserRole();
        ur2.setRole(new Role());

        assertTrue(ur1.equals(ur1));
        assertFalse(ur1.equals(ur2));
    }
}