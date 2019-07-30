package com.qing_guang.RemoteControl.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * ͨѶ���ܹ�����
 * @author Qing_Guang
 *
 */
public final class CommunicateEncryptUtil {
	
	//�����������⿪��
	private CommunicateEncryptUtil() {}

	/**
	 * ����½�һ��RSA��˽Կ��
	 * @param keySize ��Կ��С
	 * @return RSA��˽Կ��
	 */
	public static KeyPair buildRSAKeyPair(int keySize) {
		
		KeyPairGenerator keyPairGenerator = null;
		try {
			keyPairGenerator = KeyPairGenerator.getInstance("rsa");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		keyPairGenerator.initialize(keySize);
		return keyPairGenerator.genKeyPair();
		
	}
	
	/**
	 * ����½�һ��AES��Կ
	 * @return AES��Կ
	 * @see java.util.UUID#randomUUID()
	 */
	public static String randomAESKey() {
		String uid = UUID.randomUUID().toString();
		return uid.substring(uid.length() - 16,uid.length());
	}
	
	/**
	 * ͨ��byte�����ʼ��һ��RSA��Կ
	 * @param buffer ��Կbyte����
	 * @return RSA��Կ
	 * @see java.security.Key#getEncoded()
	 */
	public static PublicKey loadPublicKey(byte[] buffer) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("rsa");
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
            return keyFactory.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException e) {
        	return null;
        } catch (InvalidKeySpecException e) {
			return null;
		}
    }

	/**
	 * ͨ��byte�����ʼ��һ��RSA˽Կ
	 * @param buffer ˽Կbyte����
	 * @return RSA˽Կ
	 * @see java.security.Key#getEncoded()
	 */
    public static PrivateKey loadPrivateKey(byte[] buffer) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("rsa");
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
            return keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException e) {
            return null;
        } catch (InvalidKeySpecException e) {
            return null;
        }
    }
	
    /**
     * ��RSA�㷨����һ����Ϣ
     * @param publicKey RSA��Կ
     * @param message ��Ϣ
     * @param charset ����ʹ�õ��ַ���
     * @return ���ܺ����Ϣ
     * @throws UnsupportedEncodingException {@link java.lang.String#getBytes(String)}
     */
	public static byte[] encrypt_RSA(PublicKey publicKey, String message, String charset) throws UnsupportedEncodingException{
		
		Cipher cipher = null;
		byte[] encrypted = null;
		
		try {
			cipher = Cipher.getInstance("rsa");
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			encrypted = cipher.doFinal(message.getBytes(charset));
		}catch(UnsupportedEncodingException e) {
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return encrypted;
		
	}
	
	/**
     * ��RSA�㷨����һ����Ϣ
     * @param publicKey RSA��Կ
     * @param message ��Ϣ
     * @return ���ܺ����Ϣ
     * @see #encrypt_RSA(PublicKey,String,String)
     */
	public static byte[] encrypt_RSA(PublicKey publicKey, String message) {
		byte[] encrypt = null;
		try {
			encrypt = encrypt_RSA(publicKey,message,Charset.defaultCharset().displayName());
		}catch(UnsupportedEncodingException e){}
		return encrypt;
	}
	
	/**
     * ��RSA�㷨����һ����Ϣ
     * @param publicKey RSA˽Կ
     * @param message ��Ϣ
     * @param charset ����ʹ�õ��ַ���
     * @return ���ܺ����Ϣ
     * @throws UnsupportedEncodingException {@link java.lang.String#String(byte[],String)}
     */
	public static String decrypt_RSA(PrivateKey privateKey, byte[] message, String charset) throws UnsupportedEncodingException{
		
		Cipher cipher = null;
		String decrypted = null;
		
		try {
			cipher = Cipher.getInstance("rsa");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			decrypted = new String(cipher.doFinal(message),charset);
		}catch(UnsupportedEncodingException e) {
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return decrypted;
		
	}
	
	/**
     * ��RSA�㷨����һ����Ϣ
     * @param publicKey RSA˽Կ
     * @param message ��Ϣ
     * @return ���ܺ����Ϣ
     * @see #decrypt_RSA(byte[],String,String)
     */
	public static String decrypt_RSA(PrivateKey privateKey, byte[] message) {
		String decrypt = null;
		try {
			decrypt_RSA(privateKey,message,Charset.defaultCharset().displayName());
		}catch(UnsupportedEncodingException e) {}
		return decrypt;
	}
	
	/**
     * ��AES�㷨����һ����Ϣ
     * @param data ��Ϣ
     * @param key AES��Կ
     * @param charset ����ʹ�õ��ַ���
     * @return ���ܺ����Ϣ
     * @throws UnsupportedEncodingException {@link java.lang.String#getBytes(String)}
     */
	public static byte[] encrypt_AES(String data,String key,String charset) throws UnsupportedEncodingException{
		try {
			byte[] content = data.getBytes(charset);
			KeyGenerator kg = KeyGenerator.getInstance("aes");
			SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
			sr.setSeed(key.getBytes(charset));
			kg.init(128,sr);
			SecretKey sk = kg.generateKey();
			byte[] encode = sk.getEncoded();
			SecretKeySpec sks = new SecretKeySpec(encode, "aes");
			Cipher cipher = Cipher.getInstance("aes");
			cipher.init(Cipher.ENCRYPT_MODE, sks);
			return cipher.doFinal(content);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
     * ��AES�㷨����һ����Ϣ
     * @param data ��Ϣ
     * @param key AES��Կ
     * @return ���ܺ����Ϣ
     * @see #encrypt_AES(byte[],String,String)
     */
	public static byte[] encrypt_AES(String data,String key) {
		byte[] encrypt = null;
		try {
			encrypt = encrypt_AES(data,key,Charset.defaultCharset().displayName());
		} catch (UnsupportedEncodingException e) {}
		return encrypt;
	}
	
	/**
     * ��AES�㷨����һ����Ϣ
     * @param data ��Ϣ
     * @param key AES��Կ
     * @param charset ����ʹ�õ��ַ���
     * @return ���ܺ����Ϣ
     * @throws UnsupportedEncodingException {@link java.lang.String#String(byte[],String)}
     */
	public static String decrypt_AES(byte[] data,String key,String charset) throws UnsupportedEncodingException{
		try {
			KeyGenerator kg = KeyGenerator.getInstance("aes");
			SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
			sr.setSeed(key.getBytes(charset));
			kg.init(128,sr);
			SecretKey sk = kg.generateKey();
			byte[] encode = sk.getEncoded();
			SecretKeySpec sks = new SecretKeySpec(encode, "aes");
			Cipher cipher = Cipher.getInstance("aes");
			cipher.init(Cipher.DECRYPT_MODE, sks);
			return new String(cipher.doFinal(data),charset);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
     * ��AES�㷨����һ����Ϣ
     * @param data ��Ϣ
     * @param key AES��Կ
     * @return ���ܺ����Ϣ
     * @see #decrypt_AES(byte[],String,String)
     */
	public static String decrypt_AES(byte[] data,String key) {
		String decrypt = null;
		try {
			decrypt = decrypt_AES(data,key,Charset.defaultCharset().displayName());
		} catch (UnsupportedEncodingException e) {}
		return decrypt;
	}
	
	/**
	 * ��һ��byte����ת����16λ�ַ���
	 * @param buf byte����
	 * @return ת�����16λ�ַ���
	 */
	public static String parseByte2HexStr(byte buf[]) {  
		StringBuffer sb = new StringBuffer();
	    for(int i = 0; i < buf.length; i++) {
	    	String hex = Integer.toHexString(buf[i] & 0xFF);
	    	if (hex.length() == 1) {
	    		hex = '0' + hex;
	    	}
	    	sb.append(hex.toUpperCase());
	    }
	    return sb.toString();
	}
	
	/**
	 * ��һ��16λ�ַ���ת����byte����
	 * @param hexStr 16λ�ַ���
	 * @return ת�����byte����
	 */
	public static byte[] parseHaxStr2Byte(String hexStr) {
		if(hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length()/2];
		for(int i = 0;i< hexStr.length()/2; i++) {
			int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
			int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}
	
	/**
	 * ��һ��byte�������base64����
	 * @param message byte����
	 * @return base64�������ַ���
	 */
	public static String base64En(byte[] message) {
		return new BASE64Encoder().encode(message);
	}
	
	/**
	 * ��һ����base64�������ַ�����ԭ��byte����
	 * @param message base64�������ַ���
	 * @return ��ԭ���byte����
	 */
	public static byte[] base64De(String message) {
		
		byte[] de = null;
		
		try {
			de = new BASE64Decoder().decodeBuffer(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return de;
		
	}
	
	/**
	 * ��һ���ַ�������md5����
	 * @param str Ҫ���ܵ��ַ���
	 * @return md5���ܺ���ַ���
	 */
	public static String getMD5String(String str) {
	    try {
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        md.update(str.getBytes());
	        return new BigInteger(1, md.digest()).toString(16);
	    } catch (Exception e) {
			e.printStackTrace();
			return null;
	    }
	}
	
}
