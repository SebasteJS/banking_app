package pl.sda.demo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.demo.dto.BrokerDto;
import pl.sda.demo.service.BrokerService;

@Controller
@RequestMapping("/brokers")
@RequiredArgsConstructor
public class BrokerController {
    private final BrokerService brokerService;

    @GetMapping
    public String brokers(Model model) {
        getAllBrokers(model);
        model.addAttribute("broker", BrokerDto.builder().build());
        return "brokers";
    }

    @PostMapping("/add")
    public String addBroker(@ModelAttribute("broker") BrokerDto broker, Model model) {
        brokerService.add(broker);
        getAllBrokers(model);
        return "brokers";
    }

    private void getAllBrokers(Model model) {
        model.addAttribute("brokers", brokerService.list());
    }
}
