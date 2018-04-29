package cn.xiuyu.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cn.xiuyu.user.model.ResourceModel;

public interface ResourceRepository extends JpaRepository<ResourceModel, Integer> {

}
