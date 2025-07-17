package com.example.campusmate.repository;

import com.example.campusmate.entity.ActivityLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityLikeRepository extends JpaRepository<ActivityLike, Long> {
    boolean existsByActivityIdAndUserId(Long activityId, Long userId);
}