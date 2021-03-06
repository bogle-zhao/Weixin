package com.bogle.weixin.aspect;

import com.bogle.weixin.defines.WxCode;
import com.bogle.weixin.exception.WeixinException;
import com.bogle.weixin.message.WxMsg;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 微信拦截器，全局处理微信错误消息
 */
@Aspect
@Component
public class WeixinAspect {

    private final static Logger log = LoggerFactory.getLogger(WeixinAspect.class);

    @Pointcut("execution (* com.bogle.weixin.component.HttpComponent.* (..)) ")
    public void aspect() {
    }

    /**
     * 配置前置通知,使用在方法aspect()上注册的切入点
     * 同时接受JoinPoint切入点对象,可以没有该参数
     */
    @Before("aspect()")
    public void before(JoinPoint joinPoint) {
        log.debug("before");
    }

    /**
     * 配置后置通知,使用在方法aspect()上注册的切入点
     *
     * @param joinPoint
     */
    @After("aspect()")
    public void after(JoinPoint joinPoint) {
        log.debug("after");
    }

    /**
     * 微信请求切入点，判断返回值非0情况下都为异常消息
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "aspect()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object returnValue;
        //访问目标方法的参数：
        Object[] args = joinPoint.getArgs();
        //执行目标方法
        returnValue = joinPoint.proceed(args);
        if (returnValue instanceof WxMsg) {
            WxMsg message = (WxMsg) returnValue;
            WxCode wxCode = handleException(message);
            if (wxCode != wxCode.SUCCESS) {
                throw new WeixinException("微信错误消息：" + wxCode.getErrmsg(), wxCode);
            }
        } else if (returnValue == null) {
            throw new WeixinException("微信连接超时", WxCode.ERROR_TIME_OUT);
        }
        return returnValue;
    }

    /**
     * 配置后置返回通知,使用在方法aspect()上注册的切入点
     *
     * @param joinPoint
     */
    @AfterReturning("aspect()")
    public void afterReturn(JoinPoint joinPoint) {
        log.debug("afterReturn");
    }

    /**
     * 配置抛出异常后通知,使用在方法aspect()上注册的切入点
     *
     * @param joinPoint
     * @param ex
     * @throws Throwable
     */
    @AfterThrowing(pointcut = "aspect()", throwing = "ex")
    public void afterThrow(JoinPoint joinPoint, Throwable ex) throws Throwable {
        log.error("afterThrow " + joinPoint + "\t" + ex.getMessage());
        throw ex;
    }

    /**
     * 判断处理微信消息，如果有误，返回错误详细信息
     *
     * @param wxMsg
     * @return
     * @throws WeixinException
     */
    private WxCode handleException(WxMsg wxMsg) throws WeixinException {
        WxCode[] values = WxCode.values();
        for (WxCode status : values) {
            int errcode = wxMsg.getErrcode();
            if (errcode != 0 && status.getErrorcode() == errcode) {
                log.error("微信错误消息：" + status.getErrmsg());
                return status;
            }
        }
        return WxCode.SUCCESS;
    }
}
