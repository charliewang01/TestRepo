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
    
    //Redis������IP
    private static String ADDR = "10.173.178.156";
    
    //Redis�Ķ˿ں�
    private static int PORT =6379;
    //��������
    private static String AUTH = "";
    //��������ʵ���������Ŀ��Ĭ��ֵΪ8��
    //�����ֵΪ-1�����ʾ�����ƣ����pool�Ѿ�������maxActive��jedisʵ�������ʱpool��״̬Ϊexhausted(�ľ�)��
    private static int MAX_ACTIVE = 1024;
    
    //����һ��pool����ж��ٸ�״̬Ϊidle(���е�)��jedisʵ����Ĭ��ֵҲ��8��
    private static int MAX_IDLE = 500;
    
    //�ȴ��������ӵ����ʱ�䣬��λ���룬Ĭ��ֵΪ-1����ʾ������ʱ����������ȴ�ʱ�䣬��ֱ���׳�JedisConnectionException��
    private static int MAX_WAIT = 10000 * 10000;
    
    private static int TIMEOUT = 10000;
    
    //��borrowһ��jedisʵ��ʱ���Ƿ���ǰ����validate���������Ϊtrue����õ���jedisʵ�����ǿ��õģ�
    private static boolean TEST_ON_BORROW = true;
    
    private static JedisPool jedisPool = null;
	private static ShardedJedisPool shardedPool;
    private static JedisPool pool1;
    private static JedisPool pool2;
    /**
     * ��ʼ��Redis���ӳ�
     */
    static {

            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxActive(1024);
            config.setMaxIdle(200);
            config.setMaxWait(1000);
            config.setTestOnBorrow(true);
            config.setTestOnReturn(true);
            /*��һ̨������,��������*/
            JedisShardInfo jedisShardInfo1 = new JedisShardInfo("127.0.0.1",6379);
            /*�ڶ�̨����������˾�ڲ�����*/
//            JedisShardInfo jedisShardInfo2 = new JedisShardInfo("10.170.123.74",6379);
            List<JedisShardInfo> list = new LinkedList<JedisShardInfo>();
            list.add(jedisShardInfo1);
//            list.add(jedisShardInfo2);
            shardedPool = new ShardedJedisPool(config, list);
            /*��һ̨������*/
//            pool1=new JedisPool("10.173.178.156", 6379);
            /*�ڶ�̨������*/
//            pool2=new JedisPool("10.170.123.74", 6379);
    }
    


    /**
     * ��ȡJedisʵ��
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
     * �ͷ�jedis��Դ
     * @param jedis
     */
    public static  void returnResource( ShardedJedis jedis) {
        if (shardedPool != null) {
        	shardedPool.returnResource(jedis);
        }
    }
    
}