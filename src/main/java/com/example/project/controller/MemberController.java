package com.example.project.controller;

import com.example.project.Service.MainCommunityService;
import com.example.project.Service.MemberService;
import com.example.project.dto.MainCommunityDTO;
import com.example.project.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    private final MainCommunityService mainCommunityService;


    @GetMapping("/mainForm")
    public String mainForm() {

        return "mainForm";
    }

    @GetMapping("/userMain")
    public String userMain() {

        return "userMain";
    }

    @GetMapping("/mainTabHome")
    public String mainTabHome(Model model) {
        List<MainCommunityDTO> mainCommunityDTOList = mainCommunityService.findAll();
        model.addAttribute("mainCommunityList", mainCommunityDTOList);

        return "mainTabHome";
    }

    @GetMapping("/homeSupTabCommunity")
    public String homeSupTabCommunity(Model model) {
        List<MainCommunityDTO> mainCommunityDTOList = mainCommunityService.findAll();
        model.addAttribute("mainCommunityList", mainCommunityDTOList);

        return "homeSupTabCommunity";
    }

    @GetMapping("/nomalCommunityCreate")
    public String nomalCommunityCreate() {

        return "mainTabCommunityCreate";
    }

    @GetMapping("/updateTab")
    public String updateTab(){

        return "updateTab";
    }

    @PostMapping("/mainForm")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        memberService.save(memberDTO);

        return "mainForm";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "main";
    }

    @PostMapping("/userMain")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {

        MemberDTO loginResult = memberService.login(memberDTO);
        MemberDTO loginManager = memberService.managerLogin(memberDTO);
        if (loginManager != null) {
            //매니저 아이디 login 성공
            session.setAttribute("managerName", loginManager.getUserName());
            return "managerMain";
        } else if (loginResult != null) {
            //일반 회원 아이디 login 성공
            session.setAttribute("userName", loginResult.getUserName());
            return "userMain";
        } else {
            //login 실패
            return "mainForm";
        }
    }

    @PostMapping("/tabCommunity")
    public String createCommunity(@ModelAttribute MainCommunityDTO mainCommunityDTO, Model model){
        mainCommunityService.toSave(mainCommunityDTO);

        List<MainCommunityDTO> mainCommunityDTOList = mainCommunityService.findAll();
        model.addAttribute("mainCommunityList", mainCommunityDTOList);

        return "tabCommunity";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model, HttpSession session){
        mainCommunityService.updateHits(id);
        MainCommunityDTO mainCommunityDTO = mainCommunityService.findById(id);

        String aserName = mainCommunityDTO.getName();
        String userName = (String)session.getAttribute("userName");
        model.addAttribute("main", mainCommunityDTO);

        if (userName.equals(aserName) && aserName.equals("root")) {
            return "managerMainTabCommunityDetail";
        } else if (userName.equals(aserName)) {
            return "userMainTabCommunityDetail";
        } else {
            return "mainTabCommunityDetail";
        }

    }

    @GetMapping("/updateMainCommunity/{id}")
    public String updateForm(@PathVariable Long id, Model model){
        MainCommunityDTO mainCommunityDTO = mainCommunityService.findById(id);
        model.addAttribute("mainUpdate", mainCommunityDTO);

        return "updateMainCommunity";
    }

    @PostMapping("/updateMainCommunity")
    public String update(@ModelAttribute MainCommunityDTO mainCommunityDTO, Model model){
        MainCommunityDTO mainCommunity = mainCommunityService.update(mainCommunityDTO);
        model.addAttribute("mainCommunity", mainCommunity);

        return "userMainTabCommunityDetail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        mainCommunityService.delete(id);
        return "redirect:/homeSupTabCommunity";
    }

}
