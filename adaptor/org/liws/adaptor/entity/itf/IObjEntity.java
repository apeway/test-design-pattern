package org.liws.adaptor.entity.itf;

import java.io.Serializable;

public interface IObjEntity extends IBaseEntity {

	String getDirUid();

	void setDirUid(String dirUid);

	int getType();

	void setType(int type);

	Serializable getDefine();

	void setDefine(Serializable define);

	String getDsname();

	void setDsname(String dsname);

}
