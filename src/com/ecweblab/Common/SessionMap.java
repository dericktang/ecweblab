package com.ecweblab.Common;

import java.util.HashMap;
import java.util.Map;

public class SessionMap {
	private static Map map;
	static {
		if (map == null) {
			map = new HashMap();
		}
	}
	public void set(String k, Object v) {
		map.put(k, v);
	}
	public Object get(String k) {
		return  map.get(k);
	}
}
