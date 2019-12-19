package com.theocho.youflix.repositories;

import com.theocho.youflix.models.VideoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<VideoModel,String> {
}
