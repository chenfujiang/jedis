package com.atguigu.testjedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Protocol;

import java.util.List;

/**
 * @author chenfujiang
 * @create 2020-08-31 15:03
 */
public class JedisTest {

    @Test
    public void test1(){
        String host="192.168.1.102";
        int port=Protocol.DEFAULT_PORT;
        Jedis jedis = new Jedis(host, port);
        String ping = jedis.ping();
        System.out.println("ping:"+ping);
        Long result = jedis.lpush("fruit", "apple", "orange", "banana");
        System.out.println(result);
        jedis.close();
    }
    @Test
    public void test2(){
        String host = "192.168.1.102";
        int port = Protocol.DEFAULT_PORT;
        JedisPool jedisPool = new JedisPool(host, port);
        Jedis jedis = jedisPool.getResource();
        List<String> fruit = jedis.lrange("fruit", 0, -1);
        for (String s : fruit) {
            System.out.println("fruit:"+s);
        }
        jedis.close();
    }
}
