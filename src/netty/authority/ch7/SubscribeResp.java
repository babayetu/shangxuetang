package netty.authority.ch7;

import java.io.Serializable;

public class SubscribeResp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 222L;
	
	private int subReqId;
	
	private int errorCode;
	
	private String desc;

	public int getSubReqId() {
		return subReqId;
	}

	public void setSubReqId(int subReqId) {
		this.subReqId = subReqId;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SubscribeResp [subReqId=" + subReqId + ", errorCode=" + errorCode + ", desc=" + desc + "]";
	}
	
	
}
