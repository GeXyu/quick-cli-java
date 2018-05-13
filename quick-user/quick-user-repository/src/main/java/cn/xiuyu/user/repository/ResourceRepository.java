package cn.xiuyu.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.xiuyu.user.model.ResourceModel;

public interface ResourceRepository extends JpaRepository<ResourceModel, Integer> {

    /**
     * @return
     */
    List<ResourceModel> findByParentIsNull();

    /**
     * 根据组 查询顶级资源
     * @return
     */
    @Query(value = " select ar.* from authentication_resource ar left join authentication_group_resource_relation agrr on agrr.resource_name = ar.id\r\n"
            + "left join authentication_group ag on ag.id = agrr.group_name where  ar.parent is null  and ag.id = :groupId", nativeQuery = true)
    List<ResourceModel> findTopReourceByGroup(@Param("groupId") Integer groupId);

    
    /**
     * 根据顶级资源和组查询子资源
     * @param parentId
     * @param groupId
     * @return
     */
    @Query(value = " select ar.* from authentication_resource ar left join authentication_group_resource_relation agrr on agrr.resource_name = ar.id\r\n"
            + "left join authentication_group ag on ag.id = agrr.group_name where  ar.parent = :parentId   and ag.id = :groupId", nativeQuery = true)
    List<ResourceModel> findByParentAndGroup(@Param("parentId") Integer parentId, @Param("groupId") Integer groupId);

}
