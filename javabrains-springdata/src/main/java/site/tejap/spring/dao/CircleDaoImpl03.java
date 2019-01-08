package site.tejap.spring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import site.tejap.spring.dto.Circle;

@Component
public class CircleDaoImpl03 {

	@Autowired
	private DataSource dataSource;
	
	
	public Circle getCircle(int id){
		Circle circle = new Circle();
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement prepareStatement = conn.prepareStatement("select * from circle where id ="+id);
			ResultSet resultSet = prepareStatement.executeQuery();
			
			while(resultSet.next()){
				int circleId= resultSet.getInt("id");
				int radius = resultSet.getInt("radius");
				circle.setId(circleId);
				circle.setRadius(radius);
			}
			
			resultSet.close();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return circle;
	}
}
