package com.theocho.youflix.controllers;

import com.theocho.youflix.exceptions.LoginException;
import com.theocho.youflix.exceptions.NewUserException;
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
    public ResponseEntity<?> createProfile(@RequestBody Profile profile) {
        try {
            return new ResponseEntity<>(profileServices.createProfile(profile), HttpStatus.CREATED);
        } catch (NewUserException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/profile")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(profileServices.findAll(), HttpStatus.FOUND);
    }

    @GetMapping("/profile")
    public ResponseEntity<Profile> findProfileById(@RequestBody Long id) {
        return new ResponseEntity<>(profileServices.findProfileById(id), HttpStatus.FOUND);
    }

    @PutMapping("/profile/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody Profile profile) {
        return new ResponseEntity<>(profileServices.updateProfile(id, profile), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/profile")
    public ResponseEntity<Boolean> deleteProfile(@RequestBody Long id) {
        return new ResponseEntity<>(profileServices.deleteProfile(id), HttpStatus.GONE);
    }

    @PostMapping("/profile")
    public ResponseEntity<?> login(@RequestBody Profile profile) {
        try {
            return new ResponseEntity<>(profileServices.login(profile), HttpStatus.I_AM_A_TEAPOT);
        } catch (LoginException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }
}