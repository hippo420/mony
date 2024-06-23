package app.mony.mony.sy.member;

import app.mony.system.utils.ChiperUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/login")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/regist")
    public void regist(@RequestBody Member member){
        log.debug("regist");

        String salt = ChiperUtil.getSalt();
        String inputPassword = member.getUSERNAME();
        member.setSALT(salt);
        member.setUSERPWD(ChiperUtil.sha256Salt(inputPassword,salt));


        memberService.registUser(member);
    }

    @RequestMapping("/prcLogin")
    public Member prcLogin(HttpServletRequest request, HttpServletResponse response,  @RequestBody Member member){
        log.info("prcLogin");
        log.info("Login => [{}] [{}]",member.getUSERID(), member.getUSERPWD());
        Member user = memberService.prcLogin(request, response, member);

        return user;
    }

    @RequestMapping("/prcLogout")
    public void prcLogout(HttpServletRequest request, HttpServletResponse response, @RequestBody Member member){
        log.info("prcLogout");
        memberService.prcLogout(request,response,member);
    }

    @RequestMapping("/prcLogin1")
    public void prcLogin1(){
        log.info("prcLogin1");

    }
}
