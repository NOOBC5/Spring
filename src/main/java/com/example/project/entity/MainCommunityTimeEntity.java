package com.example.project.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.sound.sampled.AudioFileFormat;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AudioFileFormat.class)
@Data
public class MainCommunityTimeEntity {

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createTime;

}
