package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import rikkei.academy.model.User;
import rikkei.academy.service.IUserService;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public ModelAndView showFormRegister() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @GetMapping("/showResult")
    public String showResult(Model model){
        Iterable<User> user = userService.findAll();
        model.addAttribute("user",user);
        return "/result";
    }
    @PostMapping("/createUser")
    public String create(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "/index";
        }
        
        userService.save(user);
        return "/result";
    }

}
