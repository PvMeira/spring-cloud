package com.kenai.br.library.register.exception.factory;

import com.kenai.br.library.register.exception.model.Error;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

public class ErrorFactory {

    /**
     * Create error list from a MethodArgumentNotValidException
     *
     * @param valException exception to be converted to list
     * @return list of errors
     */
    public static Error errorFromValidationException(MethodArgumentNotValidException valException) {
        String code = "400";
        String title = "Incorrect request format";
        String errors = "";
        for(FieldError err : valException.getBindingResult().getFieldErrors()){
            errors = errors.concat("\n " + err.getField()
                                         + " - "
                                         + err.getRejectedValue());
        }
        return new Error(code, title, errors);
    }

    /**
     * Create error object from a ServletRequestBindingException
     *
     * @param bindExc exception to be converted to list
     * @return list of errors
     */
    public static Error errorFromRequestBindingException(ServletRequestBindingException bindExc) {
        return new Error("400","Incorrect request format", bindExc.getMessage());
    }

    /**
     * Create error object from a MethodArgumentTypeMismatchException
     *
     * @param typeExc exception to be converted to list
     * @return list of errors
     */
    public static Error errorFromTypeMismatchException(MethodArgumentTypeMismatchException typeExc) {
        return new Error("400","Incorrect request format",typeExc.getParameter().getParameterName() + " - " + typeExc.getValue());
    }

    /**
     * Create error object from a Exception, all non-expected exceptions should pass here
     *
     * @param exc exception to be converted to error object
     * @return internal error
     */
    public static Error errorFromException(Exception exc) {
        return new Error("500", "Something went wrong", exc.getMessage());
    }
}
