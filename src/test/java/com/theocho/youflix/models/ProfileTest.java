package com.theocho.youflix.models;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class ProfileTest {

    private Long id;
    private String username;
    private String password;
    private String email;
    private Profile profile;

    @Before
    public void setup() {
        id = 1L;
        username = "username";
        password = "password";
        email = "username@email.com";

        profile = new Profile(username, password, email);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testId() {
        profile.setId(2L);

        Long actual = profile.getId();
        Long expected = 2L;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetUsername() {
        String actual = profile.getUsername();
        String expected = "username";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testUsername() {
        profile.setUsername("seconduser");

        String actual = profile.getUsername();
        String expected = "seconduser";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testPassword() {
        profile.setPassword("secret");

        String actual = profile.getPassword();
        String expected = "secret";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testEmail() {
        profile.setEmailAddress("seconduser@email.com");

        String actual = profile.getEmailAddress();
        String expected = "seconduser@email.com";

        Assert.assertEquals(actual, expected);
    }

}
