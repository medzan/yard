/**
 * 
 */
package yard.config;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.doc.spring.bean.SimpleBean;


/**
 * @author Elmehdi.zangui
 *
 */
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
public class MergeCustomListenerConfigTests extends OnlyCustomListenerConfigTests {

	@Autowired
	private SimpleBean simpleBean;

	/**
	 * Not Null Bean mean that DependencyInjectionTestExecutionListener was not
	 * loaded
	 */
	@Test
	public void customListenerAndDefaultListenerTest() {
		Assert.assertNotNull(simpleBean);
	}
}
