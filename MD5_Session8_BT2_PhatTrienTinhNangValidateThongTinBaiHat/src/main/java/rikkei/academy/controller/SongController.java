package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import rikkei.academy.model.Song;
import rikkei.academy.service.ISongService;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;
    @GetMapping("/")
    public ModelAndView showFormSongInfo(){
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("song",new Song());
        return modelAndView;
    }
    @PostMapping("/createSongInfo")
    public String create(@Validated @ModelAttribute("song") Song song, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            return "/index";
        }
        songService.save(song);
        model.addAttribute("message","Thêm mới thành công");
        return "/index";
    }
}
