package org.liws.adaptor.old.model;

import org.liws.adaptor.entity.ObjEntity;
import org.liws.adaptor.entity.adaptor.ObjEntityAdaptor;
import org.liws.adaptor.entity.itf.EntityConst;
import org.liws.adaptor.entity.itf.IObjEntity;

public class SmartDefVO extends ObjEntityAdaptor {

    private static final long serialVersionUID = -7937465726281742666L;
    private IObjEntity target = null;

    private transient DbType dbType = null;	
    
    public SmartDefVO() {
    	target = new ObjEntity();
        target.setType(EntityConst.ANA_TYPE_DATASET_SMART);
    }
    public SmartDefVO(IObjEntity target) {
        this.target = target;
    }
    
    public SmartModel getSmartmodel() {
        return (SmartModel) getDefine();
    }
    
    public void setSmartmodel(SmartModel model) {
        this.setDefine(model);
    }
    
    @Override
    public IObjEntity getTargetObj() {
        return target;
    }
    
    public void setTargetObj(IObjEntity target) {
    	// 按情况清空dbType缓存
        if (target == null) {
            this.dbType = null;
        } else if (this.target != null && !this.target.getDsname().equals(target.getDsname())) {
            this.dbType = null;
        }
        this.target = target;

    }

    /**
	 * 缓存注结果，不要每次都去查库
	 * @return
	 */
	public DbType getDBType() {
		if (dbType == null) {
			String dsname = getDsname();
			if (dsname == null || dsname.equals("")) {
				return DbType.UNKNOWN;
			}
			//dbType = BQDataSourceUtils.getInstance().getDbTypeByDsName(dsname);
		}
		return dbType;
	}


    @Override
    public void setDsname(String dsname) {
        String oldDsName = this.getDsname();
        super.setDsname(dsname);
        if (oldDsName != null && oldDsName.equals(dsname)) {
            this.dbType = null;
        }
    }

    @Override
    public SmartDefVO clone() {
        SmartDefVO clone = (SmartDefVO) super.clone();
        clone.target = (IObjEntity) this.target.clone();
        return clone;
    }

}
