package Intg.com.jason.controller;

import com.alibaba.fastjson.JSON;
import com.jason.TvShowsApplication;
import com.jason.controller.UserController;
import com.jason.model.User;
import com.jason.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {TvShowsApplication.class})
@WebAppConfiguration
@Transactional
public class UserControllerTest {
    @Autowired
    private UserController userController;
    @Autowired
    private UserRepository userRepository;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void should_return_login_success_when_input_valid_username_and_password() throws Exception {
        User user = new User();
        user.setUsername("testwp");
        user.setPassword("testwp");
        userRepository.save(user);

        mockMvc.perform(post("/user/login").param("username", user.getUsername()).param("password", user.getPassword()))
                .andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.statusCode").value(1))
                .andExpect(jsonPath("$.statusDesc").value("success"))
                .andExpect(jsonPath("$.data.user.username").value("testwp"));

    }

    @Test
    public void should_return_login_failure_when_input_invalid_username_and_password() throws Exception {
        User emptyUserInDB = new User();
        emptyUserInDB.setUsername("test");
        emptyUserInDB.setPassword("test");

        mockMvc.perform(post("/user/login").param("username", emptyUserInDB.getUsername()).param("password", emptyUserInDB.getPassword()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.statusCode").value(0))
                .andExpect(jsonPath("$.statusDesc").value("failure"));
    }

    @Test
    public void should_return_register_success_info_when_input_valid_info() throws Exception {
        User tempUser = userRepository.findByUsername("test");
        if (null != tempUser) {
            userRepository.delete(tempUser.getId());
        }
        User registerUser = new User();
        registerUser.setUsername("test");
        registerUser.setPassword("test");

        mockMvc.perform(post("/user/register").contentType(MediaType.APPLICATION_JSON).content(JSON.toJSONString(registerUser)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.statusCode").value(1))
                .andExpect(jsonPath("$.statusDesc").value("success"));

    }
}
