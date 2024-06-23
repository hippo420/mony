package app.mony.LoginTest.emailTest;

import app.mony.system.utils.mail.MailUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
@Slf4j
public class EmailTest {

    @Autowired
    MailUtil mailUtil;

    @Test
    @DisplayName("이메일 발송[임시일련번호발급]  테스트")
    void sendEmailRegist(){

        mailUtil.sendMail("hippo420@naver.com","regist");
    }
    @Test
    @DisplayName("이메일 발송[임시비밀번호발급] 테스트")
    void sendEmailPassword(){

        mailUtil.sendMail("hippo420@naver.com","password");
    }

    @Test
    @DisplayName("이메일 발송[임시비밀번호발급] 테스트")
    void createPassword(){

        log.info("임시발급 비밀번호 = {}",mailUtil.createCode("password"));
    }
}
