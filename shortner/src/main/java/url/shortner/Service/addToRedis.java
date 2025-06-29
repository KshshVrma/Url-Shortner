package url.shortner.Service;

import redis.clients.jedis.*;

import java.util.HashMap;

public  class addToRedis {
    private addToRedis() {
    }
    private static addToRedis instance;
    public static addToRedis getInstance() {
        if (instance == null) {
            instance = new addToRedis();
        }
        return instance;}
Jedis jedis=new Jedis("localhost", 6379);
//    public void start() {
//        JedisClientConfig config = DefaultJedisClientConfig.builder()
////                .user("default")
////                .password("pyv7gkE0yWP7hL2mpV9aGYmxTV8cNzMf")
//                .build();
//
//       jedis = new UnifiedJedis(
////                new HostAndPort("redis-16728.c330.asia-south1-1.gce.redns.redis-cloud.com", 16728),
//         new HostAndPort("localhost", 6379),
//
//                config
//        );
//
//    }
//    docker run --name redis-server -p 6379:6379 -d redis

    public String getFromRedis(String key) {
        String value = jedis.get(key);
        if (value != null) {
            return value;
        } else {
            return "Key not found in Redis";
        }
    }
    public String addToRed(HashMap<String, String> urlStore) {


        if (urlStore == null || urlStore.isEmpty()) {
            return "No key-value pairs to add";
        }
        for(HashMap.Entry<String, String> entry : urlStore.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            jedis.set(key, value);
        }
        return "Key-value pairs added to Redis successfully";
    }
    public String deleteFromRedis(String key) {
        Long result = jedis.del(key);
        if (result > 0) {
            return "Key deleted successfully";
        } else {
            return "Key not found in Redis";
        }
    }

    public void close() {
        jedis.close();
    }
}
