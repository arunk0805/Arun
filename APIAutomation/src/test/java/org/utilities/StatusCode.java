package org.utilities;

import java.util.Set;

/**
 * 
 * @author Arunkumar.K
 * @Date 18/04/2023
 * @see Set the Enum for status code
 *
 */
public enum StatusCode {
	OK(200), CREATED(201), NO_CONTENT(204), BAD_REQUEST(400), UNAUTHORIZED(401), FORBIDDEN(403), NOT_FOUND(404),
	INTERNAL_SERVER_ERROR(500);

	private final int code;

	StatusCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;

	}

}
