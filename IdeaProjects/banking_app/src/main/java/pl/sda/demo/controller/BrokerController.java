package pl.sda.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.demo.dto.BrokerDto;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class BrokerController {
//    private final pl.sda.demo.service.BrokerService BrokerService;
//
//    @Secured({"ROLE_ADVISOR"})
//    @GetMapping("/broker")
//    public String broker(Model model) {
//        model.addAttribute("brokers", BrokerService.findAll());
//        model.addAttribute("broker", BrokerDto.builder().build());
//        return "broker";
//    }
//
//
//    @Secured({"ROLE_ADVISOR"})
//    @PostMapping("/broker")
//    public String brokerAdding(Model model, @ModelAttribute("broker") @Valid BrokerDto user2, BindingResult bindingResult) {
//        if (!bindingResult.hasErrors()) {
//            BrokerService.add(user2);
//        }
//        model.addAttribute("brokers", new BrokerDto());
//
//        return "broker";
//    }
}
