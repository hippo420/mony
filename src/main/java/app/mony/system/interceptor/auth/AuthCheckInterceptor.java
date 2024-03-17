package app.mony.system.interceptor.auth;

import app.mony.system.Const;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

@Slf4j
public class AuthCheckInterceptor implements HandlerInterceptor {

    public AuthCheckInterceptor() {
        log.info("init {} [{}]", this.getClass().getSimpleName(), this);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String uuid = String.valueOf(UUID.randomUUID());
        String requestURI = request.getRequestURI();
        String userId = String.valueOf(request.getAttribute("USER_ID"));
        String tranCode = requestURI.substring(requestURI.lastIndexOf("/") + 1);
        String menuId = request.getParameter("MENU_ID");

        request.setAttribute(Const.REQ_UUID,uuid);

        /** AuthDTL
         * ADMIN
         * SEL
         * UPD
         * DEL
         * PRC
         */

        log.debug("-----------------------------------------------------------------");
        log.debug("Controller Check");
        log.debug("requestURI = {}",requestURI);
        log.debug("uuid = {}",uuid);
        log.debug("USERID = {}",uuid);

        log.debug("-----------------------------------------------------------------");
        //TODO : Load Auth From DB by MENU_ID



        return true;
    }
}
