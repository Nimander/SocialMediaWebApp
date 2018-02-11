package socialmediawebapp.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CommentRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Comment> getCommentsFromProfile(String profile){
		return jdbcTemplate.query("select username, message, created_at from comments where on_profile='"+profile+"'",
				(rs, rowNum) -> new Comment(rs.getString("username"), rs.getString("message"), rs.getString("created_at"))
		);
	}

	public int getNumberOfComments(){
		return jdbcTemplate.queryForObject("select count(*) from comments", Integer.class);
	}

	public List<Comment> getAllComments() {
		return jdbcTemplate.query("SELECT username, message, created_at from comments",
				(rs, rowNum) -> new Comment(rs.getString("username"), rs.getString("message"), rs.getString("created_at"))
		);
	}

	public void addNewCommentToDataBase(String userName, String message, String profile){
		jdbcTemplate.update("INSERT INTO comments(username, message, on_profile) VALUES (?, ?, ?)", userName, message, profile);
	}
}
