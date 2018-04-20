package cn.xiuyu.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import cn.xiuyu.CoreAppliaction;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { CoreAppliaction.class })
public class ServiceAppliactionTest extends AbstractJUnit4SpringContextTests {

	@Test
	public void test() {
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanName : beanDefinitionNames) {
			System.out.println(beanName);
		}
	}
}
