package com.example.demo.repository;

import com.example.demo.model.ActivityLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActivityLogRepository extends MongoRepository<ActivityLog, String> {}