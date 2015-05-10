package com.noprom.app;

public class ConnectionManager {
	private static int count = 10;
	private static Connecttion[] pool = new Connecttion[10];
	static{
		for(Connecttion c:pool){
			c = Connecttion.creatConnecttion();
		}
	}
	
	public static Connecttion getConnecttion(){
		if(count > 0){
			return pool[--count];
		}else{
			System.out.println("No more Connecttion left.");
			return null;
		}
	}
	
	public static void main(String[] args) {
		ConnectionManager manager = new ConnectionManager();
		for(int i=0;i<15;++i){
			manager.getConnecttion();
		}
	}

}

class Connecttion{
	private static int counter;
	private Connecttion(){
		System.out.println(toString());
	}
	public static Connecttion creatConnecttion(){
		++counter;
		return new Connecttion();
	}
	@Override
	public String toString(){
		return new String("Connecttion "+counter);
	}
}
