package com.qing_guang.RemoteControl.util;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;

/**
 * JSON�ı�������
 * @author A
 *
 */
public final class JsonUtil {

	private JsonUtil() {}
	
	private static final JsonParser PARSER = new JsonParser();
	
	/**
	 * ��һ��byte������ӵ�������JsonArray��
	 * @param array byte����
	 * @param jarray ������JsonArray
	 * @return ��Ӻ��JsonArray
	 */
	public static JsonArray toJsonArray(byte[] array,JsonArray jarray) {
		
		for(byte v : array) {
			jarray.add(new JsonPrimitive(v));
		}
		
		return jarray;
		
	}
	
	/**
	 * ��һ���ַ���������ӵ�������JsonArray��
	 * @param array �ַ�������
	 * @param jarray ������JsonArray
	 * @return ��Ӻ��JsonArray
	 */
	public static JsonArray toJsonArray(String[] array,JsonArray jarray) {
		
		for(String str : array) {
			jarray.add(new JsonPrimitive(str));
		}
		
		return jarray;
		
	}
	
	/**
	 * ��һ��JsonArray�е��������õ�������byte������
	 * @param jarray JsonArray
	 * @param array ������byte����
	 * @return ���ú��byte����
	 */
	public static byte[] toArray(JsonArray jarray,byte[] array) {
		
		for(int i = 0;i < jarray.size();i++) {
			array[i] = jarray.get(i).getAsByte();
		}
		
		return array;
		
	}
	
	/**
	 * ��һ��JsonArray�е��������õ��������ַ���������
	 * @param jarray JsonArray
	 * @param array �������ַ�������
	 * @return ���ú���ַ�������
	 */
	public static String[] toArray(JsonArray jarray,String[] array) {
		
		for(int i = 0;i < jarray.size();i++) {
			array[i] = jarray.get(i).getAsString();
		}
		
		return array;
		
	}
	
	/**
	 * ��һ����ֵ�����Ͷ�Ϊ�ַ�����Map�����е�������ӵ�ָ����JsonObject��
	 * @param map Map����
	 * @param json ָ����JsonObject
	 * @return ��Ӻ��JsonObject
	 */
	public static JsonObject toJsonObject(Map<String,String> map,JsonObject json) {
		
		for(String key : map.keySet()) {
			json.addProperty(key, map.get(key));
		}
		
		return json;
		
	}
	
	/**
	 * ��һ���ַ���ת��JsonElement
	 * @param <T> JsonElement������,ת��֮���ǿ��ת�ͳɴ����Ͳ�����
	 * @param text Ҫת�����ַ���
	 * @return ת����ǿ��ת�͵�JsonElement,�������JSON�﷨�����ǿ��ת�Ͳ��ɹ�������null
	 * @see com.google.gson.JsonParser#parse(String)
	 */
	@SuppressWarnings("unchecked")
	public static <T extends JsonElement> T toJsonObject(String text) {
		
		try {
			return (T)PARSER.parse(text);
		}catch(JsonSyntaxException | ClassCastException e) {
			return null;
		}
		
	}
	
	/**
	 * ʹ�ø������ַ�����ȡ���ݲ�ת��JsonElement
	 * @param <T> JsonElement������,ת��֮���ǿ��ת�ͳɴ����Ͳ�����
	 * @param reader Ҫʹ�õ��ֽ���
	 * @return ת����ǿ��ת�͵�JsonElement,JSON�﷨�����ǿ��ת�Ͳ��ɹ�������null
	 * @throws IOException ����ȡʱ���� I/O �쳣ʱ�׳�
	 */
	@SuppressWarnings("unchecked")
	public static <T extends JsonElement> T toJsonObject(Reader reader) throws IOException {
		
		try {
			return (T)PARSER.parse(reader);
		}catch(JsonIOException e) {
			throw new IOException(e);
		}catch(JsonSyntaxException | ClassCastException e) {
			return null;
		}
		
	}
	
	/**
	 * ��һ��JsonObject��ӵ������ļ�ֵ�����Ͷ�Ϊ�ַ�����Map����
	 * @param json JsonObject
	 * @param map ������Map����
	 * @return ��Ӻ��Map����
	 */
	public static Map<String,String> toMap(JsonObject json,Map<String,String> map){
		
		for(Entry<String,JsonElement> entry : json.entrySet()) {
			map.put(entry.getKey(), entry.getValue().getAsString());
		}
		
		return map;
		
	}
	
}
