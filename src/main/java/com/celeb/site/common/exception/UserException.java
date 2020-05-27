package com.celeb.site.common.exception;

public class UserException extends Exception{

	/**
	 * UserException
	 * CommonExceptionAdvice에서 @ExceptionHandler(UserException.class) 통하여 에러처리.
	 */
	public UserException(String errorMsg) {
		super(errorMsg);
	}
}