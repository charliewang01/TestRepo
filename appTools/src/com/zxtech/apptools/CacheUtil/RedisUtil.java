package com.zxtech.apptools.CacheUtil;

import java.util.LinkedList;
import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public  class RedisUtil {
    
    //Redis服务器IP
    private static String ADDR = "10.173.178.156";
    
    //Redis的端口号
    private static int PORT =6379;
    //访问密码
    private static String AUTH = "";
    //可用连接实例的最大数目，默认值为8；
    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
    private static int MAX_ACTIVE = 1024;
    
    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private static int MAX_IDLE = 500;
    
    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    private static int MAX_WAIT = 10000 * 10000;
    
    private static int TIMEOUT = 10000;
    
    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static boolean TEST_ON_BORROW = true;
    
    private static JedisPool jedisPool = null;
	private static ShardedJedisPool shardedPool;
    private static JedisPool pool1;
    private static JedisPool pool2;
    /**
     * 初始化Redis连接池
     */
    static {

            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxActive(1024);
            config.setMaxIdle(200);
            config.setMaxWait(1000);
            config.setTestOnBorrow(true);
            config.setTestOnReturn(true);
            /*第一台服务器,阿里云上*/
            JedisShardInfo jedisShardInfo1 = new JedisShardInfo("127.0.0.1",6379);
            /*第二台服务器，公司内部测试*/
//            JedisShardInfo jedisShardInfo2 = new JedisShardInfo("10.170.123.74",6379);
            List<JedisShardInfo> list = new LinkedList<JedisShardInfo>();
            list.add(jedisShardInfo1);
//            list.add(jedisShardInfo2);
            shardedPool = new ShardedJedisPool(config, list);
            /*第一台服务器*/
//            pool1=new JedisPool("10.173.178.156", 6379);
            /*第二台服务器*/
//            pool2=new JedisPool("10.170.123.74", 6379);
    }
    


    /**
     * 获取Jedis实例
     * @return
     */
    
    public static  ShardedJedis  getJedis() {
    	try{
        if (shardedPool == null)
             return shardedPool.getResource();
      }catch(Exception e){
    	  e.printStackTrace();
       }
    	   return shardedPool.getResource();
    }
    
    /**
     * 释放jedis资源
     * @param jedis
     */
    public static  void returnResource( ShardedJedis jedis) {
        if (shardedPool != null) {
        	shardedPool.returnResource(jedis);
        }
    }
    
}