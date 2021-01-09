package pl.sda.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.demo.dto.CustomerLiabilitiesDto;
import pl.sda.demo.dto.PropertyDto;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class PropertyController {

//    private final pl.sda.demo.service.PropertyService PropertyService;
//
//    @Secured({"ROLE_ADVISOR"})
//    @GetMapping("/property")
//    public String property(Model model) {
//        model.addAttribute("properties", PropertyService.findAll());
//        model.addAttribute("property", PropertyDto.builder().build());
//        return "property";
//    }
//
//
//    @Secured({"ROLE_ADVISOR"})
//    @PostMapping("/property")
//    public String customerLiabilitiesAdding(Model model, @ModelAttribute("property") @Valid PropertyDto user2, BindingResult bindingResult) {
//        if (!bindingResult.hasErrors()) {
//            PropertyService.add(user2);
//        }
//        model.addAttribute("properties", new PropertyDto());
//
//        return "property";
//    }
}
