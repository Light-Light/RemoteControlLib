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
 * 通讯加密工具类
 * @author Qing_Guang
 *
 */
public final class CommunicateEncryptUtil {
	
	//构造器不对外开放
	private CommunicateEncryptUtil() {}

	/**
	 * 随机新建一个RSA公私钥对
	 * @param keySize 密钥大小
	 * @return RSA公私钥对
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
	 * 随机新建一个AES密钥
	 * @return AES密钥
	 * @see java.util.UUID#randomUUID()
	 */
	public static String randomAESKey() {
		String uid = UUID.randomUUID().toString();
		return uid.substring(uid.length() - 16,uid.length());
	}
	
	/**
	 * 通过byte数组初始化一个RSA公钥
	 * @param buffer 公钥byte数组
	 * @return RSA公钥
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
	 * 通过byte数组初始化一个RSA私钥
	 * @param buffer 私钥byte数组
	 * @return RSA私钥
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
     * 用RSA算法加密一串信息
     * @param publicKey RSA公钥
     * @param message 信息
     * @param charset 加密使用的字符集
     * @return 加密后的信息
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
     * 用RSA算法加密一串信息
     * @param publicKey RSA公钥
     * @param message 信息
     * @return 加密后的信息
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
     * 用RSA算法解密一串信息
     * @param publicKey RSA私钥
     * @param message 信息
     * @param charset 解密使用的字符集
     * @return 解密后的信息
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
     * 用RSA算法解密一串信息
     * @param publicKey RSA私钥
     * @param message 信息
     * @return 解密后的信息
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
     * 用AES算法加密一串信息
     * @param data 信息
     * @param key AES密钥
     * @param charset 加密使用的字符集
     * @return 加密后的信息
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
     * 用AES算法加密一串信息
     * @param data 信息
     * @param key AES密钥
     * @return 加密后的信息
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
     * 用AES算法解密一串信息
     * @param data 信息
     * @param key AES密钥
     * @param charset 解密使用的字符集
     * @return 解密后的信息
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
     * 用AES算法解密一串信息
     * @param data 信息
     * @param key AES密钥
     * @return 解密后的信息
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
	 * 将一个byte数组转换成16位字符串
	 * @param buf byte数组
	 * @return 转换后的16位字符串
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
	 * 将一个16位字符串转换成byte数组
	 * @param hexStr 16位字符串
	 * @return 转换后的byte数组
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
	 * 将一个byte数组进行base64编码
	 * @param message byte数组
	 * @return base64编码后的字符串
	 */
	public static String base64En(byte[] message) {
		return new BASE64Encoder().encode(message);
	}
	
	/**
	 * 将一个被base64编码后的字符串还原成byte数组
	 * @param message base64编码后的字符串
	 * @return 还原后的byte数组
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
	 * 将一个字符串进行md5加密
	 * @param str 要加密的字符串
	 * @return md5加密后的字符串
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
