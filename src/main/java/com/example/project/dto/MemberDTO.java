package com.example.project.dto;

import com.example.project.entity.MemberEntity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDTO {
    private String userId;
    private String userPw;
    private String userName;
    private String userEmail;
    private String userAddress;
    private String userAnimalMammal;
    private String userAnimalBird;
    private String userAnimalReptiles;
    private String userAnimalAmphibian;
    private String userAnimalFish;
    private String userAnimalArthropod;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setUserId(memberEntity.getUserId());
        memberDTO.setUserPw(memberEntity.getUserPw());
        memberDTO.setUserName(memberEntity.getUserName());
        memberDTO.setUserEmail(memberEntity.getUserEmail());
        memberDTO.setUserAddress(memberDTO.getUserAddress());
        memberDTO.setUserAnimalMammal(memberEntity.getUserAnimalMammal());
        memberDTO.setUserAnimalBird(memberEntity.getUserAnimalBird());
        memberDTO.setUserAnimalReptiles(memberEntity.getUserAnimalReptiles());
        memberDTO.setUserAnimalAmphibian(memberEntity.getUserAnimalAmphibian());
        memberDTO.setUserAnimalFish(memberEntity.getUserAnimalFish());
        memberDTO.setUserAnimalArthropod(memberEntity.getUserAnimalArthropod());
        return memberDTO;
    }

}
