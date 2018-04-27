package cn.xiuyu.core.dao.authentication;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.xiuyu.core.model.authentication.ResourceModel;

public interface ResourceRepository extends JpaRepository<ResourceModel, Integer> {

}
