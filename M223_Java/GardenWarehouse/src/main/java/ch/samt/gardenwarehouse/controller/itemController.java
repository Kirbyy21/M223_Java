package ch.samt.gardenwarehouse.controller;

import ch.samt.gardenwarehouse.domain.Item;
import ch.samt.gardenwarehouse.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ch.samt.gardenwarehouse.service.ItemService;

@RequestMapping("/items")
@Controller
public class itemController {
    private final ItemService itemService;

    @Autowired
    public itemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public String loadCustomers(Model model) {
        model.addAttribute("items", itemService.findAll());
        return "itemList";
    }


    @GetMapping("/{code}")
    public String detailCustomer(@PathVariable String code, Model model) {
        Item item = itemService.getByCode(code);
        if (item == null) {
            model.addAttribute("error", "Item not found");
            return "itemList";
        }
        model.addAttribute("item", item);
        return "itemDetails";
    }

    @GetMapping("/sell")
    public String sell(@RequestParam String code, Model model) {
        Item item = itemService.sell(code);
        if (item == null) {
            model.addAttribute("error", "Error with the sales");
            return "itemList";
        }
        return "redirect:/items/" + code;
    }

    @GetMapping("/add")
    public String add(@RequestParam String code, @RequestParam int number, Model model) {
        Item item = itemService.add(code, number);
        if (item == null) {
            model.addAttribute("error", "Item not found");
            return "itemList";
        }
        return "redirect:/items/" + code;
    }

    @GetMapping("/insert")
    public String insertForm(Model model) {
        model.addAttribute("item", new Item());
        return "insert";
    }

    @PostMapping("/insert")
    public String insertSubmit(@Valid @ModelAttribute Item item, BindingResult result, Model model, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "insert";
        }

        Item saved = itemService.insert(item);
        if (saved == null) {
            model.addAttribute("error", "Code alredy exists");
            return "insert";
        }

        return "redirect:/items";
    }
}

