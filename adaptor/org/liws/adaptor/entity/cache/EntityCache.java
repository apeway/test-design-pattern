package org.liws.adaptor.entity.cache;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.liws.adaptor.entity.itf.EntityConst;
import org.liws.adaptor.entity.itf.IBaseEntity;
import org.liws.adaptor.entity.itf.IDirEntity;
import org.liws.adaptor.entity.itf.IObjEntity;

@SuppressWarnings("unchecked")
public class EntityCache implements IEntityCache {
	
	// ============================== 单例  =============================
	private static EntityCache instance = new EntityCache();
	private EntityCache(){}
	public static EntityCache getInstance(){
		return instance;
	}

	// ======================== 常量定义  ===================================
	public static String DIR_TYPE = "$DIR";
	public static String REPORT_TYPE = "$REPORT";
	public static String SMART_TYPE = "$SMART";
	private String keyForDirs(String parentDirUid) {
		return parentDirUid + DIR_TYPE;
	}
	private String keyForReports(String parentDirUid) {
		return parentDirUid + REPORT_TYPE;
	}
	private String keyForSmarts(String parentDirUid) {
		return parentDirUid + SMART_TYPE;
	}
	
	// ========================== 接口实现  =================================
	/**
	 * 实体缓存: 
	 * parentDirUid$DIR 	--> 目录缓存 (DirEntity)
	 * parentDirUid$REPORT 	--> 报表缓存 (ObjEntity)
	 * parentDirUid$SMART	--> 语义模型缓存 (ObjEntity)
	 */
	private static Map<String, List<? extends IBaseEntity>> entityCache = new HashMap<>();
	
	@Override
	public List<? extends IDirEntity> getDirsByParentDirId(String parentDirUid) {
		if (StringUtils.isEmpty(parentDirUid)) {
			return null;
		}
		
		String keyForDirs = keyForDirs(parentDirUid);
		List<? extends IBaseEntity> result = entityCache.get(keyForDirs);
		if(result == null) {
			List<? extends IDirEntity> subDirs = loadSubDirsFromDB(parentDirUid);
			if(subDirs != null && !subDirs.isEmpty()) {
				entityCache.put(keyForDirs, subDirs);
				return subDirs;
			}
		}
		return (List<IDirEntity>) result;
	}
	private List<? extends IDirEntity> loadSubDirsFromDB(String parentDirUid) {
		return null;
	}
	
	private List<? extends IObjEntity> getObjEntitiesByParentDirId(String parentDirUid, int objEntityType) {
		if(StringUtils.isEmpty(parentDirUid)) {
			return null;
		}
		
		String keyForObjs = null;
		if(objEntityType == EntityConst.ANA_TYPE_REPORT) {
			keyForObjs = keyForReports(parentDirUid);
		} else if(objEntityType == EntityConst.ANA_TYPE_DATASET_SMART) {
			keyForObjs = keyForSmarts(parentDirUid);
		}
		
		List<? extends IBaseEntity> result = entityCache.get(keyForObjs);
		if(result == null) {
			List<? extends IObjEntity> subObjs = loadSubObjsFromDB(parentDirUid);
			if(subObjs != null && !subObjs.isEmpty()) {
				entityCache.put(keyForObjs, subObjs);
				return subObjs;
			}
		}
		return (List<? extends IObjEntity>) result;
	}
	private List<? extends IObjEntity> loadSubObjsFromDB(String parentDirUid) {
		return null;
	}
	
	@Override
	public List<? extends IObjEntity> getReportsByParentDirId(String parentDirUid) {
		return getObjEntitiesByParentDirId(parentDirUid, EntityConst.ANA_TYPE_REPORT);
	}
	
	@Override
	public List<? extends IObjEntity> getSmartsByParentDirId(String parentDirUid) {
		return getObjEntitiesByParentDirId(parentDirUid, EntityConst.ANA_TYPE_DATASET_SMART);
	}
	
	@Override
	public void clearCache() {
		entityCache.clear();
	}
	
	@Override
	public void removeEntity(IBaseEntity entity) {
		// 删除目录实体
		if(entity instanceof IDirEntity) {
			removeDir(entity);
		}
		// 删除对象实体
		else if(entity instanceof IObjEntity) {
			removeObj(entity);
		}
	}
	
