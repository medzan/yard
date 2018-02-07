/**
 * 
 */
package yard.config;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import com.doc.spring.bean.SimpleBean;
import com.doc.spring.config.ApplicationDev;
import com.doc.spring.config.ApplicationProd;

import junit.framework.Assert;

/**
 * @author elmehdi.zangui
 *
 */
@ContextConfiguration(classes = {  ApplicationProd.class })
//inheritProfiles=true is the default 
@ActiveProfiles(profiles="PROD",inheritProfiles=true)
public class ProfilesConfigTests extends NestedConfigTests {

	@Autowired
	SimpleBean simpleBean;

	@Test
	public void devBeanTest() {
		Assert.assertNotNull(simpleBean);
		Assert.assertEquals("PROD", simpleBean.getProfile());
	}
}
