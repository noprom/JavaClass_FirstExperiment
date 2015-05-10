package com.noprom.app;

public class Value {

	private String x;
	private Double y;

	@Override
	public boolean equals(Object obj) {
		Value val = new Value();
		if (!(obj instanceof Value)) {
			return false;
		}

		if (val.x.equals(((Value) obj).x) && val.y.equals(((Value) obj).y)) {
			return true;
		}
		return false;
	}

}
