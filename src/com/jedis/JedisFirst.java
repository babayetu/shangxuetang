package com.jedis;

import redis.clients.jedis.Jedis;

public class JedisFirst {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("10.199.199.63",6379);
		try {
			jedis.set("foo", "bar");
			String value = jedis.get("foo");
			System.out.println(value);
		} finally {
			jedis.close();
		}
		
	}
}
