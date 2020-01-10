package com.theocho.youflix.services;

import com.theocho.youflix.exceptions.LoginException;
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

    public Profile createProfile(Profile profile) throws NewUserException{

        // Searching if requested profile name already exists
        Profile searchProfile = profileRepository.findProfileByUsername(profile.getUsername());

        // If profile does exist (is not null) then send exception
        if(searchProfile != null)
            throw new NewUserException("Profile already exists");

        // Checking if username is valid
        if(!InfoValidation.validUsername(profile.getUsername()))
            throw new NewUserException("Username is invalid");

        // Checking if password is valid
        if(!InfoValidation.validPassword(profile.getPassword()))
            throw new NewUserException("Password is invalid");

        // Checking if email is valid
        if(!InfoValidation.validEmail(profile.getEmailAddress()))
            throw new NewUserException("Email is invalid");

        return profileRepository.save(profile);
    }

    public Iterable<Profile> findAll() {
        return profileRepository.findAll();
    }

    public Profile findProfileById(Long id) {
        return profileRepository.findById(id).get();
    }

    public Profile updateProfile(Long id, Profile profileInfoHolder) {
        Profile originalProfile = profileRepository.findById(id).get();
        profileRepository.delete(originalProfile);

        // If the original profile username does not equal the holder's then change the username
        if(!originalProfile.getUsername().equals(profileInfoHolder.getUsername()))
            originalProfile.setUsername(profileInfoHolder.getUsername());

        // If the original profile password does not equal the holder's then change the password
        if(!originalProfile.getPassword().equals(profileInfoHolder.getPassword()))
            originalProfile.setPassword(profileInfoHolder.getPassword());

        // If the original profile email does not equal the holder's then change the email
        if(!originalProfile.getEmailAddress().equals(profileInfoHolder.getEmailAddress()))
            originalProfile.setEmailAddress(profileInfoHolder.getEmailAddress());

        return profileRepository.save(originalProfile);
    }

    public Boolean deleteProfile(Long id) {
        profileRepository.deleteById(id);
        return !profileRepository.existsById(id);
    }

    public Profile login(Profile profile) throws LoginException {
        Profile foundProfile = profileRepository.findProfileByUsername(profile.getUsername());

        if(foundProfile == null)
            throw new LoginException("Profile does not exist");
        if(foundProfile.getPassword().equals(profile.getPassword())) {
            return foundProfile;
        } else
            throw new LoginException("Password does not match");
    }


}
