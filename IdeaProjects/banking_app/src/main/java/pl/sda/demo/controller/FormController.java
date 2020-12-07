package pl.sda.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.demo.dto.ClientDto;

@Controller
public class FormController {


    @GetMapping("/form")
    public ModelAndView formPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("form");
        modelAndView.addObject("clientForm", new ClientDto());
        return modelAndView;
    }
//    @GetMapping("/create")
//    public String showOrderForm(final ModelMap modelMap) {
//        modelMap.addAttribute("orderForm", new OrderForm());
//        return "orders";



}
