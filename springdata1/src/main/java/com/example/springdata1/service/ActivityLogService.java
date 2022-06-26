package com.example.springdata1.service;

import com.example.springdata1.entity.ActivityLog;
import com.example.springdata1.entity.Address;
import org.springframework.stereotype.Service;

@Service
public interface ActivityLogService {

    public void save(ActivityLog a);
}
