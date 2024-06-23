package app.mony.LoginTest;


import app.mony.system.interceptor.auth.Auth;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
public class SessionCheckTest {


    @Test
    @DisplayName("세션 테스트")
    void sessionTest(){

        String tranCode = "SEL";
        assertThat(Auth.find(tranCode)).isEqualTo(0);
    }


}
