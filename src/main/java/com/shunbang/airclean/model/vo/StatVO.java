package com.shunbang.airclean.model.vo;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * @author dxy
 * @date 20200804
 * @description VO用于封装数据库查出的数据
 */
public class StatVO {

	private String val;
	private Timestamp smplTm;


	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public Timestamp getSmplTm() {
		return smplTm;
	}

	public void setSmplTm(Timestamp smplTm) {
		this.smplTm = smplTm;
	}
}
