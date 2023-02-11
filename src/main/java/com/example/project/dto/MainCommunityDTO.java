package com.example.project.dto;

import com.example.project.entity.MainCommunityEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MainCommunityDTO {

    private Long id;

    private String name;

    private String title;

    private String content;

    private LocalDateTime createTime;

    private int hist;

    public MainCommunityDTO(Long id, String name, String title, LocalDateTime createTime, int hist) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.createTime = createTime;
        this.hist = hist;
    }

    public static MainCommunityDTO toMainCommunityDTO(MainCommunityEntity mainCommunityEntity){
        MainCommunityDTO mainCommunityDTO = new MainCommunityDTO();
        mainCommunityDTO.setId(mainCommunityEntity.getId());
        mainCommunityDTO.setName(mainCommunityEntity.getName());
        mainCommunityDTO.setTitle(mainCommunityEntity.getTitle());
        mainCommunityDTO.setContent(mainCommunityEntity.getContent());
        mainCommunityDTO.setHist(mainCommunityEntity.getHits());
        mainCommunityDTO.setCreateTime(mainCommunityEntity.getCreateTime());

        return mainCommunityDTO;
    }
}
