package com.mattcoding.jpa.repositories;

import com.mattcoding.jpa.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface videoRepository extends JpaRepository<Video, Integer> {
}
