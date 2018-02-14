/**
 * 
 */
package yard;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.doc.spring.config.Application;

/**
 * @author Elmehdi.zangui
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes=Application.class)
public class MultipleDataSourceTests {

}
