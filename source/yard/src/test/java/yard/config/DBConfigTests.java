/**
 * 
 */
package yard.config;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.transaction.TestTransaction;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.transaction.annotation.Transactional;

import com.doc.spring.config.Application;
import com.doc.spring.config.ds.DSHsqlConfig;

/**
 * @author elmehdi.zangui
 *
 */
//@RunWith(SpringRunner.class)
// @ContextHierarchy({ @ContextConfiguration(classes = Application.class),
// @ContextConfiguration(classes = DSHsqlConfig.class) })
@ContextConfiguration(classes = { Application.class, DSHsqlConfig.class })
@ActiveProfiles("hsql")
//@Transactional
public class DBConfigTests extends AbstractTransactionalJUnit4SpringContextTests {


//	@Autowired
//	@Override
//	public void setDataSource(DataSource dataSource) {
//		super.jdbcTemplate = new JdbcTemplate(dataSource);
//	}
	
	@BeforeTransaction
	public void initTables() {
//		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
//		populator.addScripts(new ClassPathResource("db/sql/create-db.sql"),
//				new ClassPathResource("db/sql/insert-data.sql"));
//		populator.execute(dataSource);
	}

	@Test
	@Sql("classpath:db/sql/create-db.sql")
	@Sql("classpath:db/sql/insert-data.sql")
	public void countOwnersAgin() {
		assertNumUsers(10);

	}

	@Test
	public void countOwners() {
		assertNumUsers(10);
		JdbcTestUtils.deleteFromTables(jdbcTemplate, "owners");
		TestTransaction.flagForCommit();
		TestTransaction.end();
		assertNumUsers(0);

	}

	protected int countRowsInTable(String tableName) {
		return JdbcTestUtils.countRowsInTable(this.jdbcTemplate, tableName);
	}

	protected void assertNumUsers(int expected) {
		Assert.assertEquals("Number of rows in the [owners] table.", expected, countRowsInTable("owners"));
	}
}
