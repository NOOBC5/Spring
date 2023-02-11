package com.example.project.Service;

import com.example.project.dto.MainCommunityDTO;
import com.example.project.entity.MainCommunityEntity;
import com.example.project.repository.MainCommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.chrono.MinguoEra;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MainCommunityService {

    private final MainCommunityRepository mainCommunityRepository;

    public void toSave(MainCommunityDTO mainCommunityDTO){
        MainCommunityEntity mainCommunityEntity = MainCommunityEntity.toSaveEntity(mainCommunityDTO);
        mainCommunityRepository.save(mainCommunityEntity);
    }

    public List<MainCommunityDTO> findAll(){
        List<MainCommunityEntity> mainCommunityEntityList = mainCommunityRepository.findAll();
        List<MainCommunityDTO> mainCommunityDTOList = new ArrayList<>();
        for(MainCommunityEntity mainCommunityEntity: mainCommunityEntityList){
            mainCommunityDTOList.add(MainCommunityDTO.toMainCommunityDTO(mainCommunityEntity));
        }
        return mainCommunityDTOList;
    }
    @Transactional
    public void updateHits(Long id){

        mainCommunityRepository.updateHits(id);
    }

    public MainCommunityDTO findById(Long id){
        Optional<MainCommunityEntity> optionalMainCommunityEntity = mainCommunityRepository.findById(id);
        if(optionalMainCommunityEntity.isPresent()){
            MainCommunityEntity mainCommunityEntity = optionalMainCommunityEntity.get();
            MainCommunityDTO mainCommunityDTO = MainCommunityDTO.toMainCommunityDTO(mainCommunityEntity);

            return mainCommunityDTO;
        }else{
            return null;
        }
    }

    public MainCommunityDTO update(MainCommunityDTO mainCommunityDTO){
        MainCommunityEntity mainCommunityEntity = MainCommunityEntity.toSaveEntity(mainCommunityDTO);
        mainCommunityRepository.save(mainCommunityEntity);
        return findById(mainCommunityDTO.getId());
    }

    public void delete(Long id){
        mainCommunityRepository.deleteById(id);
    }

    public Page<MainCommunityDTO> paging(Pageable pageable){
        int page = pageable.getPageNumber() - 1;
        int pageLimit = 7;
        Page<MainCommunityEntity> mainCommunityEntities = mainCommunityRepository.findAll(PageRequest.of(page, pageLimit, Sort.by(Sort.Direction.DESC, "id")));

        Page<MainCommunityDTO> mainCommunityDTOs = mainCommunityEntities.map(mainCommunityEntity -> new MainCommunityDTO(mainCommunityEntity.getId(), mainCommunityEntity.getName(), mainCommunityEntity.getTitle(), mainCommunityEntity.getCreateTime(), mainCommunityEntity.getHits()));
        return mainCommunityDTOs;
    }
}
