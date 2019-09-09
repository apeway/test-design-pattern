package org.liws.adaptor.entity.adaptor;

import java.sql.Timestamp;

import org.liws.adaptor.entity.itf.IBaseEntity;

public abstract class BaseEntityAdaptor implements IBaseEntity {
	private static final long serialVersionUID = 4927784639372532241L;
	
	/**
	 * 获取适配对象
	 * @return
	 */
	public abstract IBaseEntity getTargetObj();

	public String getUid() {
		return getTargetObj().getUid();
	}
	public void setUid(String uid) {
		getTargetObj().setUid(uid);
	}
	public String getCode() {
		return getTargetObj().getCode();
	}
	public void setCode(String code) {
		getTargetObj().setCode(code);
	}
	public String getName() {
		return getTargetObj().getName();
	}
	public void setName(String name) {
		getTargetObj().setName(name);
	}
	public String getCreator() {
		return getTargetObj().getCreator();
	}
	public void setCreator(String creator) {
		getTargetObj().setCreator(creator);
	}
	public String getModifier() {
		return getTargetObj().getModifier();
	}
	public void setModifier(String modifier) {
		getTargetObj().setModifier(modifier);
	}
	public Timestamp getCreateTime() {
		return getTargetObj().getCreateTime();
	}
	public void setCreateTime(Timestamp createTime) {
		getTargetObj().setCreateTime(createTime);
	}
	public Timestamp getModifiedTime() {
		return getTargetObj().getModifiedTime();
	}
	public void setModifiedTime(Timestamp modifiedTime) {
		getTargetObj().setModifiedTime(modifiedTime);
	}
	public boolean isDeleted() {
		return getTargetObj().isDeleted();
	}
	public void setDeleted(boolean deleted) {
		getTargetObj().setDeleted(deleted);
	}
	public String getNote() {
		return getTargetObj().getNote();
	}
	public void setNote(String note) {
		getTargetObj().setNote(note);
	}

	
	@Override
	public BaseEntityAdaptor clone(){
		try {
			BaseEntityAdaptor copy = (BaseEntityAdaptor) super.clone();
			return copy;
		} catch (Exception e)  {
			//AppDebug.debug("BaseBQEntityAdaptor clone error");
			//AppDebug.debug(e);
			throw new RuntimeException("BaseBQEntityAdaptor clone error", e);
		}
	}
	
}
