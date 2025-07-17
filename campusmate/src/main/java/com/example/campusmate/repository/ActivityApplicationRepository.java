package com.example.campusmate.repository;

import com.example.campusmate.entity.ActivityApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityApplicationRepository extends JpaRepository<ActivityApplication, Long> {
    boolean existsByActivityIdAndUserId(Long activityId, Long userId);
}