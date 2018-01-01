package com.wordpress.nimanderdev.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Component
public class CommentRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int getNumberOfProducts(){
		return jdbcTemplate.queryForObject("select count(*) from tasks", Integer.class);
	}

	public List<Comment> getAllComments() {
		jdbcTemplate.update("SET time_zone='+05:00'");
		List<Comment> commentList = jdbcTemplate.query("SELECT username, message, timestamp1 from comment",
				new RowMapper<Comment>(){
					public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
						return new Comment(rs.getString("username"), rs.getString("message"), rs.getString("timestamp1"));
					}
				}
		);
		return commentList;
	}

	public void addNewCommentToDataBase(String userName, String message){

		jdbcTemplate.update("INSERT INTO comment(username, message)\n" +
				"VALUES (?, ?)", userName, message);
	}
}
