package org.liws.adaptor.entity.adaptor;

import java.io.Serializable;

import org.liws.adaptor.entity.itf.IObjEntity;

public abstract class ObjEntityAdaptor extends BaseEntityAdaptor implements IObjEntity {

	private static final long serialVersionUID = 626974186313819911L;
	
	@Override public abstract IObjEntity getTargetObj();
	
	public String getDirUid() {
		return getTargetObj().getDirUid();
	}
	public void setDirUid(String dirUid) {
		getTargetObj().setDirUid(dirUid);
	}
	public int getType() {
		return getTargetObj().getType();
	}
	public void setType(int type) {
		getTargetObj().setType(type);
	}
	public Serializable getDefine() {
		return getTargetObj().getDefine();
	}
	public void setDefine(Serializable define) {
		getTargetObj().setDefine(define);
	}
    public String getDsname() {
        return getTargetObj().getDsname();
    }
    public void setDsname(String dsname) {
        getTargetObj().setDsname(dsname);
    }
    
    @Override
    public ObjEntityAdaptor clone() {
    	try {
    		ObjEntityAdaptor copy = (ObjEntityAdaptor) super.clone();
			return copy;
		} catch (Exception e)  {
			//AppDebug.debug("BaseBQEntityAdaptor clone error");
			//AppDebug.debug(e);
			throw new RuntimeException("BaseBQEntityAdaptor clone error", e);
		}
    }
}
