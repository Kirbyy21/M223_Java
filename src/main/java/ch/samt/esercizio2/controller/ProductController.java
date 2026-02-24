package ch.samt.esercizio2.controller;

import ch.samt.esercizio2.model.Product;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@Controller
public class ProductController {

    private static Map<Integer, Product> products = new HashMap<>();

    static {
        products.put(1, new Product(1, "Hoodie", "Sport hoodie", 79.90, LocalDate.now().plusMonths(6)));
        products.put(2, new Product(2, "Shoes", "Running shoes", 129.90, LocalDate.now().plusMonths(12)));
        products.put(3, new Product(3, "Backpack", "Backpack for school", 59.90, LocalDate.now().plusMonths(8)));
    }

    @GetMapping("/products")
    public String getProducts(@RequestParam(required = false) String name, @RequestParam(required = false) Double pricelessthan, Model model) {

        List<Product> result = new ArrayList<>(products.values());

        if (name != null) {
            result = result.stream().filter(p -> p.getName().toLowerCase().contains(name.toLowerCase())).toList();
        }

        if (pricelessthan != null) {
            result = result.stream().filter(p -> p.getPrice() < pricelessthan).toList();
        }

        model.addAttribute("products", result);
        return "products";
    }

    @GetMapping("/newproduct")
    public String newProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "newproduct";
    }

    @PostMapping("/newproduct")
    public String addProduct(@Valid @ModelAttribute Product product, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "newproduct";
        }

        products.put(product.getId(), product);
        return "redirect:/products";
    }

    @GetMapping("/products/show/{id}")
    public String showProduct(@PathVariable Integer id, Model model) {

        Product product = products.get(id);

        if (product == null) {
            model.addAttribute("error", "Products not found");
            return "error";
        }

        model.addAttribute("product", product);
        return "showproduct";
    }
}