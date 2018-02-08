/**
 * 
 */
package yard.config;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;

import com.doc.spring.bean.SimpleBean;

import junit.framework.Assert;

/**
 * @author elmehdi.zangui
 *
 */


@TestPropertySource(locations = { "classpath:main.properties" }, properties = { "prop=New" })
public class PropertiesConfigTests extends AbstractTestConfig {
	@Autowired
	private SimpleBean simpleBean;
//	@Value("#{to.override}")
//	private String toOverride;
//	
	
	@Test
	public void PropertiesLoadingTest() {
		Assert.assertEquals("New", simpleBean.getProp());
		
	}
}
