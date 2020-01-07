package com.theocho.youflix.controllers;

import com.theocho.youflix.models.Profile;
import com.theocho.youflix.services.ProfileServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080", "http://localhost"})
public class ProfileController {

    private ProfileServices profileServices;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfileController.class);

    @Autowired
    public ProfileController(ProfileServices profileServices) {
        this.profileServices = profileServices;
    }

    @PostMapping("/profile")
    public ResponseEntity createProfile(@RequestBody Profile profile) {
        return new ResponseEntity<Profile>(profileServices.createProfile(profile), HttpStatus.CREATED);
    }

    @PutMapping("/profile")
    public ResponseEntity findAll() {
        return new ResponseEntity(profileServices.findAll(), HttpStatus.OK);
    }

    @PutMapping("/profile")
    public ResponseEntity findProfileById(@RequestBody Long id) {
        return new ResponseEntity(profileServices.findProfileById(id), HttpStatus.OK);
    }

    @PutMapping("/profile")
    public ResponseEntity updateProfile() {
        return null;
    }

}
