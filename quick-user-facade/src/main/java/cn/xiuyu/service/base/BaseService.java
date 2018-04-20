package cn.xiuyu.service.base;

/**
 * 公共服务
 * @author ge
 *
 * @param <M>
 * @param <T>
 */
public interface BaseService<M, T> {

	M save(M m);

	M update(M m);

	M show(T id);

	void delete(T id);
}
