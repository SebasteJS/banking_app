package pl.sda.demo.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.demo.dto.UserDto;
import pl.sda.demo.service.UserService;
import javax.validation.Valid;
@Controller
@RequiredArgsConstructor
public class RegistrationController {
    private final UserService userService;
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new UserDto());
        return "registration-form";
    }
    @PostMapping("/registration")
    public String registrationAdding(@ModelAttribute("user") @Valid UserDto user2,
                                     BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            userService.add(user2);// nie zapisuje do bazy nie wiem czemu
            return "login-form";
        }
        return "registration-form";
    }
    @Secured("ROLE_ADMIN")//
    @PostMapping("users/update")
    public String updateUser(@ModelAttribute("user") @Valid UserDto userdto, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            userService.update(userdto);
            return "login-form";
        }
        return "registration-form";
    }
    @Secured("ROLE_ADMIN")//
    @PostMapping("users/delete")
    public String deleteUser(@ModelAttribute("user") @Valid UserDto user) {
        userService.delete(user.getId());
        return "registration-form";
    }
}