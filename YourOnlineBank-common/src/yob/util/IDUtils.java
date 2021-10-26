package yob.util;

import java.util.UUID;

public class IDUtils {
	public static String generateUserUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	public static String generateAccountNo() {
		return String.valueOf(System.currentTimeMillis());
	}
	public static String generateTransactionNo() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}