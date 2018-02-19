/**
 * 
 */
package yard;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.transaction.annotation.Transactional;

import com.doc.spring.config.Application;
import com.doc.spring.dao.SimpleDao;
import com.doc.spring.model.Simple;

import junit.framework.Assert;

/**
 * @author Elmehdi.zangui
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
//@ActiveProfiles("jdbc")
@Transactional
public class MultipleDataSourceTests {

	@Autowired
	DataSource ds;

	JdbcTemplate jdbcTemplate;
	@Autowired
	SimpleDao simpleDao;

	@Before
	public void initJdbc() {
		jdbcTemplate = new JdbcTemplate(ds);
	}

	@Test
	public void dataSourceWork() {
		Assert.assertNotNull(ds);
	}

	@Test
	public void readDeleteDataByJdbc() {

		int countRowsInTable = JdbcTestUtils.countRowsInTable(jdbcTemplate, "simple");
		Assert.assertEquals(1, countRowsInTable);
		JdbcTestUtils.deleteFromTables(jdbcTemplate, "simple");
		Assert.assertEquals(1, countRowsInTable);
	}

	@Test
	public void insertUsingHibernate() {
		Simple simple = new Simple();
		simple.setName("simple");
		simpleDao.save(simple);
		int countRowsInTable = JdbcTestUtils.countRowsInTable(jdbcTemplate, "simple");
		Assert.assertEquals(1, countRowsInTable);
	}
}
