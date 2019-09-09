package org.liws.adaptor.old.model;

import org.liws.adaptor.entity.DirEntity;
import org.liws.adaptor.entity.adaptor.DirEntityAdaptor;
import org.liws.adaptor.entity.itf.IDirEntity;

public class SmartDirVO extends DirEntityAdaptor{
	private static final long serialVersionUID = -148117304620048162L;
	
	private IDirEntity target = null;
	
	public SmartDirVO(){
		target = new DirEntity();
	}
	public SmartDirVO(IDirEntity target){
		this.target = target;
	}

	@Override
	public IDirEntity getTargetObj() {
		return target;
	}

	@Override
	public SmartDirVO clone() {
		SmartDirVO clone = (SmartDirVO)super.clone();
		clone.target = (IDirEntity) this.target.clone();
		return clone;
	}
	
}