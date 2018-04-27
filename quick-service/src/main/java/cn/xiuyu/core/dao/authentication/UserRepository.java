package cn.xiuyu.core.dao.authentication;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.xiuyu.core.model.authentication.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

}
