package mathpar.web.learning.tasks;

import mathpar.web.learning.tasks._configs.LearningApplication;
import mathpar.web.learning.tasks.services.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest(classes = LearningApplication.class)
class LearningApplicationTests {
	@MockBean
	public AccountService accountService;

	@Test
	void contextLoads() {
	}

}
