package com.qing_guang.RemoteControl.util;

import java.util.Vector;

/**
 * 一个线程安全的缓冲区<br />
 * 使用add方法将数据添加到缓冲区<br />
 * 使用get方法获得现在指向的数据并让此缓冲区指向下一个数据(可以为无)<br />
 * 详细内容请看具体的方法注释<br />
 * 
 * @author Qing_Guang
 * @param <E> 缓冲区数据类型
 */
public class Buffer<E> {

	private Vector<E> datas = new Vector<>();
	private Integer insert = 0;
	
	/**
	 * 获得缓冲区现在指向的数据,若指向的数据为空,则返回null,否则返回数据并让此缓冲区指向下一个数据(可以为无)
	 * @return 缓冲区现在指向的数据
	 */
	public E get() {
		synchronized (insert) {
			if(datas.size() - 1 < insert) {
				return null;
			}else {
				E e = datas.get(insert);
				insert++;
				return e;
			}
		}
	}
	
	/**
	 * 向缓冲区添加一个数据
	 * @param e 将要添加的数据
	 */
	public void add(E e) {
		datas.add(e);
	}
	
	/**
	 * 让这个缓冲区指向一个新的数据位置
	 * @param insert 新的数据位置
	 * @throws IndexOutOfBoundsException 当传入的数据位置越界(小于0或大于现有数据个数)时抛出
	 */
	public void insertTo(int insert) throws IndexOutOfBoundsException{
		synchronized (this.insert) {
			if(insert < 0 || insert > datas.size()) {
				throw new IndexOutOfBoundsException(Integer.toString(insert));
			}
			this.insert = insert;
		}
	}
	
	/**
	 * 让这个缓冲区指向上一个的数据位置以便于重新读取
	 */
	public void insertToLast() {
		insertTo(insertWhere() - 1);
	}
	
	/**
	 * 让这个缓冲区指向第一个数据位置
	 */
	public void insertToStart() {
		insertTo(0);
	}
	
	/**
	 * 清除指定个数已读数据
	 * @param num 清除的个数
	 * @throws IndexOutOfBoundsException 若传入的个数小于0时或指向的数据位置前面的已读数据个数大于传入的个数时抛出
	 */
	public void clear(int num) throws IndexOutOfBoundsException{
		if(num < 0 || insertWhere() < num) {
			throw new IndexOutOfBoundsException(Integer.toString(num));
		}
		for(int i = 0;i < num;i++) {
			datas.remove(0);
			insertToLast();
		}
	}
	
	/**
	 * 清除所有已读数据
	 */
	public void clearAll() {
		clear(insertWhere());
	}
	
	/**
	 * 缓冲区现在指向哪一个位置
	 */
	public int insertWhere() {
		synchronized (insert) {
			return insert;
		}
	}
	
	/**
	 * 所有被添加到缓冲区的数据个数(不包含已删除的数据)
	 */
	public int size() {
		return datas.size();
	}
	
	/**
	 * 获得缓冲区所有数据的副本(不包含已删除的数据)
	 * @return 缓冲区所有数据的副本
	 */
	@SuppressWarnings("unchecked")
	public Vector<E> getDatas(){
		return (Vector<E>) datas.clone();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Buffer<E> clone(){
		Buffer<E> clone = new Buffer<>();
		clone.datas = getDatas();
		clone.insert = insert.intValue();
		return clone;
	}
	
}
