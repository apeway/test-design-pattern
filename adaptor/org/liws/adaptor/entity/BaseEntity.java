package org.liws.adaptor.entity;

import java.sql.Timestamp;

import org.liws.adaptor.entity.itf.IBaseEntity;

/**
 * 实体抽象类 <br>
 * 统一规范实体的字段摘要信息
 */
public class BaseEntity implements IBaseEntity {
	private static final long serialVersionUID = 3910245493343893470L;
	
	private String uid = null;
	private String code = null;
	private String name = null;
	private String creator = null;
	private String modifier = null;
	private Timestamp createTime = null;
	private Timestamp modifiedTime = null;
	private boolean deleted = false;
	private String note = null; 
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	@Override
	public BaseEntity clone(){
		try {
			BaseEntity copy = (BaseEntity) super.clone();
			copy.uid = this.uid;
			copy.code = this.code;
			copy.name = this.name;
			copy.creator = this.creator;
			copy.modifier = this.modifier;
			//copy.createTime = (Timestamp) DeepCopyUtilities.copy(this.createTime);
			//copy.modifiedTime = (Timestamp) DeepCopyUtilities.copy(this.modifiedTime);
			copy.deleted = this.deleted;
			copy.note = this.note;
			return copy;
		} catch (Exception e)  {
			//AppDebug.debug("BaseBQEntity clone error");
			//AppDebug.debug(e);
			throw new RuntimeException("BaseBQEntity clone error", e);
		}
	}
	
	// hashCode、equals
	
}
