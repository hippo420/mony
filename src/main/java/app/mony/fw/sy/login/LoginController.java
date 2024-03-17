package app.mony.fw.sy.login;

import app.mony.fw.sy.Member;
import app.mony.system.utils.ChiperUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/regist")
    public void regist(@RequestBody Member member){
        log.debug("regist");

        String salt = ChiperUtil.getSalt();
        String inputPassword = member.getPassword();
        member.setSalt(salt);
        member.setPassword(ChiperUtil.sha256Salt(inputPassword,salt));


        loginService.registUser(member);
    }

    @RequestMapping("/prcLogin")
    public Member prcLogin(HttpServletRequest request, HttpServletResponse response, @RequestBody Member member){
        log.debug("prcLogin");

        loginService.prcLogin(request, response, member);
        Member user = new Member();
        user.setName("개밥자");
        user.setNickName("개밥자");

        //user.setThumbs("aaa");
        return user;
    }

    @RequestMapping("/prcLogout")
    public void prcLogout(HttpServletRequest request, HttpServletResponse response, @RequestBody Member member){
        log.debug("prcLogout");
        loginService.prcLogout(request,response,member);
    }

    @RequestMapping("/prcLogin1")
    public void prcLogin1(){
        log.debug("prcLogin1");

    }
}
