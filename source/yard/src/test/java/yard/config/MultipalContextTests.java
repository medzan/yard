/**
 * 
 */
package yard.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringRunner;

import com.doc.spring.bean.SimpleBean;
import com.doc.spring.config.Application;
import com.doc.spring.config.ApplicationChild;

import junit.framework.Assert;

/**
 * @author elmehdi.zangui
 *
 */
@RunWith(SpringRunner.class)
@ContextHierarchy({ @ContextConfiguration(classes = Application.class),
		@ContextConfiguration(classes = ApplicationChild.class) }

)
public class MultipalContextTests {

	@Autowired
	SimpleBean simpleBean;

	@Test
	public void configLoadedTest() {
		Assert.assertNotNull(simpleBean);
	}
}
