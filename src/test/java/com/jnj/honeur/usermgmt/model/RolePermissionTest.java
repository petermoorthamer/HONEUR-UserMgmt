package com.jnj.honeur.usermgmt.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RolePermissionTest {

    @Test
    public void equals() {
        RolePermission rp1 = new RolePermission();
        RolePermission rp2 = new RolePermission();
        assertTrue(rp1.equals(rp1));
        assertFalse(rp1.equals(rp2));
    }
}