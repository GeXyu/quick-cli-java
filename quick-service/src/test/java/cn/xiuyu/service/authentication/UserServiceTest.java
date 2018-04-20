package cn.xiuyu.service.authentication;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;

import cn.xiuyu.core.model.authentication.UserModel;
import cn.xiuyu.service.ServiceAppliactionTest;
import cn.xiuyu.service.authentication.api.UserService;

public class UserServiceTest extends ServiceAppliactionTest {

	@Autowired
	private UserService userService;

	@Test
	@Commit
	public void testSave() {

		UserModel user = new UserModel();
		user.setUsername("123");
		user.setPassword("123");
		user.setEnable(Byte.valueOf("1"));

		userService.save(user);
	}
	
	@Test
	public void testFind(){
		UserModel user = userService.show(1);
		System.out.println(user.getUsername());
	}
}
