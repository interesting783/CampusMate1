package com.example.campusmate.service.impl;

import com.example.campusmate.entity.Draft;
import com.example.campusmate.repository.DraftRepository;
import com.example.campusmate.service.DraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 草稿箱相关业务实现类
 */
@Service
public class DraftServiceImpl implements DraftService {
    @Autowired
    private DraftRepository draftRepository;

    /**
     * 获取用户草稿列表
     * @param userId 用户ID
     * @param page 页码
     * @return 草稿列表
     */
    @Override
    public List<Draft> listDrafts(Long userId, int page) {
        return draftRepository.findByUserId(userId);
    }

    /**
     * 从草稿箱重新发布
     * @param draftId 草稿ID
     * @return 是否成功
     */
    @Override
    public boolean publishDraft(Long draftId) {
        draftRepository.deleteById(draftId);
        return true;
    }

    /**
     * 彻底删除草稿
     * @param draftId 草稿ID
     * @return 是否成功
     */
    @Override
    public boolean deleteDraft(Long draftId) {
        draftRepository.deleteById(draftId);
        return true;
    }
}