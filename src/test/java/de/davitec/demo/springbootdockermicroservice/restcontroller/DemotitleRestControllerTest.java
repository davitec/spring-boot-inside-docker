package de.davitec.demo.springbootdockermicroservice.restcontroller;

import de.davitec.demo.springbootdockermicroservice.models.DemoTitle;
import de.davitec.demo.springbootdockermicroservice.repositories.DemotitleRepository;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = DemotitleRestController.class)
public class DemotitleRestControllerTest {

    @Autowired MockMvc mockMvc;

    @MockBean
    DemotitleRepository demotitleRepository;

    DemoTitle dt;

    @Before
    public void setup(){
        dt = new DemoTitle();
        dt.setTitle("Hi");
        dt.setId(1000);
        Mockito.when(demotitleRepository.findAll()).thenReturn(Collections.singletonList(dt));
    }

    @Test
    public void getDemotitles() throws Exception {
        mockMvc.perform(
                    get("/api/demotitle")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                    )
                    .andExpect(status().isOk())
                    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$[0].id", Matchers.is(1000)))
                    .andExpect(jsonPath("$[0].title", Matchers.is("Hi")));
    }

}
