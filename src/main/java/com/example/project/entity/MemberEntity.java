package com.example.project.entity;

import com.example.project.dto.MemberDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class MemberEntity {
    @Id
    private String userName;
    @Column(nullable = false, name = "userId")
    private String userId;
    @Column(nullable = false, name = "userPw")
    private String userPw;
    @Column(nullable = false, name = "userEmail")
    private String userEmail;
    @Column(nullable = false, name = "userAddress")
    private String userAddress;
    @Column(nullable = true, name = "userAnimalMammal")
    private String userAnimalMammal;
    @Column(nullable = true, name = "userAnimalBird")
    private String userAnimalBird;
    @Column(nullable = true, name = "userAnimalReptiles")
    private String userAnimalReptiles;
    @Column(nullable = true, name = "userAnimalAmphibian")
    private String userAnimalAmphibian;
    @Column(nullable = true, name = "userAnimalFish")
    private String userAnimalFish;
    @Column(nullable = true, name = "userAnimalArthropod")
    private String userAnimalArthropod;

    public static MemberEntity toMemberEntity(MemberDTO memberDTO){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUserId(memberDTO.getUserId());
        memberEntity.setUserPw(memberDTO.getUserPw());
        memberEntity.setUserName(memberDTO.getUserName());
        memberEntity.setUserEmail(memberDTO.getUserEmail());
        memberEntity.setUserAddress(memberDTO.getUserAddress());
        memberEntity.setUserAnimalMammal(memberDTO.getUserAnimalMammal());
        memberEntity.setUserAnimalBird(memberDTO.getUserAnimalBird());
        memberEntity.setUserAnimalReptiles(memberEntity.getUserAnimalReptiles());
        memberEntity.setUserAnimalAmphibian(memberDTO.getUserAnimalAmphibian());
        memberEntity.setUserAnimalFish(memberDTO.getUserAnimalFish());
        memberEntity.setUserAnimalArthropod(memberDTO.getUserAnimalArthropod());

        return memberEntity;
    }
}
