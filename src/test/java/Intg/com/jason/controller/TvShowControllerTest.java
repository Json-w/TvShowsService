package Intg.com.jason.controller;

import com.jason.TvShowsApplication;
import com.jason.controller.TvShowController;
import com.jason.model.TvShow;
import com.jason.repository.TvShowRepository;
import com.jason.service.TvShowService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {TvShowsApplication.class})
@WebAppConfiguration
@Transactional
public class TvShowControllerTest {
    @Autowired
    private TvShowController tvShowController;

    private MockMvc mockMvc;

    @Autowired
    private TvShowRepository tvShowRepository;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(tvShowController).build();
    }

    @Test
    public void should_return_paging_result() throws Exception {
        TvShow forTest = new TvShow();
        forTest.setName("行尸走肉");
        forTest.setOriginName("the walking dead");
        forTest.setShowPlatform("AMC");
        tvShowRepository.save(forTest);
        mockMvc.perform(get("/tvShow/listLatest").param("page", "0").param("size", "10"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.statusCode").value(1))
                .andExpect(jsonPath("$.data.content[0].name").value("行尸走肉"));

    }
}
