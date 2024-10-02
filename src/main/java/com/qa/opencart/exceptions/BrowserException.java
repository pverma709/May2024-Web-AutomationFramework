package com.qa.opencart.exceptions;

import net.bytebuddy.implementation.bind.annotation.Super;

public class BrowserException extends RuntimeException {
	
	
	public BrowserException(String msg) {
		super(msg);
	}

}
