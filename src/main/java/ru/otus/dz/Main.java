package ru.otus.dz;

import org.springframework.context.annotation.PropertySource;
import ru.otus.dz.dao.ReadService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.dz.services.TestService;
import ru.otus.dz.dao.UserService;

@ComponentScan
@PropertySource("application.properties")
public class Main {

	public static void main(String[] args) throws Exception{
		AnnotationConfigApplicationContext cntx = new AnnotationConfigApplicationContext(Main.class);
		ReadService rs = cntx.getBean(ReadService.class);
		TestService ts = cntx.getBean(TestService.class);
		UserService us = cntx.getBean(UserService.class);
		ts.doTest(us.getUserData(), rs.getData());
	}
}
