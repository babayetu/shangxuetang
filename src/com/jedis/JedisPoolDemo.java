package com.jedis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolDemo {
	public static void main(String[] args) {
		JedisPool pool = new JedisPool(new JedisPoolConfig(), "10.199.199.63");
	}
}
