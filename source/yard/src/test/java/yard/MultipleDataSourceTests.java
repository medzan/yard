/**
 * 
 */
package yard;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.BeforeTransaction;
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
// @ActiveProfiles("jdbc")
@Transactional
public class MultipleDataSourceTests {

	@Autowired
	DataSource ds;

	JdbcTemplate jdbcTemplate;
	@Autowired
	SimpleDao simpleDao;

	@Autowired
	private SessionFactory sessionFactory;

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

	@BeforeTransaction
	public void cleanTables() {
		initJdbc();
	}

	@Test
	public void insertUsingHibernate() {
		JdbcTestUtils.deleteFromTables(jdbcTemplate, "simple");
		Simple simple = new Simple();
		simple.setName("simple");
		simpleDao.save(simple);
		sessionFactory.getCurrentSession().flush();
		int countRowsInTable = JdbcTestUtils.countRowsInTable(jdbcTemplate, "SIMPLE");
		Assert.assertEquals(1, countRowsInTable);
	}

	@Test
	public void deleteSimpleHibernate() {
		JdbcTestUtils.deleteFromTables(jdbcTemplate, "simple");
		Simple simple = new Simple();
		simple.setName("simple");
		simpleDao.save(simple);
		sessionFactory.getCurrentSession().flush();
		Assert.assertEquals(1, JdbcTestUtils.countRowsInTable(jdbcTemplate, "SIMPLE"));
		try {
			
			simpleDao.deleteAll(simple);
		}catch(RuntimeException e) {
			System.out.println("Exception to ignore "+e);
		}
		sessionFactory.getCurrentSession().flush();
		Assert.assertEquals(0, JdbcTestUtils.countRowsInTable(jdbcTemplate, "SIMPLE"));

	}
}
