package com.example.project.dto;

import com.example.project.entity.NomalCommunityEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor // 기본생성자
@AllArgsConstructor// 모든 필드를 매개변수로 하는 생성자
public class NomalCommunityDTO {
    private String write;
    private String title;
    private String content;
}
