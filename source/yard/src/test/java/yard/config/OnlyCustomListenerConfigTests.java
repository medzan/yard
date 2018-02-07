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

import junit.framework.Assert;
import yard.listener.CustomListener;

/**
 * @author Elmehdi.zangui
 *
 */
/*
 * Register the only custom test (default Listener not registered
 * ServletTestExecutionListener.class,
 * DirtiesContextBeforeModesTestExecutionListener.class,
 * DependencyInjectionTestExecutionListener.class,
 * DirtiesContextTestExecutionListener.class,
 * TransactionalTestExecutionListener.class,
 * SqlScriptsTestExecutionListener.class
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { Application.class })
@TestExecutionListeners(listeners ={ CustomListener.class })
public class OnlyCustomListenerConfigTests {

	@Autowired
	private SimpleBean bean;

	/**
	 * Null Bean mean that DependencyInjectionTestExecutionListener was not loaded
	 */
	@Test
	public void customListenerOnlyTest() {
		Assert.assertNull(bean);
	}
}
