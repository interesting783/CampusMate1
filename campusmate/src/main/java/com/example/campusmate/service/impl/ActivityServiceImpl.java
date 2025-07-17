package com.example.campusmate.service.impl;

import com.example.campusmate.entity.Activity;
import com.example.campusmate.repository.ActivityRepository;
import com.example.campusmate.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import com.example.campusmate.repository.ActivityLikeRepository;
import com.example.campusmate.repository.ActivityFavoriteRepository;
import com.example.campusmate.repository.ActivityApplicationRepository;
import com.example.campusmate.entity.ActivityLike;
import com.example.campusmate.entity.ActivityFavorite;
import com.example.campusmate.entity.ActivityApplication;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private ActivityLikeRepository likeRepository;
    @Autowired
    private ActivityFavoriteRepository favoriteRepository;
    @Autowired
    private ActivityApplicationRepository applicationRepository;

    @Override
    public Activity createActivity(Activity activity) {
        activity.setCreatedAt(LocalDateTime.now());
        activity.setStatus("PUBLISHED");
        return activityRepository.save(activity);
    }

    @Override
    public List<Activity> listActivities(String campus, String type, int page, int size) {
        // 简单实现：返回所有活动，实际可加分页和筛选
        return activityRepository.findAll();
    }

    @Override
    public Activity getActivityDetail(Long activityId) {
        return activityRepository.findById(activityId).orElse(null);
    }

    @Override
    public boolean deleteActivity(Long activityId) {
        activityRepository.deleteById(activityId);
        return true;
    }

    @Override
    public boolean applyForActivity(Long activityId, Long userId, String reason) {
        if (applicationRepository.existsByActivityIdAndUserId(activityId, userId)) {
            return false;
        }
        com.example.campusmate.entity.ActivityApplication app = new com.example.campusmate.entity.ActivityApplication();
        app.setActivityId(activityId);
        app.setUserId(userId);
        app.setReason(reason);
        app.setStatus("PENDING");
        app.setCreatedAt(java.time.LocalDateTime.now());
        applicationRepository.save(app);
        return true;
    }

    @Override
    public String listApplications(Long activityId) {
        // TODO: 实现获取活动的申请列表逻辑
        return null;
    }

    @Override
    public boolean handleApplication(Long appId, String action) {
        // TODO: 实现处理申请逻辑
        return false;
    }

    @Override
    public boolean likeActivity(Long activityId, Long userId) {
        if (likeRepository.existsByActivityIdAndUserId(activityId, userId)) {
            return false;
        }
        com.example.campusmate.entity.ActivityLike like = new com.example.campusmate.entity.ActivityLike();
        like.setActivityId(activityId);
        like.setUserId(userId);
        like.setCreatedAt(java.time.LocalDateTime.now());
        likeRepository.save(like);
        return true;
    }
    @Override
    public boolean favoriteActivity(Long activityId, Long userId) {
        if (favoriteRepository.existsByActivityIdAndUserId(activityId, userId)) {
            return false;
        }
        com.example.campusmate.entity.ActivityFavorite fav = new com.example.campusmate.entity.ActivityFavorite();
        fav.setActivityId(activityId);
        fav.setUserId(userId);
        fav.setCreatedAt(java.time.LocalDateTime.now());
        favoriteRepository.save(fav);
        return true;
    }
}