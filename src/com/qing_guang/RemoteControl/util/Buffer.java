package com.qing_guang.RemoteControl.util;

import java.util.Vector;

/**
 * һ���̰߳�ȫ�Ļ�����<br />
 * ʹ��add������������ӵ�������<br />
 * ʹ��get�����������ָ������ݲ��ô˻�����ָ����һ������(����Ϊ��)<br />
 * ��ϸ�����뿴����ķ���ע��<br />
 * 
 * @author Qing_Guang
 * @param <E> ��������������
 */
public class Buffer<E> {

	private Vector<E> datas = new Vector<>();
	private Integer insert = 0;
	
	/**
	 * ��û���������ָ�������,��ָ�������Ϊ��,�򷵻�null,���򷵻����ݲ��ô˻�����ָ����һ������(����Ϊ��)
	 * @return ����������ָ�������
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
	 * �򻺳������һ������
	 * @param e ��Ҫ��ӵ�����
	 */
	public void add(E e) {
		datas.add(e);
	}
	
	/**
	 * �����������ָ��һ���µ�����λ��
	 * @param insert �µ�����λ��
	 * @throws IndexOutOfBoundsException �����������λ��Խ��(С��0������������ݸ���)ʱ�׳�
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
	 * �����������ָ����һ��������λ���Ա������¶�ȡ
	 */
	public void insertToLast() {
		insertTo(insertWhere() - 1);
	}
	
	/**
	 * �����������ָ���һ������λ��
	 */
	public void insertToStart() {
		insertTo(0);
	}
	
	/**
	 * ���ָ�������Ѷ�����
	 * @param num ����ĸ���
	 * @throws IndexOutOfBoundsException ������ĸ���С��0ʱ��ָ�������λ��ǰ����Ѷ����ݸ������ڴ���ĸ���ʱ�׳�
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
	 * ��������Ѷ�����
	 */
	public void clearAll() {
		clear(insertWhere());
	}
	
	/**
	 * ����������ָ����һ��λ��
	 */
	public int insertWhere() {
		synchronized (insert) {
			return insert;
		}
	}
	
	/**
	 * ���б���ӵ������������ݸ���(��������ɾ��������)
	 */
	public int size() {
		return datas.size();
	}
	
	/**
	 * ��û������������ݵĸ���(��������ɾ��������)
	 * @return �������������ݵĸ���
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
