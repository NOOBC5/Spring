package com.example.project.controller;

import com.example.project.Service.MemberService;
import com.example.project.Service.NomalCommunityService;
import com.example.project.dto.MemberDTO;
import com.example.project.dto.NomalCommunityDTO;
import com.example.project.repository.NomalCommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final NomalCommunityService nomalCommunityService;

    @GetMapping("/mainForm")
    public String mainForm(){

        return "mainForm";
    }

    @GetMapping("/userMain")
    public String userMain(){

        return "userMain";
    }

    @GetMapping("/mainTabHome")
    public String mainTabHome(){

        return "mainTabHome";
    }

    @GetMapping("/homeSupTabCommunity")
    public  String homeSupTabCommunity(){

        return "homeSupTabCommunity";
    }

    @GetMapping("/nomalCommunityCreate")
    public String nomalCommunityCreate(){

        return "nomalCommunityCreate";
    }

    @PostMapping("/mainForm")
    public String save(@ModelAttribute MemberDTO memberDTO){
        memberService.save(memberDTO);

        return "mainForm";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "main";
    }

    @PostMapping("/userMain")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session){

        MemberDTO loginResult = memberService.login(memberDTO);
        MemberDTO loginManager = memberService.managerLogin(memberDTO);
        if(loginManager != null){
            //매니저 아이디 login 성공
            session.setAttribute("userName", loginResult.getUserName());
            return "managerMain";
        }else if (loginResult != null){
            //일반 회원 아이디 login 성공
            session.setAttribute("userName", loginResult.getUserName());
            return "userMain";
        }else {
            //login 실패
            return "mainForm";
        }
    }

    @PostMapping("/mainTabHome")
    public String communitySave(@ModelAttribute NomalCommunityDTO nomalCommunityDTO){
        System.out.println("nomalCommunityDTO = "+ nomalCommunityDTO);
        nomalCommunityService.save(nomalCommunityDTO);

        return mainTabHome();
    }

}
