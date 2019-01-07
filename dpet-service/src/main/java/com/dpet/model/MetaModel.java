package com.dpet.model;

import com.auth0.jwt.internal.org.apache.commons.lang3.builder.ToStringBuilder;
import com.auth0.jwt.internal.org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 基类
 * @author lee
 *
 */
public abstract class MetaModel {
	
	
	/**
	 * toString
	 * @return
	 */
	public String ToString(){
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
