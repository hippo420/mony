package app.mony.mony.sy.login;

import app.mony.system.utils.ChiperUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Slf4j
@Service
public class LoginService {

    @Autowired
    private MemberJpaRepository memberJPARepository;

    public Member prcLogin(HttpServletRequest request, HttpServletResponse response, Member member){
        Member loginMember = findUser(member.getUSERID());
        String sPassword = member.getUSERPWD();

        if(validateUser(loginMember,sPassword,"")){
            UUID uuid = UUID.randomUUID();
            log.info("JSESSIONID = [{}]",uuid);
            HttpSession session = request.getSession();
            session.setAttribute("JSESSIONID", uuid);
            session.setAttribute("USER_ID", member.getUSERID());
            session.setMaxInactiveInterval(30 * 60);
            response.addCookie(makeCookie(member,uuid));
            response.setHeader("Success", String.valueOf(response.SC_ACCEPTED));
        }else{
            response.setHeader("Success", String.valueOf(response.SC_BAD_REQUEST));
        }
        return loginMember;

    }

    private Member findUser(String userid) {


        Optional<Member> user = memberJPARepository.findMemberByUSERID(userid);

        if(user.isEmpty())
            throw new IllegalStateException(userid+ "회원이 존재하지 않습니다.");
        return user.get();
    }

    public Cookie makeCookie(Member member,UUID uuid){

        // 로그인 성공 시 쿠키 설정
        Cookie cookie = new Cookie("JSESSIONID", String.valueOf(uuid));
        cookie.setMaxAge(24 * 60 * 60); // 쿠키의 유효 기간을 1일로 설정
        cookie.setPath("/"); // 쿠키의 경로를 설정할 수 있음
        return cookie;
    }

    public boolean validateUser(Member member, String sPassword, String loginType) {

        /**
         * TODO DB에서 USER정보 가져오기
         */

        log.info("user = {}",member.toString());

        String encPassword = ChiperUtil.sha256Salt(sPassword,member.getSALT());
        log.info("encPassword = {}",encPassword);
        log.info("DB Password = {}",encPassword);
        if(encPassword.equals(member.getUSERPWD())){
            log.info("USER = {} 로그인 시간 ={}", member.getUSERID(),System.currentTimeMillis());
            member.setUSERPWD("NO_DATA");
            member.setSALT("NO_DATA");
            return true;
        }
        else{
            log.info("해당 사용자 찾을수 없음");
            return false;
        }
    }

    public void prcLogout(HttpServletRequest request, HttpServletResponse response, Member member) {

        HttpSession session = request.getSession(false);
        session.invalidate();
    }

    public void registUser(Member member) {
        memberJPARepository.save(member);
    }
}
