package com.example.campusmate.service;

import com.example.campusmate.entity.Activity;
import java.util.List;

/**
 * 活动管理相关业务接口
 */
public interface ActivityService {
    /**
     * 创建活动
     * @param activity 活动信息
     * @return 创建后的活动
     */
    Activity createActivity(Activity activity);

    /**
     * 获取活动列表（带筛选）
     * @param campus 校区
     * @param type 活动类型
     * @param page 页码
     * @param size 每页数量
     * @return 活动列表
     */
    List<Activity> listActivities(String campus, String type, int page, int size);

    /**
     * 获取活动详情
     * @param activityId 活动ID
     * @return 活动详情
     */
    Activity getActivityDetail(Long activityId);

    /**
     * 删除活动（移至草稿箱）
     * @param activityId 活动ID
     * @return 是否成功
     */
    boolean deleteActivity(Long activityId);

    /**
     * 申请成为搭子
     * @param activityId 活动ID
     * @param reason 申请理由
     * @return 是否成功
     */
    boolean applyForActivity(Long activityId, Long userId, String reason);

    /**
     * 获取活动的申请列表
     * @param activityId 活动ID
     * @return 申请列表
     */
    String listApplications(Long activityId);

    /**
     * 处理申请（同意/拒绝）
     * @param appId 申请ID
     * @param action 操作（ACCEPT/REJECT）
     * @return 是否成功
     */
    boolean handleApplication(Long appId, String action);

    boolean likeActivity(Long activityId, Long userId);
    boolean favoriteActivity(Long activityId, Long userId);
}