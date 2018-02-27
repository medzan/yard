package yard;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.doc.spring.config.Application;
import com.doc.spring.dao.SimpleDao;
import com.doc.spring.model.Simple;

public class TransactionalTests {

	@Test
	public void transactionWork() {
		ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		SimpleDao bean = context.getBean(SimpleDao.class);
		Simple simple = new Simple();
		simple.setName("App");
		try {

			bean.save(simple);
		} catch (RuntimeException e) {
			System.out.println("Exception to ignore " + e);
		}
	}
}
