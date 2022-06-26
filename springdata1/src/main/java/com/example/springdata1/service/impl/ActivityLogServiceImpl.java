package com.example.springdata1.service.impl;

import com.example.springdata1.entity.ActivityLog;
import com.example.springdata1.repo.ActivityLogRepository;
import com.example.springdata1.service.ActivityLogService;
import org.springframework.stereotype.Service;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {
    private ActivityLogRepository activityLogRepository;
    public ActivityLogServiceImpl(ActivityLogRepository activityLogRepository){
        this.activityLogRepository = activityLogRepository;
    }
    @Override
    public void save(ActivityLog a) {
        activityLogRepository.save(a);
    }
}
