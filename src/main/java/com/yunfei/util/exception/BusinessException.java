package com.yunfei.util.exception;


import com.yunfei.util.LogUtil;

/**
 * 
 * @ClassName: BusinessException
 * @Description: 业务异常类
 * @date 2015年4月11日 下午1:16:59
 *
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String errNo;//异常编码

	public BusinessException(String msg) {
		super(msg);
		LogUtil.error(msg);
		this.errNo = "-1";
	}
	
	public BusinessException(String msg,String errNo) {
		super(msg);
		LogUtil.error(msg);
		this.errNo = errNo;
	}

	public void setErrNo(String errNo) {
		this.errNo = errNo;
	}

	public String getErrNo() {
		return errNo;
	}

	
	
}
