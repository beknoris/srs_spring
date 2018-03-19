package kz.kaznitu.player.controllers;


import kz.kaznitu.player.models.Player;
import kz.kaznitu.player.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/player")
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;
    private long a;

    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("player",new Player());
        return "player_add_form";
    }

    @RequestMapping("/addd")
    public String showFormm(Model model){
        model.addAttribute("playerr",new Player());
        return "update";
    }

    @PostMapping("/add")
    public String addPlayer(@ModelAttribute Player player){
        playerRepository.save(player) ;

        return "redirect:/player/all" ;
    }

    @GetMapping("/all")
    public String allPlayers(Model model){
        List<Player> players = (List<Player>) playerRepository.findAll();
        model.addAttribute("players", players) ;
        return "players" ;
    }

}
