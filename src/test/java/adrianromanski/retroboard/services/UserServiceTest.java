package adrianromanski.retroboard.services;

import adrianromanski.retroboard.model.User;
import adrianromanski.retroboard.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    private UserService userService;

    @Before
    public void setUp() {
        this.userService = new UserService(userRepository);
    }

    @Test
    public void getAllCommentsForToday() {
        // Given
        User user = new User();
        user.setUsername("Adrian");
        user.setPassword("Password");
        user.setRole("User");

        when(userRepository.findByUsername("Adrian")).thenReturn(user);

        // When
        UserDetails actual = userService.loadUserByUsername("Adrian");

        // Then
        verify(userRepository, times(1)).findByUsername("Adrian");
    }
}

