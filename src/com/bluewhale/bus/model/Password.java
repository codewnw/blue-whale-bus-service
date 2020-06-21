package com.bluewhale.bus.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.ArrayUtils;

import com.bluewhale.bus.exception.InvalidPasswordException;

public class Password {

	private String securedPassword;

	// TODO: there should be a better way
	// (https://crackstation.net/hashing-security.htm)
	private static final String SALT = "QxLUF1bgIAdeQX";

	public Password(String password) {
		byte[] passwordBytes = password.getBytes();

		isValidPassword(passwordBytes);

		byte[] saltedPassword = ArrayUtils.addAll(SALT.getBytes(), passwordBytes);
		this.securedPassword = generateHash(saltedPassword);
	}

	private void isValidPassword(byte[] password) {
		isNull(password);
		isBlank(password);
		isValidLength(password);
	}

	private void isNull(byte[] password) {
		if (password == null) {
			throw new InvalidPasswordException("Password cannot be null");
		}
	}

	private void isBlank(byte[] password) {
		if (password.length == 0) {
			throw new InvalidPasswordException("Password cannot be blank");
		}
	}

	private void isValidLength(byte[] password) {
		if (password.length <= 2) {
			throw new InvalidPasswordException("Password must contain at least 3 charactes");
		}
	}

	private String generateHash(byte[] password) {
		StringBuilder hash = new StringBuilder();

		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] hashedBytes = sha.digest(password);
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
			for (int idx = 0; idx < hashedBytes.length; ++idx) {
				byte b = hashedBytes[idx];
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return hash.toString();
	}

	public String getSecuredPassword() {
		return securedPassword;
	}
}
