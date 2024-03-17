package app.mony.fw.sy.login;

import app.mony.fw.sy.Member;
import app.mony.fw.sy.MemberRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;
@Slf4j
@Service
public class LoginService {

    @Autowired
    private MemberRepository memberRepository;
    public Member prcLogin(HttpServletRequest request, HttpServletResponse response, Member member){


        if(validateUser(member)){
            UUID uuid = UUID.randomUUID();

            HttpSession session = request.getSession();
            session.setAttribute("sessionId", uuid);
            session.setAttribute("userId", member.getUserId());
            session.setMaxInactiveInterval(30 * 60);
            response.addCookie(makeCookie(member,uuid));
            response.setHeader("Success", String.valueOf(response.SC_ACCEPTED));
        }else{
            response.setHeader("Success", String.valueOf(response.SC_BAD_REQUEST));
        }
        //TODO USER 조회
        return findUser(member);
    }

    private Member findUser(Member member) {
        //TODO DB Transaction
        return member;
    }

    public Cookie makeCookie(Member member,UUID uuid){

        // 로그인 성공 시 쿠키 설정
        Cookie cookie = new Cookie("Cookie", String.valueOf(uuid));
        cookie.setMaxAge(24 * 60 * 60); // 쿠키의 유효 기간을 1일로 설정
        cookie.setPath("/"); // 쿠키의 경로를 설정할 수 있음
        return cookie;
    }

    public boolean validateUser(Member member) {

        /**
         * TODO DB에서 USER정보 가져오기
         */
        Member user = memberRepository.findByUserIdAndPassword(member.getUserId(), member.getPassword());

        if(StringUtils.isEmpty(user))
            return false;

        if(member.getUserId().equals(user.getUserId())
                && member.getPassword().equals(user.getPassword())){
            log.info("USER = {} 로그인 시간 ={}", member.getUserId(),System.currentTimeMillis());
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
        memberRepository.save(member);
    }
}
