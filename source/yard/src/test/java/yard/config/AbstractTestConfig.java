/**
 * 
 */
package yard.config;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.doc.spring.config.Application;
import com.doc.spring.config.ApplicationDev;
import com.doc.spring.config.ApplicationProd;

/**
 * @author elmehdi.zangui
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { Application.class, ApplicationDev.class, ApplicationProd.class })
public abstract class AbstractTestConfig {

}
