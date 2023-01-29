package com.example.project.Service;

import com.example.project.dto.NomalCommunityDTO;
import com.example.project.entity.NomalCommunityEntity;
import com.example.project.repository.NomalCommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NomalCommunityService {
    private final NomalCommunityRepository nomalCommunityRepository;

    public void save(NomalCommunityDTO nomalCommunityDTO){
        NomalCommunityEntity nomalCommunityEntity = NomalCommunityEntity.toSaveEntity(nomalCommunityDTO);
        nomalCommunityRepository.save(nomalCommunityEntity);

    }
}
