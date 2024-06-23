package app.mony.system.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    //login
    @Pointcut("execution(* app.mony.mony.sy.member.MemberController.prcLogin(..))")
    public void login(){}

    //login
    @Pointcut("execution(* app.mony.mony.sy.member.MemberController.prcLogout(..))")
    public void logout(){}

    //Auth
    @Pointcut("execution(* app.mony..*Controller.*(..))")
    public void AuthCheck(){}

}
