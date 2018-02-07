package yard.config;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import com.doc.spring.bean.NestedBean;

import junit.framework.Assert;

@ContextConfiguration
//@ActiveProfiles("DEV")
public class NestedConfigTests extends MergeAllCustomListenerConfigTests {
	@Configuration
	static class config {

		@Bean
		public NestedBean nestedBean() {
			return new NestedBean();
		}
	}

	@Autowired
	@Qualifier("nestedBean")
	NestedBean nestedBean;

	@Test
	public void nestedBeanTest() {
		Assert.assertNotNull(nestedBean);
	}
}
