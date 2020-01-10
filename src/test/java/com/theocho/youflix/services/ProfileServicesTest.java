package com.theocho.youflix.services;

import com.theocho.youflix.YouflixApplication;
import com.theocho.youflix.exceptions.LoginException;
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
        // Given
        when(profileRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(testProfile));
        when(profileRepository.save(testProfile)).thenReturn(otherProfile);
        // When
        Profile actual = profileServices.updateProfile(1L, otherProfile);
        // Then
        verify(profileRepository, times(1)).findById(1L);
        verify(profileRepository,times(1)).delete(testProfile);
        verify(profileRepository,times(1)).save(testProfile);
        Assert.assertEquals(otherProfile, actual);
    }

    @Test
    public void deleteProfile() {
        // Given
        when(profileRepository.existsById(1L)).thenReturn(false);
        // When
        profileServices.deleteProfile(1L);
        // Then
        verify(profileRepository, times(1)).deleteById(1L);
        verify(profileRepository,times(1)).existsById(1L);
        Assert.assertTrue(profileServices.deleteProfile(1L));
    }

    @Test
    public void login() throws LoginException {
        // Given
        when(profileRepository.findProfileByUsername("testUser")).thenReturn(testProfile);
        // When
        Profile actual = profileServices.login(testProfile);
        // Then
        verify(profileRepository, times(1)).findProfileByUsername("testUser");
        Assert.assertEquals(testProfile,actual);
    }

}
