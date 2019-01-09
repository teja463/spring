package site.tejap.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import site.tejap.spring.dto.Circle02;

@Component
public class CircleDaoImpl07 {

	
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	public Circle02 getCircle(int id){
		String sql = "select * from circle where id = :id";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", 1);
		
		Circle02 circle = hibernateTemplate.get(Circle02.class, id);
		return circle; 
	}
	
	
}
