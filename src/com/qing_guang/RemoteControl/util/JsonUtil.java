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
 * JSON文本工具类
 * @author A
 *
 */
public final class JsonUtil {

	private JsonUtil() {}
	
	private static final JsonParser PARSER = new JsonParser();
	
	/**
	 * 将一个byte数组添加到给定的JsonArray里
	 * @param array byte数组
	 * @param jarray 给定的JsonArray
	 * @return 添加后的JsonArray
	 */
	public static JsonArray toJsonArray(byte[] array,JsonArray jarray) {
		
		for(byte v : array) {
			jarray.add(new JsonPrimitive(v));
		}
		
		return jarray;
		
	}
	
	/**
	 * 将一个字符串数组添加到给定的JsonArray里
	 * @param array 字符串数组
	 * @param jarray 给定的JsonArray
	 * @return 添加后的JsonArray
	 */
	public static JsonArray toJsonArray(String[] array,JsonArray jarray) {
		
		for(String str : array) {
			jarray.add(new JsonPrimitive(str));
		}
		
		return jarray;
		
	}
	
	/**
	 * 将一个JsonArray中的数据设置到给定的byte数组内
	 * @param jarray JsonArray
	 * @param array 给定的byte数组
	 * @return 设置后的byte数组
	 */
	public static byte[] toArray(JsonArray jarray,byte[] array) {
		
		for(int i = 0;i < jarray.size();i++) {
			array[i] = jarray.get(i).getAsByte();
		}
		
		return array;
		
	}
	
	/**
	 * 将一个JsonArray中的数据设置到给定的字符串数组内
	 * @param jarray JsonArray
	 * @param array 给定的字符串数组
	 * @return 设置后的字符串数组
	 */
	public static String[] toArray(JsonArray jarray,String[] array) {
		
		for(int i = 0;i < jarray.size();i++) {
			array[i] = jarray.get(i).getAsString();
		}
		
		return array;
		
	}
	
	/**
	 * 将一个键值对类型都为字符串的Map集合中的数据添加到指定的JsonObject里
	 * @param map Map集合
	 * @param json 指定的JsonObject
	 * @return 添加后的JsonObject
	 */
	public static JsonObject toJsonObject(Map<String,String> map,JsonObject json) {
		
		for(String key : map.keySet()) {
			json.addProperty(key, map.get(key));
		}
		
		return json;
		
	}
	
	/**
	 * 将一段字符串转成JsonElement
	 * @param <T> JsonElement的子类,转换之后会强制转型成此类型并返回
	 * @param text 要转换的字符串
	 * @return 转换后强制转型的JsonElement,如果出现JSON语法错误或强制转型不成功将返回null
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
	 * 使用给定的字符流读取数据并转成JsonElement
	 * @param <T> JsonElement的子类,转换之后会强制转型成此类型并返回
	 * @param reader 要使用的字节流
	 * @return 转换后强制转型的JsonElement,JSON语法错误或强制转型不成功将返回null
	 * @throws IOException 当读取时发生 I/O 异常时抛出
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
	 * 将一个JsonObject添加到给定的键值对类型都为字符串的Map集合
	 * @param json JsonObject
	 * @param map 给定的Map集合
	 * @return 添加后的Map集合
	 */
	public static Map<String,String> toMap(JsonObject json,Map<String,String> map){
		
		for(Entry<String,JsonElement> entry : json.entrySet()) {
			map.put(entry.getKey(), entry.getValue().getAsString());
		}
		
		return map;
		
	}
	
}
