package com.theocho.youflix.services;

import com.theocho.youflix.YouflixApplication;
import com.theocho.youflix.models.Profile;
import com.theocho.youflix.repositories.ProfileRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = YouflixApplication.class)
public class ProfileServicesTest {

    @Mock
    private ProfileRepository profileRepository;

    @InjectMocks
    private ProfileServices profileServices;

    private Profile testProfile;
    private Profile otherProfile;

    @Before
    public void setUp() throws Exception {
        testProfile = new Profile("testUser", "testPass1", "test@test.com");
        testProfile.setId(1L);

        otherProfile = new Profile("otherUser", "otherPass1", "other@test.com");
        otherProfile.setId(2L);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create_a_profile_Test() {
        // Given
        when(profileRepository.save(testProfile)).thenReturn(testProfile);
        // When
        Profile actualProfile = profileServices.createProfile(testProfile);
        // Then
        verify(profileRepository, times(1)).save(testProfile);
        Assert.assertEquals(testProfile, actualProfile);
    }

    @Test
    public void findAll() {
        // Given
        List<Profile> expected = new ArrayList<>(Arrays.asList(testProfile, otherProfile));
        when(profileRepository.findAll()).thenReturn(stubProfileList());
        // When
        List<Profile> actual = (List<Profile>) profileServices.findAll();
        // Then
        verify(profileRepository,times(1)).findAll();
        Assert.assertEquals(expected,actual);
    }

    private List<Profile> stubProfileList(){
        return Arrays.asList(testProfile,otherProfile);
    }

    @Test
    public void findProfileById() {
        // Given
        Long testProfileId = 1L;
        when(profileRepository.findById(testProfileId)).thenReturn(java.util.Optional.ofNullable(testProfile));
        // When
        Profile actualProfile = profileServices.findProfileById(testProfileId);
        // Then
        verify(profileRepository, times(1)).findById(testProfileId);
        Assert.assertEquals(testProfile,actualProfile);
    }

    @Test
    public void updateProfile() {
        Assert.assertEquals(1,2);
    }

    @Test
    public void deleteProfile() {
        Assert.assertEquals(1,2);
    }

    @Test
    public void login() {
        Assert.assertEquals(1,2);
    }

}
