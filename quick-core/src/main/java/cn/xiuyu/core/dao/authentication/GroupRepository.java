package cn.xiuyu.core.dao.authentication;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.xiuyu.core.model.authentication.GroupModel;

public interface GroupRepository extends JpaRepository<GroupModel, Integer> {

}
