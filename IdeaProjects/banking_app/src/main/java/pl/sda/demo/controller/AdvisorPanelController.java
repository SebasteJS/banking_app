package pl.sda.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.demo.dto.ClientDto;

@Controller
public class AdvisorPanelController {

    @GetMapping("/advisor_panel")
    public ModelAndView advisorPanelPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("advisor_panel");
        return modelAndView;
    }
}
