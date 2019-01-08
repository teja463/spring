package site.tejap.spring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.stereotype.Component;

import site.tejap.spring.dto.Circle;

@Component
public class CircleDaoImpl {

	public Circle getCircle(int id){
		Circle circle = new Circle();
		
		Connection conn = null;
		try {
			Properties connProps = new Properties();
			connProps.setProperty("user", "root");
			connProps.setProperty("password", "root");
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabrains-springdata" ,connProps);
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
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
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
