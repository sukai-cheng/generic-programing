//package com.seckill.exception;
//
//import com.seckill.vo.ResBeanEnum;
//import com.seckill.vo.RespBean;
//import org.springframework.validation.BindException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//
//@RestControllerAdvice // 只能处理控制器抛出的异常, 此时请求已经进入控制器中
//public class GlobalExceptionHandler {
//
//    // 分类处理异常
//    @ExceptionHandler(Exception.class)
//    public RespBean ExceptionHandler(Exception e) {
//        if (e instanceof GlobalException) {
//            GlobalException ex = (GlobalException) e;
//            return RespBean.error(ex.getRespBeanEnum());
//        } else if (e instanceof BindException) {
//            BindException ex = (BindException) e;
//            RespBean respBean = RespBean.error(ResBeanEnum.BIND_ERROR);
//            respBean.setMessage("参数校验异常: " + ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
//            return respBean;
//        }
//
//        return RespBean.error();
//    }
//}
