package ch.samt.videogames.controller;

import ch.samt.videogames.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import ch.samt.videogames.domain.Player;

@RequestMapping("/videogames")
@Controller
public class PlayerController {
    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public String loadPlayers(Model model) {
        model.addAttribute("players", playerService.findAll());
        return "playersList";
    }
}
