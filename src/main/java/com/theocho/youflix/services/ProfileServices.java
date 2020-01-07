package com.theocho.youflix.services;


import com.theocho.youflix.models.Profile;
import com.theocho.youflix.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProfileServices {

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileServices(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile createProfile(String username, String password, String email) {
        return new Profile(username, password, email);
    }

    public Iterable<Profile> findAll() {
        return profileRepository.findAll();
    }

    public Optional<Profile> findProfileById(Long id) {
        return profileRepository.findById(id);
    }

    public Profile updateProfile(Long id, Profile newProfileInfo) {
        return null;
    }

    public Boolean deleteProfile(Long id) {
        profileRepository.deleteById(id);
        return true;
    }

}