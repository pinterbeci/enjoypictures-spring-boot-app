package com.aplication.enjoypictures.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class ErrorPageController implements ErrorController {
    private static final String ERR_PATH = "/error";

    private ErrorAttributes errorAttributes;

    @Autowired
    public void setErrorAttributes(ErrorAttributes errorAttributes){
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping(ERR_PATH)
    public String error(Model model, HttpServletRequest request)
    {
        //  RequestAttributes rA = new ServletRequestAttributes(request);
        ServletWebRequest rA = new ServletWebRequest(request);
        Map<String,Object> error = this.errorAttributes.getErrorAttributes(rA, true);

        model.addAttribute("timestamp",error.get("timestamp"));
        model.addAttribute("error",error.get("error"));
        model.addAttribute("message","This page not found!");
        model.addAttribute("path",error.get("path"));
        //  model.addAttribute("status",error.get("status"));

        return "detailedError";
    }
    @Override
    public String getErrorPath() {
        return ERR_PATH;
    }
}
