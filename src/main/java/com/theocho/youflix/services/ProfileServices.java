package com.theocho.youflix.services;


import com.theocho.youflix.models.Profile;
import com.theocho.youflix.repositories.ProfileRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class ProfileServices implements UserDetailsService {

    private final ProfileRepository profileRepository;

    public ProfileServices(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Profile profile = profileRepository.findByUserName(username).orElseThrow(() ->
                new UsernameNotFoundException("No Profile Found" + username));
        return new User(profile.getUsername(), profile.getPassword(),
                true, true, true, true,
                getAuthorities());
    }

    private Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }
}