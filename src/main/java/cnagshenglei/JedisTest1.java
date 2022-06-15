package cnagshenglei;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import redis.clients.jedis.Jedis;

public class JedisTest1 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("hadoop102",6379);
        System.out.println(jedis.ping());
        jedis.set("2022-06-15","bushuang");
        String s = jedis.get("2022-06-15");
        System.out.println(s);

        jedis.expire("2022-06-15-1",6000);

        boolean Runing=true;
        while (Runing){
            Long ttl = jedis.ttl("2022-05-15-1");
            System.out.println(ttl);
            if (ttl==-2){
                Runing=false;
            }
        }
    }
}
