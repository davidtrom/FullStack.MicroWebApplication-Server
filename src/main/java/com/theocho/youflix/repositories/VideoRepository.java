package com.theocho.youflix.repositories;

import com.theocho.youflix.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends CrudRepository<Video,Long> {
}
