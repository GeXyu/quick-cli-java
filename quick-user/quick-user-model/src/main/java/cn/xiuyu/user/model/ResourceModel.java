package cn.xiuyu.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.xiuyu.core.model.base.BaseModel;
import cn.xiuyu.core.model.base.TableConstant;

@Entity
@Table(name = TableConstant.AUTHENTICATION + "resource")
public class ResourceModel extends BaseModel {

    private static final long serialVersionUID = -644158204480893845L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // 资源名
    @Column(name = "name")
    private String name;

    // path
    @Column(name = "path")
    private String path;

    // router文件路径
    @Column(name = "router")
    private String router;

    // 父亲
    @ManyToOne
    @JoinColumn(name = "parent", nullable = true)
    private ResourceModel parent;

    @Column(name = "description")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path
     *            the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the router
     */
    public String getRouter() {
        return router;
    }

    /**
     * @param router
     *            the router to set
     */
    public void setRouter(String router) {
        this.router = router;
    }

    /**
     * @return the parent
     */
    public ResourceModel getParent() {
        return parent;
    }

    /**
     * @param parent
     *            the parent to set
     */
    public void setParent(ResourceModel parent) {
        this.parent = parent;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public ResourceModel() {
        super();
    }

}
