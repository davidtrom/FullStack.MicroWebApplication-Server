package com.theocho.youflix.controllers;

import com.theocho.youflix.models.Profile;
import com.theocho.youflix.models.Video;
import com.theocho.youflix.repositories.ProfileRepository;
import com.theocho.youflix.repositories.VideoRepository;
import com.theocho.youflix.services.ProfileServices;
import com.theocho.youflix.services.VideoServices;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@WebMvcTest(ProfileController.class)
public class ProfileControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    ProfileServices profileServices;

    @InjectMocks
    ProfileController profileController;

    @MockBean
    ProfileRepository profileRepository;
    Profile testProfile;

    @Before
    public void setUp() throws Exception {
        testProfile = new Profile("testUser","testPass1","test@test.com");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createProfile() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findProfileById() {
    }

    @Test
    public void updateProfile() {
    }

    @Test
    public void deleteProfile() {
    }

    @Test
    public void login() {
    }
}
