package com.example.project.repository;

import com.example.project.entity.MainCommunityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MainCommunityRepository extends JpaRepository<MainCommunityEntity, Long> {
    @Modifying
    @Query(value = "update MainCommunityEntity b set b.hits=b.hits+1 where b.id=:id")
    void updateHits(@Param("id") Long id);
}
