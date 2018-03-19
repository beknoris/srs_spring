package kz.kaznitu.player.controllers;

import kz.kaznitu.player.models.Player;
import kz.kaznitu.player.models.Sport;
import kz.kaznitu.player.repositories.PlayerRepository;
import kz.kaznitu.player.repositories.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/sport")
public class SportController {
    @Autowired
    private SportRepository sportRepository;

    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("sport",new Sport());
        return "sport_add_form";
    }

    @PostMapping("/add")
    public String addPlayer(@ModelAttribute Sport sport){
        sportRepository.save(sport) ;

        return "redirect:/sport/all" ;
    }

    @GetMapping("/all")
    public String allPlayers(Model model){
        List<Sport> sports = (List<Sport>) sportRepository.findAll();
        model.addAttribute("sports", sports) ;
        return "sports" ;
    }
}
