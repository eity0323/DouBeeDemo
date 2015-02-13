package com.sd.core.utils.encrypt.ase;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {

	private static String defaultPwd = "aes_key";
	private static String IV1 = "1234567812345678";

	public static byte[] encrypt(SecretKey key, byte[] plaintext)
			throws Exception {
		// In practice you should specify your SecureRandom implementation.
		SecureRandom rnd = new SecureRandom();

		// Generate random IV of 128-bit (AES block size)
		byte[] IV = IV1.getBytes("UTF-8");
		// rnd.nextBytes(IV);
		IvParameterSpec IVSpec = new IvParameterSpec(IV);

		// Create the cipher object to perform AES operations.
		// Specify Advanced Encryption Standard - Cipher Feedback Mode - No
		// Padding
		Cipher AESCipher = Cipher.getInstance("AES/CFB/NoPadding");

		// Initialize the Cipher with the key and initialization vector.
		AESCipher.init(Cipher.ENCRYPT_MODE, key, IVSpec);

		// Encrypts the plaintext data
		byte[] ciphertext = AESCipher.doFinal(plaintext);

		/*
		 * The IV must now be transferred with the ciphertext somehow. The
		 * easiest way to accomplish this would be to prepend the IV to the
		 * ciphertext message.
		 */

		// Allocate new array to hold ciphertext + IV
		byte[] output = new byte[ciphertext.length + (128 / 8)];

		// Copy the respective parts into the array.
		System.arraycopy(IV, 0, output, 0, IV.length);
		System.arraycopy(ciphertext, 0, output, IV.length, ciphertext.length);

		return output;
	}

	public static String encrypt(String data1) throws Exception {
		try {
			String data = data1;
			String key = "1234567812345678";
			String iv = "1234567812345678";

			Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
			int blockSize = cipher.getBlockSize();

			byte[] dataBytes = data.getBytes();
			int plaintextLength = dataBytes.length;
			if (plaintextLength % blockSize != 0) {
				plaintextLength = plaintextLength
						+ (blockSize - (plaintextLength % blockSize));
			}

			byte[] plaintext = new byte[plaintextLength];
			System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);

			SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
			IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

			cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
			byte[] encrypted = cipher.doFinal(plaintext);

			return Base64.encode(encrypted);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static byte[] decrypt(SecretKey key, byte[] IV, byte[] ciphertext)
			throws Exception {
		// Create the cipher object to perform AES operations.
		// Specify Advanced Encryption Standard - Cipher Feedback Mode - No
		// Padding
		Cipher AESCipher = Cipher.getInstance("AES/CFB/NoPadding");

		// Create the IvParameterSpec object from the raw IV
		IvParameterSpec IVSpec = new IvParameterSpec(IV);

		// Initialize the Cipher with the key and initialization vector.
		AESCipher.init(Cipher.DECRYPT_MODE, key, IVSpec);

		// Decrypts the ciphertext data
		byte[] plaintext = AESCipher.doFinal(ciphertext);

		return plaintext;
	}

	public static String decrypt(String data1) throws Exception {
		try {
			String data = data1;
			String key = "1234567812345678";
			String iv = "1234567812345678";

			byte[] encrypted1 = Base64.decode(data);

			Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
			SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
			IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

			cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

			byte[] original = cipher.doFinal(encrypted1);
			String originalString = new String(original);
			return originalString;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) throws Exception {
		// String sPlaintext = "�л����񹲺͹�"; // String plaintext
		// byte[] rPlaintext = sPlaintext.getBytes(Charset.forName("UTF-8")); //
		// Raw
		// // byte
		// // array
		// // plaintext
		//
		// // We first need to generate a key of 128-bit
		// SecretKey key = generateAESKey(defaultPwd);
		//
		// // Encrypt the plaintext
		// byte[] output = encrypt(key, rPlaintext);
		//
		// // ----------------- //
		//
		// // Extract the IV from the encryption output
		// byte[] IV = new byte[128 / 8];
		// byte[] ciphertext = new byte[output.length - (128 / 8)];
		//
		// System.arraycopy(output, 0, IV, 0, IV.length);
		// System.arraycopy(output, IV.length, ciphertext, 0,
		// ciphertext.length);
		// String encryptedMessage = Base64.encode(rPlaintext);
		// byte[] encryptedBytes = Base64.decode(encryptedMessage);
		// // Decrypt the ciphertext
		// byte[] dPlaintext = decrypt(key, IV, ciphertext);
		// String decryptedMessage = new String(dPlaintext,
		// Charset.forName("UTF-8"));
		//
		// // Print stuff out
		// System.out.println("Original message: " + sPlaintext);
		// System.out.println("Original message bytes: "
		// + Arrays.toString(rPlaintext));
		// System.out.println("Encryption Output bytes: "
		// + Arrays.toString(output));
		// System.out.println("Encryption Output Strings: " + encryptedMessage);
		// System.out.println("Encryption Output ��Ҫ��ɫ: "
		// + Arrays.toString(encryptedBytes));
		// System.out.println("Decrypted message bytes: "
		// + Arrays.toString(dPlaintext));
		// System.out.println("Decrypted message: " + decryptedMessage);
		String data = encrypt("中国深圳");
		System.out.println(data);
		String bb = decrypt(data);
		System.out.println("bbb==" + bb);

		System.out.println(decrypt(data));
	}
}

// public class AES {
//
// public static SecretKey generateAESKey(int bits) throws
// NoSuchAlgorithmException{
// //This method is provided as to securely generate a AES key of the given
// length.
//
// //In practice you can specify your own SecureRandom instance.
// KeyGenerator kgen = KeyGenerator.getInstance("AES");
// kgen.init(bits);
// return kgen.generateKey();
// }
//
// public static byte[] encrypt(SecretKey key, byte[] plaintext) throws
// Exception{
// //In practice you should specify your SecureRandom implementation.
// SecureRandom rnd = new SecureRandom();
//
// //Generate random IV of 128-bit (AES block size)
// byte[] IV = new byte[128 / 8];
// rnd.nextBytes(IV);
// IvParameterSpec IVSpec = new IvParameterSpec(IV);
//
// //Create the cipher object to perform AES operations.
// //Specify Advanced Encryption Standard - Cipher Feedback Mode - No Padding
// Cipher AESCipher = Cipher.getInstance("AES/CFB/NoPadding");
//
// //Initialize the Cipher with the key and initialization vector.
// AESCipher.init(Cipher.ENCRYPT_MODE, key, IVSpec);
//
// //Encrypts the plaintext data
// byte[] ciphertext = AESCipher.doFinal(plaintext);
//
// /*
// * The IV must now be transferred with the ciphertext somehow. The easiest
// * way to accomplish this would be to prepend the IV to the ciphertext
// * message.
// */
//
// //Allocate new array to hold ciphertext + IV
// byte[] output = new byte[ciphertext.length + (128 / 8)];
//
// //Copy the respective parts into the array.
// System.arraycopy(IV, 0, output, 0, IV.length);
// System.arraycopy(ciphertext, 0, output, IV.length, ciphertext.length);
//
// return output;
// }
//
// public static byte[] decrypt(SecretKey key, byte[] IV, byte[] ciphertext)
// throws Exception{
// //Create the cipher object to perform AES operations.
// //Specify Advanced Encryption Standard - Cipher Feedback Mode - No Padding
// Cipher AESCipher = Cipher.getInstance("AES/CFB/NoPadding");
//
// //Create the IvParameterSpec object from the raw IV
// IvParameterSpec IVSpec = new IvParameterSpec(IV);
//
// //Initialize the Cipher with the key and initialization vector.
// AESCipher.init(Cipher.DECRYPT_MODE, key, IVSpec);
//
// //Decrypts the ciphertext data
// byte[] plaintext = AESCipher.doFinal(ciphertext);
//
// return plaintext;
// }
//
// public static void main(String[] args) throws Exception{
// //Demo the program
//
// String sPlaintext = "rainbows"; //String plaintext
// byte[] rPlaintext = sPlaintext.getBytes(Charset.forName("UTF-8")); //Raw byte
// array plaintext
//
// //We first need to generate a key of 128-bit
// SecretKey key = generateAESKey(128);
//
// //Encrypt the plaintext
// byte[] output = encrypt(key, rPlaintext);
//
// // ----------------- //
//
// //Extract the IV from the encryption output
// byte[] IV = new byte[128 / 8];
// byte[] ciphertext = new byte[output.length - (128 / 8)];
//
// System.arraycopy(output, 0, IV, 0, IV.length);
// System.arraycopy(output, IV.length, ciphertext, 0, ciphertext.length);
//
// //Decrypt the ciphertext
// byte[] dPlaintext = decrypt(key, IV, ciphertext);
//
// String decryptedMessage = new String(dPlaintext, Charset.forName("UTF-8"));
//
// //Print stuff out
// System.out.println("Original message: " + sPlaintext);
// System.out.println("Original message bytes: " + Arrays.toString(rPlaintext));
// System.out.println("Encryption Output bytes: " + Arrays.toString(output));
// System.out.println("Decrypted message bytes: " +
// Arrays.toString(dPlaintext));
// System.out.println("Decrypted message: " + decryptedMessage);
// }
// }