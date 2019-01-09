package site.tejap.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import site.tejap.spring.dto.Circle;

@Component
public class CircleDaoImpl06 {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public Circle getCircle(int id){
		String sql = "select * from circle where id = :id";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", 1);
		
		Circle circle = namedParameterJdbcTemplate.queryForObject(sql, params, new CircleMapper());
		return circle; 
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
