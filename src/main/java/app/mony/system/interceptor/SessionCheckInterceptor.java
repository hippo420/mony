package app.mony.system.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.servlet.HandlerInterceptor;
@Slf4j
public class SessionCheckInterceptor implements HandlerInterceptor {

    public SessionCheckInterceptor(){
        log.info("init{} [{}]",this.getClass().getSimpleName(),this);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession(false);

        if(session == null){
            log.info("ERROR::: Session Is NULL");
            return false;
        }
        log.info("Session => USER : [{}], ID : [{}]",session.getAttribute("USER_ID"), session.getId());
        return true;
    }
}
