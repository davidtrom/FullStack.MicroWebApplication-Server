package com.theocho.youflix.repositories;

import com.theocho.youflix.models.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfileRepository extends CrudRepository<Profile,Long> {
    Profile findProfileByUsername(String username);
}
