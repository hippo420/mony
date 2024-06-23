package app.mony.system.utils.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.security.SecureRandom;
import java.util.Random;

@Slf4j
@Component
@RequiredArgsConstructor
public class MailUtil {

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    private final String REGIST = "regist";
    private final String PASSWORD = "password";


    public String sendMail(String rcvUser, String type) {
        String authNum = createCode(type);

        EmailMessage emailMessage = createTemplate(rcvUser,type);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false);
            mimeMessageHelper.setTo(emailMessage.getRcvUser());
            mimeMessageHelper.setSubject(emailMessage.getTitle());

            mimeMessageHelper.setText(emailMessage.getMessage(),true);

            javaMailSender.send(mimeMessage);

            authNum = "Success";
        }
        catch (MessagingException e){
            log.info("Email 전송 실패 => {}",e.getMessage());
            authNum = "Fail";
            throw new RuntimeException("메일전송에 실패했습니다.");
        }

        return authNum;
    }

    public String createCode(String type) {
        String code ="";
        Random random = new SecureRandom();
        StringBuffer key = new StringBuffer();

        switch (type){
            case "password" :
                for (int i = 0; i < 8; i++) {
                    int index = random.nextInt(4);

                    switch (index) {
                        case 0: key.append((char) ((int) random.nextInt(26) + 97)); break;
                        case 1: key.append((char) ((int) random.nextInt(26) + 65)); break;
                        default: key.append(random.nextInt(9));
                    }
                }
                code= key.toString();
                break;

            case "regist"    :
                random.setSeed(System.currentTimeMillis());
                code = String.valueOf(random.nextInt(1000000) % 1000000);
                break;
        }

        return code;
    }

    private EmailMessage createTemplate(String rcvUser,String type){
        String title ="";
        if(REGIST.equals(type))
            title ="[ 회원가입을 위한 인증번호 ]";
        else if(PASSWORD.equals(type)){
            title ="[ 임시비밀번호 발급 ]";
        }

        EmailMessage mail =new EmailMessage();
        mail.setSndUser("mony.reply@gamil.com");
        mail.setRcvUser(rcvUser);
        mail.setTitle(title);

        Context context = new Context();
        context.setVariable("code",createCode(type));
        mail.setMessage(templateEngine.process(type,context));
        return mail;
    }

}
