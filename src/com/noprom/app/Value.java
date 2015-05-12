package com.noprom.app;

public class Value {

	private Character x;
	private Double y;

	public Value(Character x, Double y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Value obj) {
		if (this.x.equals(obj.x) && this.y.equals(obj.y)) {
			return true;
		}
		return false;
	}

	public static void main(String args[]){
		Value a = new Value('a',(double)1.1);
		Value b = new Value('b',(double)1.1);
		
		if(a.equals(b)){
			System.out.println("a与b的内容相等");
		}else{
			System.out.println("a与b的内容不相等");
		}
		
		b.x='a';
		if(a.equals(b)){
			System.out.println("a与b的内容相等");
		}else{
			System.out.println("a与b的内容不相等");
		}
	}
}
