package com.example.campusmate.controller;

import com.example.campusmate.entity.Activity;
import com.example.campusmate.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.campusmate.dto.ApiResponse;

@RestController
@RequestMapping("/api/activities")
@CrossOrigin(origins = "*")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping
    public ApiResponse<Activity> createActivity(@RequestBody Activity activity) {
        Activity result = activityService.createActivity(activity);
        return ApiResponse.success(result);
    }

    @GetMapping
    public ApiResponse<List<Activity>> listActivities(
            @RequestParam(required = false) String campus,
            @RequestParam(required = false) String type,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<Activity> list = activityService.listActivities(campus, type, page, size);
        return ApiResponse.success(list);
    }

    @GetMapping("/{activityId}")
    public ApiResponse<Activity> getActivityDetail(@PathVariable Long activityId) {
        Activity activity = activityService.getActivityDetail(activityId);
        return ApiResponse.success(activity);
    }

    @DeleteMapping("/{activityId}")
    public ApiResponse<Boolean> deleteActivity(@PathVariable Long activityId) {
        boolean result = activityService.deleteActivity(activityId);
        return ApiResponse.success(result);
    }

    @PostMapping("/{activityId}/like")
    public ApiResponse<Boolean> likeActivity(@PathVariable Long activityId, @RequestParam Long userId) {
        boolean result = activityService.likeActivity(activityId, userId);
        return ApiResponse.success(result);
    }

    @PostMapping("/{activityId}/favorite")
    public ApiResponse<Boolean> favoriteActivity(@PathVariable Long activityId, @RequestParam Long userId) {
        boolean result = activityService.favoriteActivity(activityId, userId);
        return ApiResponse.success(result);
    }

    @PostMapping("/{activityId}/apply")
    public ApiResponse<Boolean> applyForActivity(@PathVariable Long activityId, @RequestParam Long userId, @RequestParam String reason) {
        boolean result = activityService.applyForActivity(activityId, userId, reason);
        return ApiResponse.success(result);
    }

    @PutMapping("/applications/{appId}/accept")
    public ApiResponse<Boolean> acceptApplication(@PathVariable Long appId) {
        boolean result = activityService.handleApplication(appId, "ACCEPT");
        return ApiResponse.success(result);
    }

    @PutMapping("/applications/{appId}/ignore")
    public ApiResponse<Boolean> ignoreApplication(@PathVariable Long appId) {
        boolean result = activityService.handleApplication(appId, "REJECT");
        return ApiResponse.success(result);
    }
}