	private void removeObj(IBaseEntity entity) {
		removeObjFromDB(entity.getUid());
		removeObjFromCache(entity);
	}
	private void removeObjFromDB(String uid) {
		//
	}
	private void removeObjFromCache(IBaseEntity entity) {
		IObjEntity obj = (IObjEntity)entity;
		String puid = obj.getDirUid();
		int type = obj.getType();
		
		List<? extends IObjEntity> objs = null;
		if(type == EntityConst.ANA_TYPE_REPORT) {
			objs = getInstance().getReportsByParentDirId(puid);
		} else if(type == EntityConst.ANA_TYPE_DATASET_SMART) {
			objs = getInstance().getSmartsByParentDirId(puid);
		}
		
		if(objs == null || objs.size() < 1) return;
		
		ListIterator<? extends IObjEntity> listIterator = objs.listIterator();
		while(listIterator.hasNext()){
			if(listIterator.next().getUid().equals(entity.getUid())){
				listIterator.remove();
			}
		}
	}
	
	private void removeDir(IBaseEntity entity) {
		checkBeforeRemoveDir(entity);
		removeDirFromDB(entity.getUid());
		removeDirFromCache(entity);
	}
	private void checkBeforeRemoveDir(IBaseEntity dirEntity) {
		String dirUid = dirEntity.getUid();
		List<? extends IDirEntity> dirs = getInstance().getDirsByParentDirId(dirUid);
		List<? extends IObjEntity> reports = getInstance().getReportsByParentDirId(dirUid);
		List<? extends IObjEntity> smarts = getInstance().getSmartsByParentDirId(dirUid);
		if ((dirs != null && !dirs.isEmpty()) 
				|| (reports != null && !reports.isEmpty())
				|| (smarts != null && !smarts.isEmpty())) {
			throw new RuntimeException("不能删除非空目录！");
		}
	}
	private void removeDirFromDB(String dirUid) {
		// 
	}
	private void removeDirFromCache(IBaseEntity entity) {
		String puid = ((IDirEntity)entity).getPuid();
		List<? extends IDirEntity> dirs = getInstance().getDirsByParentDirId(puid);
		if(dirs == null || dirs.size() < 1) return;
		ListIterator<? extends IDirEntity> listIterator = dirs.listIterator();
		while(listIterator.hasNext()){
			if(listIterator.next().getUid().equals(entity.getUid())){
				listIterator.remove();
			}
		}
	}
	@Override
	public IBaseEntity addEntity(IBaseEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public IBaseEntity updateEntity(IBaseEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	/**
//	 * 更新entity和其父目录id更新cache
//	 * @param parentId 要更新的entity的父目录id
//	 * @param entity 要更新的entity
//	 */
//	@SuppressWarnings("unchecked")
//	public static void updateEntityInCache(String parentDirUid ,IBaseEntity entity){
//		// 要更新的是目录
//		if(entity instanceof IDirEntity){
//		//	getInstance().getDirEntitisByParentDirId(parentDirUid)
//			List<BQAnalyticObjectDir> childDirs = (List<BQAnalyticObjectDir>) getChildDirEntitisById(parentId);
//			if(childDirs == null || childDirs.size() < 1) return;
//			ListIterator<BQAnalyticObjectDir> listIterator = childDirs.listIterator();
//			while(listIterator.hasNext()){
//				BQAnalyticObjectDir dir = listIterator.next();
//				if(dir.getUid().equals(entity.getUid())){
//					listIterator.set((BQAnalyticObjectDir) entity);
//				}
//			}
//		}
//		// 要更新的实体
//		else if(entity instanceof IObjEntity){
//			List<BQAnalyticObject> childObjs = (List<BQAnalyticObject>) getInstance().getChildObjEntitiesById(parentId);
//			if(childObjs == null || childObjs.size() < 1) return;
//			ListIterator<BQAnalyticObject> listIterator = childObjs.listIterator();
//			while(listIterator.hasNext()){
//				BQAnalyticObject obj = listIterator.next();
//				if(obj.getUid().equals(entity.getUid())){
//					listIterator.set((BQAnalyticObject) entity);
//				}
//			}
//		}
//	}

}