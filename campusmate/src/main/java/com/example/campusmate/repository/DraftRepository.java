package com.example.campusmate.repository;

import com.example.campusmate.entity.Draft;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * 草稿箱表数据库操作接口
 */
public interface DraftRepository extends JpaRepository<Draft, Long> {
    /**
     * 根据用户ID查询草稿列表
     * @param userId 用户ID
     * @return 草稿列表
     */
    List<Draft> findByUserId(Long userId);
}