package yard.config;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import com.doc.spring.bean.SimpleBean;

import junit.framework.Assert;
import yard.resolver.ProfileResolver;

//Inhert all profile
@ActiveProfiles(resolver=ProfileResolver.class,inheritProfiles=false)
public class ProfileResolveConfigTest  extends ProfilesConfigTests{

	@Autowired 
	SimpleBean simpleBean;
	
	@Test
	public void resolvingDevProfilTest() {
		Assert.assertNotNull(simpleBean);
		Assert.assertEquals("default", simpleBean.getProfile());
	}
}
