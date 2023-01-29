package com.example.project.entity;

import com.example.project.dto.NomalCommunityDTO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "nomalcommunity")
public class NomalCommunityEntity {
    @Id
    private String write;

    @Column
    private String titlel;

    @Column
    private String content;

    public static NomalCommunityEntity toSaveEntity(NomalCommunityDTO nomalCommunityDTO){
        NomalCommunityEntity nomalCommunityEntity = new NomalCommunityEntity();
        nomalCommunityEntity.setWrite(nomalCommunityDTO.getWrite());
        nomalCommunityEntity.setTitlel(nomalCommunityDTO.getTitle());
        nomalCommunityEntity.setContent(nomalCommunityDTO.getContent());

        return nomalCommunityEntity;
    }
}
