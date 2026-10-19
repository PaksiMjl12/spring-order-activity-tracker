package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Document(collection = "activity_logs")
public class ActivityLog {
    @Id
    private String id;
    private String action;
    private String description;
    private LocalDateTime timestamp;
}