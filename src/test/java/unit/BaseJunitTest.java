package unit;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

public class BaseJunitTest {
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
}
