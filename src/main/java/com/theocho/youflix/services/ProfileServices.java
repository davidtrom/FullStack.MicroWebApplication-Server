package com.theocho.youflix.services;

import com.theocho.youflix.exceptions.NewUserException;
import com.theocho.youflix.models.Profile;
import com.theocho.youflix.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServices {

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileServices(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile createProfile(String username, String password, String email) throws NewUserException{
        Profile searchProfile = profileRepository.findProfileByUsername(username);
        if(searchProfile != null)
            throw new NewUserException("Profile already exists");
        if(!InfoValidation.validUsername(username))
            throw new NewUserException("Username is invalid");
        if(!InfoValidation.validPassword(password))
            throw new NewUserException("Password is invalid");
        if(!InfoValidation.validEmail(email))
            throw new NewUserException("Email is invalid");
        return new Profile(username, password, email);
    }

    public Iterable<Profile> findAll() {
        return profileRepository.findAll();
    }

    public Profile findProfileById(Long id) {
        return profileRepository.findById(id).get();
    }

    public Profile updateProfile(Long id, Profile profileInfoHolder) {
        Profile originalProfile = profileRepository.findById(id).get();

        // If the original profile username does not equal the holder's then change the username
        if(!originalProfile.getUsername().equals(profileInfoHolder.getUsername()))
            originalProfile.setUsername(profileInfoHolder.getUsername());

        // If the original profile password does not equal the holder's then change the password
        if(!originalProfile.getPassword().equals(profileInfoHolder.getPassword()))
            originalProfile.setPassword(profileInfoHolder.getPassword());

        // If the original profile email does not equal the holder's then change the email
        if(!originalProfile.getEmailAddress().equals(profileInfoHolder.getEmailAddress()))
            originalProfile.setEmailAddress(profileInfoHolder.getEmailAddress());

        return originalProfile;
    }

    public Boolean deleteProfile(Long id) {
        profileRepository.deleteById(id);
        return true;
    }


}