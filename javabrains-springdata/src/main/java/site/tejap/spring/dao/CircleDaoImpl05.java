package site.tejap.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import site.tejap.spring.dto.Circle;

@Component
public class CircleDaoImpl05 {

	private JdbcTemplate jdbcTemplate;
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public Circle getCircle(int id){
		String sql = "select * from circle where id = ?";
		Circle circle = jdbcTemplate.queryForObject(sql, new Object[]{id}, new CircleMapper());
		return circle; 
	}
	
	public List<Circle> getAllCircles(){
		
		String sql = "select * from circle";
		List<Circle> circles = jdbcTemplate.query(sql, new CircleMapper());
		return circles;
	}
	
	public int inserCircle(Circle circle){
		String sql = "insert into circle values(?, ?)";
		int update = jdbcTemplate.update(sql,circle.getId(), circle.getRadius());
		return update;
	}
	
	private static final class CircleMapper implements RowMapper<Circle>{

		@Override
		public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
			Circle circle = new Circle();
			circle.setId(rs.getInt("id"));
			circle.setRadius(rs.getInt("radius"));
			return circle;
		}
		
	}
}
