package com.example.project.entity;

import com.example.project.dto.MainCommunityDTO;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "community")
public class MainCommunityEntity extends  MainCommunityTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(nullable = false, name = "title")
    private String title;
    @Column(nullable = false, name = "content")
    private String content;

    @Column(nullable = false, name = "hits")
    private int hits;

    public static MainCommunityEntity toSaveEntity(MainCommunityDTO mainCommunityDTO){
        MainCommunityEntity mainCommunityEntity = new MainCommunityEntity();
        mainCommunityEntity.setId(mainCommunityDTO.getId());
        mainCommunityEntity.setName(mainCommunityDTO.getName());
        mainCommunityEntity.setTitle(mainCommunityDTO.getTitle());
        mainCommunityEntity.setContent(mainCommunityDTO.getContent());
        mainCommunityEntity.setHits(mainCommunityDTO.getHist());

        return mainCommunityEntity;
    }
}
