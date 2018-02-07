/**
 * 
 */
package yard.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

/**
 * @author Elmehdi.zangui
 *
 */
public class CustomListener 
extends AbstractTestExecutionListener 
{

	Logger logger = LoggerFactory.getLogger(CustomListener.class);

	public void beforeTestClass(TestContext testContext) throws Exception {
		logger.info("beforeTestClass ");
	}

	public void prepareTestInstance(TestContext testContext) throws Exception {
		logger.info("prepareTestInstance ");

	}

	public void beforeTestMethod(TestContext testContext) throws Exception {
		logger.info("beforeTestMethod ");
	}

	public void afterTestMethod(TestContext testContext) throws Exception {
		logger.info("afterTestMethod ");
	}

	public void afterTestClass(TestContext testContext) throws Exception {
		logger.info("afterTestClass ");
	}

}
