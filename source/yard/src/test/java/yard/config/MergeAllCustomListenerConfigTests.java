/**
 * 
 */
package yard.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestExecutionListeners.MergeMode;
import org.springframework.test.context.junit4.SpringRunner;

import com.doc.spring.bean.SimpleBean;
import com.doc.spring.config.Application;
import com.doc.spring.config.ApplicationDev;

import junit.framework.Assert;
import yard.listener.CustomListener;

/**
 * @author Elmehdi.zangui
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { Application.class,ApplicationDev.class})
@TestExecutionListeners(mergeMode = MergeMode.MERGE_WITH_DEFAULTS, listeners = CustomListener.class)
public class MergeAllCustomListenerConfigTests {

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
