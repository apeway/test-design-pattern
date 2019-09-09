package org.liws.adaptor.old.model;

import org.liws.adaptor.entity.DirEntity;
import org.liws.adaptor.entity.adaptor.DirEntityAdaptor;
import org.liws.adaptor.entity.itf.IDirEntity;

public class FreeReportDirVO extends DirEntityAdaptor{
	private static final long serialVersionUID = -3716380181749739138L;
	
	private IDirEntity target = null;
	
	public FreeReportDirVO(){
		target = new DirEntity();
	}
	
	public FreeReportDirVO(IDirEntity target){
		this.target = target;
	}

	@Override
	public IDirEntity getTargetObj() {
		return target;
	}

	@Override
	public FreeReportDirVO clone() {
		FreeReportDirVO clone = (FreeReportDirVO)super.clone();
		clone.target = (IDirEntity) this.target.clone();
		return clone;
	}
	
}