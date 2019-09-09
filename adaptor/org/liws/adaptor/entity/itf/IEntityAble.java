package org.liws.adaptor.entity.itf;

import java.io.Serializable;

/**
 * 可存库对象
 */
public interface IEntityAble extends Serializable, Cloneable {

	Object clone();

}