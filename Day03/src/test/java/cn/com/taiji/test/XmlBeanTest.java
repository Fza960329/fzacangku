package cn.com.taiji.test;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.NestedIOException;

public class XmlBeanTest {
	private AbstractApplicationContext context;
	
	public  void ApplicationContextTest(){
		context = new FileSystemXmlApplicationContext("classpath:/META-INF/application-context.xml");
		context.registerShutdownHook();
	}
	
	
}
