package com.example.campusmate.repository;

import com.example.campusmate.entity.ActivityFavorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityFavoriteRepository extends JpaRepository<ActivityFavorite, Long> {
    boolean existsByActivityIdAndUserId(Long activityId, Long userId);
}