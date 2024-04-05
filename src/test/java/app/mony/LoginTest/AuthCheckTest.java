package app.mony.LoginTest;


import app.mony.system.interceptor.auth.Auth;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.*;

@Slf4j
public class AuthCheckTest {


    @Test
    @DisplayName("enum 테스트")
    void enumTest(){
        String tranCode = "SEL";
        assertThat(Auth.find(tranCode)).isEqualTo(0);
    }


}
