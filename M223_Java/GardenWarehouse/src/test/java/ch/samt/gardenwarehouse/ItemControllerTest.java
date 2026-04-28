package ch.samt.gardenwarehouse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testList() throws Exception {
        mockMvc.perform(get("/items"))
                .andExpect(status().isOk())
                .andExpect(view().name("itemList"))
                .andExpect(content().string(containsString("Name")));
    }

    @Test
    void testDetail() throws Exception {
        mockMvc.perform(get("/items/abc-12"))
                .andExpect(status().isOk())
                .andExpect(view().name("itemList"));
    }

    @Test
    void testSell() throws Exception {
        mockMvc.perform(get("/items/sell?code=abc-12"))
                .andExpect(status().isOk())
                .andExpect(view().name("itemList"));
    }

    @Test
    void testAdd() throws Exception {
        mockMvc.perform(get("/items/add?code=abc-12&number=5"))
                .andExpect(status().isOk())
                .andExpect(view().name("itemList"));
    }

    @Test
    void testInsert() throws Exception {
        mockMvc.perform(post("/items/insert")
                        .param("code", "xyz-99")
                        .param("name", "Carciofo")
                        .param("type", "pianta")
                        .param("price", "12.50")
                        .param("itemCount", "10"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/items/xyz-99"));
    }
}