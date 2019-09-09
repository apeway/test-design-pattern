package org.liws.adaptor.old.model;

import org.liws.adaptor.entity.ObjEntity;
import org.liws.adaptor.entity.adaptor.ObjEntityAdaptor;
import org.liws.adaptor.entity.itf.EntityConst;
import org.liws.adaptor.entity.itf.IObjEntity;

public class FreeReportVO extends ObjEntityAdaptor {
	private static final long serialVersionUID = -2786079986565987790L;

	private IObjEntity target = null;

	public FreeReportVO() {
		target = new ObjEntity();
		target.setType(EntityConst.ANA_TYPE_REPORT);
	}
	public FreeReportVO(IObjEntity target) {
		this.target = target;
	}

	@Override
	public IObjEntity getTargetObj() {
		return target;
	}

	public CellsModel getCellsModel() {
		return (CellsModel) getDefine();
	}

	public void setCellsModel(CellsModel cellsModel) {
		setDefine(cellsModel);
	}

	@Override
	public FreeReportVO clone() {
		FreeReportVO clone = (FreeReportVO) super.clone();
		clone.target = (IObjEntity) this.target.clone();
		return clone;
	}

	// @Override
	// public int hashCode() {
	// final int prime = 31;
	// int result = 1;
	// result = prime * result + ((target == null) ? 0 : target.hashCode());
	// return result;
	// }
	//
	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj) return true;
	// if (obj == null) return false;
	// if (getClass() != obj.getClass()) return false;
	// FreeReportVO other = (FreeReportVO) obj;
	// if (target == null) {
	// if (other.target != null) return false;
	// } else if (!target.equals(other.target)) return false;
	// return true;
	// }
}
