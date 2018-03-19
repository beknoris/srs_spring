package kz.kaznitu.player.controllers;

import kz.kaznitu.player.models.Player;
import kz.kaznitu.player.models.Salary;
import kz.kaznitu.player.repositories.PlayerRepository;
import kz.kaznitu.player.repositories.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/salary")
public class SalaryController {
    @Autowired
    private SalaryRepository salaryRepository;
    private long a;

    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("salary",new Salary());
        return "salary_add_form";
    }

    @PostMapping("/add")
    public String addSalary(@ModelAttribute Salary salary){
        salaryRepository.save(salary) ;

        return "redirect:/salary/all" ;
    }

    @GetMapping("/all")
    public String allSalary(Model model){
        List<Salary> salaries = (List<Salary>) salaryRepository.findAll();
        model.addAttribute("salaries", salaries) ;
        return "salaries" ;
    }

}