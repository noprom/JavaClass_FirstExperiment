package com.noprom.app;

public class ConnectionManager {

	private static int count = 10; // 用来限制Connecttion能生成的最大的个数

	private static Connecttion[] pool = new Connecttion[10]; // 用来保存Connecttion对象的数组
	static {
		for (Connecttion c : pool) {
			c = Connecttion.creatConnecttion();
		}
	}

	/**
	 * 获取一个Connecttion类的实例
	 * 
	 * @return 一个Connecttion类的实例
	 */
	public Connecttion getConnecttion() {
		if (count > 0) {
			return pool[--count];
		} else {
			System.out.println("No more Connecttion left.");
			return null;
		}
	}

	public static void main(String[] args) {
		ConnectionManager manager = new ConnectionManager();
		for (int i = 0; i < 15; ++i) {
			manager.getConnecttion();
		}
	}

}

/**
 * Connecttion 类
 * 
 * @author noprom
 *
 */
class Connecttion {
	private static int counter; // 记录当前是第几个Connecttion类
	private int id;
	
	private Connecttion() { // 定义为私有，只能通过下面的creatConnecttion()方法来实例化该类
		System.out.println(toString());
	}

	public static Connecttion creatConnecttion() {
		++counter; // 每次new一个Connecttion类则改变counter的值
		return new Connecttion();
	}

	@Override
	public String toString() {
		return new String("Connecttion " + counter);
	}
}
