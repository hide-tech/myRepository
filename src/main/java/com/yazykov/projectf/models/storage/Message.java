package com.yazykov.projectf.models.storage;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "message_time")
    private LocalDateTime messageTime;
    @Column(name = "message")
    private String message;
}
