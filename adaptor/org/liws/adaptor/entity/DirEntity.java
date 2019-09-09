package org.liws.adaptor.entity;

import org.liws.adaptor.entity.itf.EntityConst;
import org.liws.adaptor.entity.itf.IDirEntity;

/**
 * 目录对象实体
 */
public class DirEntity extends BaseEntity implements IDirEntity {
	private static final long serialVersionUID = 578050077080052255L;
	
	private int type = EntityConst.DIR_TYPE_RESOURCE;
	private String puid ;

	public String getPuid() {
		return puid;
	}
	public void setPuid(String puid) {
		this.puid = puid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	@Override
	public DirEntity clone(){
		try {
			DirEntity copy = (DirEntity) super.clone();
			copy.puid = this.puid;
			copy.type = this.type;
			return copy;
		} catch (Exception e)  {
			//AppDebug.debug("BQAnalyticObjectDir clone error");
			//AppDebug.debug(e);
			throw new RuntimeException("BQAnalyticObjectDir clone error", e);
		}
	}
	
	// hashCode、equals
}
