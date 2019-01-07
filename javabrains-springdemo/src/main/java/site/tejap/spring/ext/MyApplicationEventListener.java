package site.tejap.spring.ext;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import site.tejap.spring.beans.DrawEvent;

@Component
public class MyApplicationEventListener implements ApplicationListener<DrawEvent>{

	@Override
	public void onApplicationEvent(DrawEvent event) {
		System.out.println(event.toString());
	}

}
