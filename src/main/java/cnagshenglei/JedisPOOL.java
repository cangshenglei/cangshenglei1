package cnagshenglei;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPOOL {
    public static JedisPool pool =  null ;

    public static Jedis getJedis(){
        if(pool == null ){
            //主要配置
            JedisPoolConfig jedisPoolConfig =new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(10); //最大可用连接数
            jedisPoolConfig.setMaxIdle(5); //最大闲置连接数
            jedisPoolConfig.setMinIdle(5); //最小闲置连接数
            jedisPoolConfig.setBlockWhenExhausted(true); //连接耗尽是否等待
            jedisPoolConfig.setMaxWaitMillis(2000); //等待时间
            jedisPoolConfig.setTestOnBorrow(true); //取连接的时候进行一下测试 ping pong
            pool = new JedisPool(jedisPoolConfig,"hadoop102",6379) ;
        }

        return pool.getResource();
    }
    public static void main(String[] args) {
        //Jedis jedis = new Jedis("hadoop202",6379);
        Jedis jedis = getJedis();
        String ping = jedis.ping();
        System.out.println(ping);
    }
}
