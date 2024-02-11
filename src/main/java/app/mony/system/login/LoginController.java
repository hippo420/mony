package app.mony.system.login;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @RequestMapping("/prcLogin")
    public Member prcLogin(HttpServletRequest request, HttpServletResponse response, @RequestBody Member member){
        System.out.println("prcLogin");

        loginService.prcLogin(request, response, member);
        Member user = new Member();
        user.setName("개밥자");
        user.setNickName("개밥자");

        //user.setThumbs("aaa");
        return user;
    }



    @RequestMapping("/prcLogin1")
    public void prcLogin1(){
        System.out.println("prcLogin2");

    }
}
