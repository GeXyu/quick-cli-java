package cn.xiuyu.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cn.xiuyu.user.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

    /**
     * @param username
     */
    UserModel findByUsername(String username);

}
