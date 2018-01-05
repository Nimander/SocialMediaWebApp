package socialmediawebapp.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CommentRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int getNumberOfComments(){
		return jdbcTemplate.queryForObject("select count(*) from comments", Integer.class);
	}

	public List<Comment> getAllComments() {
		return jdbcTemplate.query("SELECT username, message, created_at from comments",
				(rs, rowNum) -> new Comment(rs.getString("username"), rs.getString("message"), rs.getString("created_at"))
		);
	}

	public void addNewCommentToDataBase(String userName, String message){

		jdbcTemplate.update("INSERT INTO comments(username, message) VALUES (?, ?)", userName, message);
	}
}
