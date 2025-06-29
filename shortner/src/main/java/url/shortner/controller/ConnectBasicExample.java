package url.shortner.controller;

import redis.clients.jedis.UnifiedJedis;
import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisClientConfig;

public class ConnectBasicExample {
    public void run() {
        JedisClientConfig config = DefaultJedisClientConfig.builder()
                .user("default")
                .password("pyv7gkE0yWP7hL2mpV9aGYmxTV8cNzMf")
                .build();

        UnifiedJedis jedis = new UnifiedJedis(
                new HostAndPort("redis-16728.c330.asia-south1-1.gce.redns.redis-cloud.com", 16728),
                config
        );

        String res1 = jedis.set("foo", "bar");
        System.out.println(res1); // >>> OK

        String res2 = jedis.get("foo");
        System.out.println(res2); // >>> bar

        jedis.close();
    }
}