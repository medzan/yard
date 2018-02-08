package yard;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.doc.spring.aop.Simple;
import com.doc.spring.config.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class AopTests {
	@Autowired
	Simple simple;
	
	@Test
	public void verifyLogAop() {
		simple.invoke();
	}
}
