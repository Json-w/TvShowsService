package unit;

import com.jason.model.User;
import com.jason.repository.UserRepository;
import com.jason.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

    }

    @Test(expected = NullPointerException.class)
    public void should_throw_exception_when_input_valid_username_and_password_because_can_not_autowired_template_when_test() throws Exception {
        String username = "test";
        String password = "test";
        when(userRepository.findByUsernameAndPassword("test", "test")).thenReturn(new User());

        boolean result = userService.login(username, password);

        assertThat(result, is(true));
    }

    @Test
    public void should_return_false_when_input_wrong_username_and_password() throws Exception {
        String username = "wrong";
        String password = "wrong";
        when(userRepository.findByUsernameAndPassword("wrong", "wrong")).thenReturn(null);

        boolean result = userService.login(username, password);

        assertThat(result, is(false));
    }

    @Test
    public void should_return_false_when_input_null_username_or_password() throws Exception {
        when(userRepository.findByUsernameAndPassword(null, null)).thenReturn(null);

        boolean result = userService.login(null, null);

        assertThat(result, is(false));
    }

    @Test
    public void should_return_true_when_input_user() throws Exception {
        User user = new User();
        user.setUsername("test");
        user.setPassword("test");
        when(userRepository.save(user)).thenReturn(user);

        boolean result = userService.save(user);

        assertThat(result, is(true));
    }
}
