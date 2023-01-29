package com.example.project.repository;

import com.example.project.entity.NomalCommunityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface NomalCommunityRepository extends JpaRepository<NomalCommunityEntity, String> {
}
