package de.tekup.jpademoa.ctrls;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandleCls {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleDataIntegrityViolation(DataIntegrityViolationException e, Model model){
        model.addAttribute("errorCode","Unique Data Exp");
        model.addAttribute("errorMsg",e.getMessage());
    return "error";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model){
        model.addAttribute("errorCode","Something Wrong");
        model.addAttribute("errorMsg",e.getMessage());
        return "error";
    }

}
