package com.celeb.site.common.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;

/**
 * @author ITWINNER [2019. . .]
 * AOP log 추적
 */

@Log4j
@Component
public class LogAdviceAop {

    static String AOP_name = "";
    static String AOP_type = "";
  /**
 * ITWINNER [2019. . .]
 * 정의되있는 클레스로 요청하는 메서드와 파라미터들을 추적한다.
 * logTargetParam 실행시 오류나면 exceptionThrowing 에서 처리 후 오류 화면으로 ....
 * @param pjp
 * @return
 */
  public Object logTargetParam( ProceedingJoinPoint pjp) throws Throwable{
//    long start = System.currentTimeMillis();

	AOP_type = pjp.getSignature().getDeclaringTypeName();
	//컨트롤러는 뺴자 ser
    if (AOP_type.indexOf("Controller") > -1) {
    	AOP_name = "클레스 형식 : Controller   : ";
    }
    else if (AOP_type.indexOf("Service") > -1) {
    	AOP_name = "클레스 형식 : ServiceImpl  :  "  ;
    }
    else if (AOP_type.indexOf("Mapper") > -1) {
    	AOP_name = "클레스 형식 : Mapper       :  ";
    }

    System.out.println("로그를 남깁시다......" + AOP_type);

    log.debug("----------------------------------------------------------------------------------------------------");
    log.debug(AOP_name + AOP_type + "." + pjp.getSignature().getName() + "()");
    log.debug("Param     : " + Arrays.toString(pjp.getArgs()));
    log.debug("----------------------------------------------------------------------------------------------------");
    //invoke method
    Object result = pjp.proceed();

    return result;
  }

}