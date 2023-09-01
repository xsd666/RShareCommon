package com.run.rshare.aspect;


import com.run.rshare.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.StringJoiner;


/**
 * @ClassName GlobalExceptionAdvice
 * @Description: 异常处理
 * @Author xsd
 * @Date 2023/8/9
 * @Version V1.0
 **/
@ControllerAdvice
public class GlobalExceptionAdvice {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionAdvice.class);

    @ExceptionHandler(value = {MethodArgumentNotValidException.class, BindException.class, ConstraintViolationException.class})
    @ResponseBody
    public Result handlerMethodArgumentNotValidException(Exception ex) {
        logger.error("Method Argument Not Valid Exception", ex);
        if (ex instanceof ConstraintViolationException) {
            ConstraintViolationException bindException = (ConstraintViolationException) ex;
            return Result.fail(bindException.getMessage());
        }
        BindingResult result = null;
        if (ex instanceof BindException) {
            BindException bindException = (BindException) ex;
            result = bindException.getBindingResult();
        }
        if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException argumentNotValidException = (MethodArgumentNotValidException) ex;
            result = argumentNotValidException.getBindingResult();
        }
        StringJoiner stringJoiner = new StringJoiner(";");
        if (result != null && result.hasErrors()) {
            List<ObjectError> errorList = result.getAllErrors();
            errorList.forEach(error -> {
                FieldError fieldError = (FieldError) error;
                stringJoiner.add(fieldError.getDefaultMessage());
            });
        }
        return Result.fail(stringJoiner.toString());
    }

    @ExceptionHandler(value = {RuntimeException.class})
    @ResponseBody
    public Result handlerRuntimeException(RuntimeException e) {
        logger.error("happened runtimeException", e);
        return Result.fail(e.getMessage());
    }


}
