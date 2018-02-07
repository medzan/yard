package yard.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfilesResolver;

public class ProfileResolver implements ActiveProfilesResolver {

//	@Autowired
//	ApplicationContext context;

	public String[] resolve(Class<?> arg0) {
//		System.out.println(" === " + context.getEnvironment());
		return new String[] { "default" };
	}

}
