package cn.xiuyu.core.model.authentication;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import cn.xiuyu.core.CoreApplicationTest;
import cn.xiuyu.core.dao.authentication.UserRepository;

public class UserRepositoryTest extends CoreApplicationTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	@Rollback(false)
	public void testAdd() {

		UserModel user = new UserModel();
		user.setCreateManager("test");
		user.setCreateTime(new Date());
		user.setUsername("teset");
		user.setPassword("test");

		userRepository.save(user);
	}
}
