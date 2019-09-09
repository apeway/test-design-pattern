package org.liws.adaptor.entity.cache;

import java.util.List;

import org.liws.adaptor.entity.itf.IBaseEntity;
import org.liws.adaptor.entity.itf.IDirEntity;
import org.liws.adaptor.entity.itf.IObjEntity;

/**
 * 客户端懒加载树的相关缓存
 */
public interface IEntityCache {
	List<? extends IDirEntity> getDirsByParentDirId(String parentDirUid);
	List<? extends IObjEntity> getReportsByParentDirId(String parentDirUid);
	List<? extends IObjEntity> getSmartsByParentDirId(String parentDirUid);
	void clearCache();
	void removeEntity(IBaseEntity entity);
	IBaseEntity addEntity(IBaseEntity entity);
	IBaseEntity updateEntity(IBaseEntity entity);
}