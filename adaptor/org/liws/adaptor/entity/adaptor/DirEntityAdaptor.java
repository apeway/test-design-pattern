package org.liws.adaptor.entity.adaptor;

import org.liws.adaptor.entity.itf.IDirEntity;

public abstract class DirEntityAdaptor extends BaseEntityAdaptor implements IDirEntity {

    private static final long serialVersionUID = 7887653539038767372L;

    @Override public abstract IDirEntity getTargetObj();

    public String getPuid() {
        return getTargetObj().getPuid();
    }
    public void setPuid(String puid) {
        getTargetObj().setPuid(puid);
    }
    public int getType() {
        return getTargetObj().getType();
    }
    public void setType(int type) {
        getTargetObj().setType(type);
    }
    
    @Override
    public DirEntityAdaptor clone() {
		try {
			DirEntityAdaptor copy = (DirEntityAdaptor) super.clone();
			return copy;
		} catch (Exception e)  {
			//AppDebug.debug("BaseBQEntityAdaptor clone error");
			//AppDebug.debug(e);
			throw new RuntimeException("BaseBQEntityAdaptor clone error", e);
		}
    }
}
