package com.example.campusmate.repository;

import com.example.campusmate.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * 活动表数据库操作接口
 */
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    /**
     * 根据创建者ID查询活动列表
     * @param creatorId 创建者用户ID
     * @return 活动列表
     */
    List<Activity> findByCreatorId(Long creatorId);
}