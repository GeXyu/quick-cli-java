package cn.xiuyu.core;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import cn.xiuyu.CoreAppliaction;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { CoreAppliaction.class })
public class CoreApplicationTest extends AbstractJUnit4SpringContextTests {

}
