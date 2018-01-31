package yard;

import static org.hamcrest.CoreMatchers.instanceOf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.doc.spring.aop.introduction.IInto;
import com.doc.spring.aop.service.CustomService;
import com.doc.spring.aop.target.AopCaller;
import com.doc.spring.aop.target.AopTargetedObject;
import com.doc.spring.config.Application;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class AopTests {
	@Autowired
	AopCaller caller;

	@Test
	public void initTest() {
		 ApplicationContext context = new
		 AnnotationConfigApplicationContext(Application.class);
		 IInto bean = (IInto) context.getBean(CustomService.class);
		 Assert.assertNotNull(bean);
		 String implemented = bean.isImplemented();
		 System.out.println(implemented);
		 AopCaller caller = context.getBean(AopCaller.class);
		String unknown = caller.AskYourTarget();
//		Assert.assertEquals(AopTargetedObject.class.getName() + " Nothing", unknown);
	}
}
