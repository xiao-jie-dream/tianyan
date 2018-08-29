

package com.colourfulchina.tianyan.common.security.exception;

import org.springframework.http.HttpStatus;

public class MethodNotAllowed extends TianyanOAuth2Exception {

	public MethodNotAllowed(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "method_not_allowed";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.METHOD_NOT_ALLOWED.value();
	}

}
