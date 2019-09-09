package org.liws.adaptor.entity.itf;

import java.sql.Timestamp;

public interface IBaseEntity extends IEntityAble {
	
	String getUid();

	void setUid(String uid);

	String getCode();

	void setCode(String code);

	String getName();

	void setName(String name);

	String getCreator();

	void setCreator(String creator);

	String getModifier();

	void setModifier(String modifier);

	Timestamp getCreateTime();

	void setCreateTime(Timestamp createTime);

	Timestamp getModifiedTime();

	void setModifiedTime(Timestamp modifiedTime);

	boolean isDeleted();

	void setDeleted(boolean deleted);

	String getNote();

	void setNote(String note);
}