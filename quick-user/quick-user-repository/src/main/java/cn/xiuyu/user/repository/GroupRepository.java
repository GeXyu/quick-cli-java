package cn.xiuyu.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cn.xiuyu.user.model.GroupModel;

public interface GroupRepository extends JpaRepository<GroupModel, Integer> {

}
