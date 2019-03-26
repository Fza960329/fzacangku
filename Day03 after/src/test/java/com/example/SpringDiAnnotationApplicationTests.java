package com.example;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bean.ExampleBean;
import com.example.service.HelloWorldService;

@RunWith(SpringRunner.class)
// @ContextConfiguration(classes= {SampleConfig.class})
@SpringBootTest
public class SpringDiAnnotationApplicationTests {
	@Autowired
	private ApplicationContext context;

	@Autowired // by type 可以应用在字段、构造函数和多参数方法上
	// @Qualifier("helloService")
	private HelloWorldService helloWorldService;

	// @Autowired
	@Resource // by name 只能用在单个参数的字段和带Bean属性的setter方法
	private ExampleBean exampleBean;

	@Test
	public void contextLoads() {

	}

	@Test
	public void test() {
		System.out.println("---test begin----");
		this.helloWorldService.sayHello();
		System.out.println(exampleBean.getBeanOne().getName());
		System.out.println(exampleBean.getBeanTwo().getName());
	}

	@Test
	public void testListBeans() {
		int count = context.getBeanDefinitionCount();
		System.out.println("Beans的个数：" + count);
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name + "--->");
			Object bean = context.getBean(name);
			System.out.println(bean.getClass());
		}
	}
}
