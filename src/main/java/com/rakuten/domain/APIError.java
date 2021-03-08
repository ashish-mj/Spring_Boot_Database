package com.rakuten.domain;

import org.springframework.http.HttpStatus;

public class APIError {
private String errorMsg;
private HttpStatus status;
public String getErrorMsg() {
	return errorMsg;
}
public void setErrorMsg(String errorMsg) {
	this.errorMsg = errorMsg;
}
public HttpStatus getStatus() {
	return status;
}
public void setStatus(HttpStatus status) {
	this.status = status;
}


}
