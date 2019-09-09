package org.liws.adaptor.entity;

import java.io.Serializable;

import org.liws.adaptor.entity.itf.IObjEntity;

/**
 * 分析对象实体
 * 报表与语义模型
 */
public class ObjEntity extends BaseEntity implements IObjEntity {
	
	private static final long serialVersionUID = 1469067769799895218L;

	private String dirUid ;
	private int type ;
	private String dsname; // dsname在type为数据集时才有值
	private Serializable define ;

	public String getDirUid() {
		return dirUid;
	}
	public void setDirUid(String dirUid) {
		this.dirUid = dirUid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getDsname() {
        return dsname;
    }
    public void setDsname(String dsname) {
        this.dsname = dsname;
    }
	public Serializable getDefine() {
		if (define == null) {
			// define = service.getDefine(this);
			//防止为空重复从数据库查询
			if (define == null)
				define = "$null$";
		}
		//如果define为该标记，则返回null。表示为空
		if("$null$".equals(define))
			return null;
		return define;
	}
	public void setDefine(Serializable define) {
		if (define == null)
			this.define = "$null$";
		else
			this.define = define;
	}

    public ObjEntity clone(){
		try {
			ObjEntity copy = (ObjEntity) super.clone();
			copy.dirUid = this.dirUid;
			//copy.define = (Serializable)DeepCopyUtilities.copy(this.define);
			copy.type = this.type;
			copy.dsname = this.dsname;
			return copy;
		} catch (Exception e)  {
			//AppDebug.debug("BaseBQEntity clone error");
			//AppDebug.debug(e);
			throw new RuntimeException("BaseBQEntity clone error", e);
		}
	}

    // hashCode、equals
}
