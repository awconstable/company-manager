package uk.ltd.crossfire.companymanager.server.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: awconstable
 * Date: 13/11/2012
 * Time: 21:04
 * To change this template use File | Settings | File Templates.
 */
@Service
@Aspect
public class BoundryLoggerInterceptor {

    @AfterThrowing(
            pointcut = "@annotation(uk.ltd.crossfire.companymanager.server.annotations.BoundryLogger)",
            throwing = "ex"
    )
    public void processException(JoinPoint jp, Throwable ex) throws Throwable {
            Logger log = getLog(jp);

            log.error(jp.getTarget().getClass().getName(), ex);

            throw ex;

    }

    protected Logger getLog(JoinPoint jp) {
        return LoggerFactory.getLogger(jp.getTarget().getClass());
    }
}
