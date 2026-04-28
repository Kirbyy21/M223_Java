package ch.samt.esercizio2;

import ch.samt.esercizio2.Esercizio2Application;
import ch.samt.esercizio2.controller.ProductController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testProducts() throws Exception {

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(view().name("products"))
                .andExpect(content().string(containsString("<th>Name</th>")))
                .andExpect(content().string(containsString("Shoes")));
    }

    @Test
    public void testNewProductsGet() throws Exception {

        mockMvc.perform(get("/newproduct"))
                .andExpect(status().isOk())
                .andExpect(view().name("newproduct"))
                .andExpect(content().string(containsString("New product")));
    }

    @Test
    public void testNewProductsPost() throws Exception {

        mockMvc.perform(post("/newproduct")
                        .param("id", "4")
                        .param("name", "Broccolo")
                        .param("description", "Is green")
                        .param("price", "178.21")
                        .param("expirationDate", "2030-12-31"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/products"));
    }
}