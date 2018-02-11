package socialmediawebapp.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void registerUser(String username, String email, String password){
		jdbcTemplate.update("INSERT INTO users(username, passwd, enabled) VALUES (?, ?, ?)", username, password, 1);
		jdbcTemplate.update("INSERT INTO user_roles(username, role) VALUES (?, ?)", username, "ROLE_USER");
	}

	
}
