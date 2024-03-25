package com.chukurs.springdemo.mvc;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    @GetMapping(path = "/")
    public String showForm(Model theModel) {
        theModel.addAttribute("customer", new Customer());


        return "customer-form";
    }

    @PostMapping(path = "/processForm")

    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {
        if (theBindingResult.hasErrors()) {
            System.out.println("has errors");
            return "customer-form";
        } else {
            return "customer-confirmation";
        }
    }

    @InitBinder // pre-process all web requests coming in
    public void initBinder(WebDataBinder dataBinder) {
//trim leading/trailing spaces
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
