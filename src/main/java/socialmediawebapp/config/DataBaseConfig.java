package socialmediawebapp.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfig {
	@Bean
	public DataSource dataSource(){
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setDatabaseName("socialmediawebapp");
		dataSource.setServerName("192.168.56.101");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(){
		return new JdbcTemplate(dataSource());
	}
}