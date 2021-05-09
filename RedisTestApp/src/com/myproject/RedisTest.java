package com.myproject;


import com.lambdaworks.redis.*;

import redis.clients.jedis.Jedis;

public class RedisTest {

	public static void main(String[] args) {
		
		  Jedis jedis = new Jedis("localhost",6379); 
		  jedis.set("key1", "value1");
		  System.out.println("ping "+ jedis.set("key1", "value7")+"\nget value of key1 "+jedis.get("key1"));
		  jedis.del("key1");
		  System.out.println("After deleting: "+jedis.get("key1"));
		 
		 

		/*
		 * RedisClient redisClient = new
		 * RedisClient(RedisURI.create("rediss://password@host:port"));
		 * RedisConnection<String, String> connection = redisClient.connect();
		 * 
		 * System.out.println("Connected to Redis");
		 * 
		 * connection.close(); redisClient.shutdown();
		 */
	}

}
