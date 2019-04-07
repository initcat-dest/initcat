package com.initcat.user_service.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.*;

import java.util.*;

/**
 * class description
 *
 * @author libo
 * @package com.initcat.user_service.util
 * @company xmiles
 * @date 2019/3/24
 */
public class RedisUtils {

    private static Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    /**
     * Only set the key if it does not already exist.
     */
    public static final String NX = "NX";

    /**
     * expire time units : seconds
     */
    public static final String EX = "EX";

    private static JedisPool jedisPool = null;

    // 初始化redis连接池
    static {
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数 // 可以创建3000jedis实例 
        config.setMaxTotal(30);
        // 设置最大空闲连接数
        config.setMaxIdle(3);
        // 等待可用连接的最大时间
        config.setMaxWaitMillis(10000);
        // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的
        config.setTestOnBorrow(true);
        jedisPool = new JedisPool(config, "47.104.185.53", 6379, 10000, "libo3788125", 0, "libo");
    }

    /**
     * 获取Jedis实例
     * 每次用完要将连接返回给连接池 jedis.close();
     */
    public synchronized static Jedis getResource() {
        if (jedisPool != null) {
            Jedis resource = jedisPool.getResource();
            return resource;
        } else {
            return null;
        }
    }

    /**
     * 回收Jedis对象资源 
     *     - 用户redis都要使用该方法释放资源, 否则一直占有实例资源
     *
     * @param jedis 
     */

    public synchronized static void returnResource(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }




    /* ==========================Key(键)操作====================== */

    /**
     * 删除给定的一个key
     * <p>
     * 返回值：被删除key的数量
     *
     * @param key
     * @return
     */
    public static long del(String key) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.del(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.del falid", e);
        }
        return result;
    }

    /**
     * 删除一堆的keys
     * <p>
     * 返回值：被删除key的数量
     *
     * @param key
     * @return
     */
    public static long delKeys(String... key) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.del(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.delKeys falid", e);
        }
        return result;
    }

    /**
     * 以秒为单位，返回给定 key 的剩余生存时间(TTL, time to live)
     * <p>
     * 返回值： 当 key 不存在时，返回 -2 。 当 key 存在但没有设置剩余生存时间时，返回 -1 。 否则，以秒为单位，返回 key
     * 的剩余生存时间。
     *
     * @param key
     * @return
     */
    public static long ttl(String key) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.ttl(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.ttl falid", e);
        }
        return result;
    }

    /**
     * 检查给定 key 是否存在
     * <p>
     * 返回值： 若 key 存在，返回 1 ，否则返回 0 。
     *
     * @param key
     * @return
     */
    public static boolean exists(String key) {
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.exists(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.exists falid", e);
        }
        return result;
    }

    /**
     * 检查给定 key 是否存在
     * <p>
     * 返回值： 若 key 存在，返回 1 ，否则返回 0 。
     *
     * @param key
     * @return
     */
    public static boolean exists(byte[] key) {
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.exists(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.exists falid", e);
        }
        return result;
    }

    /**
     * 返回 key 所储存的值的类型;
     * <p>
     * 返回值： none (key不存在) string (字符串) list (列表) set (集合) zset (有序集) hash (哈希表)
     *
     * @param key
     * @return
     */
    public static String type(String key) {
        String result = "";
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.type(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.type falid", e);
        }
        return result;
    }

    /**
     * 返回 key 所储存的值的类型;
     * <p>
     * 返回值： none (key不存在) string (字符串) list (列表) set (集合) zset (有序集) hash (哈希表)
     *
     * @param key
     * @return
     */
    public static String type(byte[] key) {
        String result = "";
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.type(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.type falid", e);
        }
        return result;
    }

    /**
     * 为给定 key 设置或更新生存时间，当 key 过期时(生存时间为 0 )，它会被自动删除；
     * <p>
     * 返回值： 设置成功返回 1 。 当 key 不存在或者不能为 key 设置生存时间时(比如在低于 2.1.3 版本的 Redis 中你尝试更新
     * key 的生存时间)，返回 0
     *
     * @param key
     * @param seconds
     * @return
     */
    public static long expire(String key, int seconds) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.expire(key, seconds);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.expire falid", e);
        }
        return result;
    }

    /**
     * 为给定 key 设置或更新生存时间，当 key 过期时(生存时间为 0 )，它会被自动删除；
     * <p>
     * 返回值： 设置成功返回 1 。 当 key 不存在或者不能为 key 设置生存时间时(比如在低于 2.1.3 版本的 Redis 中你尝试更新
     * key 的生存时间)，返回 0
     *
     * @param key
     * @param seconds
     * @return
     */
    public static long expire(byte[] key, int seconds) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.expire(key, seconds);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.expire falid", e);
        }
        return result;
    }

    /**
     * 为给定 key 设置或更新过期时间；
     * <p>
     * 返回值： 如果生存时间设置成功，返回 1 。 当 key 不存在或没办法设置生存时间，返回 0 。
     *
     * @param key
     * @param expiry
     * @return
     */
    public static long expireAt(String key, Date expiry) {
        long result = -10000;
        Jedis jedis = null;
        long unixTime = expiry.getTime() / 1000;
        try {
            jedis = getResource();
            // 时间参数是 UNIX 时间戳(unix
            // timestamp)；是从1970年1月1日（UTC/GMT的午夜）开始所经过的秒数，不考虑闰秒。
            result = jedis.expireAt(key, unixTime);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.expireAt falid", e);
        }
        return result;
    }

    /**
     * 为给定 key 设置或更新过期时间；
     * <p>
     * 返回值： 如果生存时间设置成功，返回 1 。 当 key 不存在或没办法设置生存时间，返回 0 。
     *
     * @param key
     * @param expiry
     * @return
     */
    public static long expireAt(byte[] key, Date expiry) {
        long result = -10000;
        Jedis jedis = null;
        long unixTime = expiry.getTime() / 1000;
        try {
            jedis = getResource();
            // 时间参数是 UNIX 时间戳(unix
            // timestamp)；是从1970年1月1日（UTC/GMT的午夜）开始所经过的秒数，不考虑闰秒。
            result = jedis.expireAt(key, unixTime);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.expireAt falid", e);
        }
        return result;
    }

    /* ==========================对value操作====================== */

    /**
     * 将字符串值 value 关联到 key 。 如果 key 已经持有其他值， SET 就覆写旧值，无视类型。
     * 对于某个原本带有生存时间（TTL）的键来说， 当 SET 命令成功在这个键上执行时， 这个键原有的 TTL 将被清除。
     * <p>
     * 返回 OK
     *
     * @param key
     * @param value
     * @return
     */
    public static boolean set(String key, String value) {
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getResource();
            String status = jedis.set(key, value);
            if ("OK".equalsIgnoreCase(status)) {
                result = true;
            }
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.set falid", e);
        }
        return result;
    }

    /**
     * 将 key 的值设为 value，当且仅当 key 不存在，并将 key 的生存时间设为 seconds(以秒为单位)。
     * 该命令与以下命令组完全等效：{@link #setnx(String, String) SETNX} + {@link #expire(String, int) EXPIRE}。
     * 这是一个原子操作。
     *
     * @param key
     * @param value
     * @param seconds expire time
     * @return 成功返回 true， 失败返回 false
     * @see #set(String, String, String, String, long)
     */
    public static boolean setnxex(final String key, final String value, final int seconds) {
        return set(key, value, NX, EX, seconds);
    }

    public static boolean set(String key, String value, String nxxx, String expx, long time) {
        boolean result = false;
        Jedis jedis = null;

        try {
            jedis = getResource();
            String status = jedis.set(key, value, nxxx, expx, time);
            if ("OK".equalsIgnoreCase(status)) {
                result = true;
            }

            returnResource(jedis);
        } catch (Exception var9) {
            returnResource(jedis);
            logger.error("JedisCache.set falid", var9);
        }

        return result;
    }

    /**
     * 同时设置一个或多个 key-value 对。 如果某个给定 key 已经存在，那么 MSET
     * 会用新值覆盖原来的旧值，如果这不是你所希望的效果，请考虑使用 MSETNX 命令：它只会在所有给定 key 都不存在的情况下进行设置操作。
     * MSET 是一个原子性(atomic)操作，所有给定 key 都会在同一时间内被设置，某些给定 key 被更新而另一些给定 key
     * 没有改变的情况，不可能发生。 可用版本： >= 1.0.1 时间复杂度： O(N)， N 为要设置的 key 数量。 返回值： 总是返回 OK
     * (因为 MSET 不可能失败)
     *
     * @param array
     * @return
     */
    public static boolean mset(String[] array) {
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getResource();
            String status = jedis.mset(array);
            if ("OK".equalsIgnoreCase(status)) {
                result = true;
            }
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.set falid", e);
        }
        return result;
    }

    /**
     * 返回所有(一个或多个)给定 key 的值。
     * <p>
     * 如果给定的 key 里面，有某个 key 不存在，那么这个 key 返回特殊值 nil 。因此，该命令永不失败。
     * <p>
     * 可用版本： >= 1.0.0 时间复杂度: O(N) , N 为给定 key 的数量。 返回值： 一个包含所有给定 key 的值的列表。
     *
     * @param array
     * @return
     */
    public static List<String> mget(String[] array) {
        List<String> mget = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            mget = jedis.mget(array);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.set falid", e);
        }
        return mget;
    }

    /**
     * 返回所有(一个或多个)给定 key 的值。
     * <p>
     * 如果给定的 key 里面，有某个 key 不存在，那么这个 key 返回特殊值 nil 。因此，该命令永不失败。
     * <p>
     * 可用版本： >= 1.0.0 时间复杂度: O(N) , N 为给定 key 的数量。 返回值： 一个包含所有给定 key 的值的列表。
     *
     * @param array
     * @return
     */
    public static List<byte[]> mget(byte[]... array) {
        List<byte[]> mget = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            mget = jedis.mget(array);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.set falid", e);
        }
        return mget;
    }

    /**
     * 将字符串值 value 关联到 key 。 如果 key 已经持有其他值， SET 就覆写旧值，无视类型。
     * 对于某个原本带有生存时间（TTL）的键来说， 当 SET 命令成功在这个键上执行时， 这个键原有的 TTL 将被清除。
     * <p>
     * 返回 OK
     *
     * @param key
     * @param value
     * @return
     */
    public static boolean set(byte[] key, byte[] value) {
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getResource();
            String status = jedis.set(key, value);
            if ("OK".equalsIgnoreCase(status)) {
                result = true;
            }
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.set falid", e);
        }
        return result;
    }

    /**
     * 将 key 的值设为 value ，当且仅当 key 不存在。 若给定的 key 已经存在，则 SETNX 不做任何动作。 SETNX 是『SET
     * if Not eXists』(如果不存在，则 SET)的简写。
     * <p>
     * 返回值： 设置成功，返回 1 。 设置失败，返回 0 。
     *
     * @param key
     * @param value
     * @return
     */
    public static long setnx(String key, String value) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.setnx(key, value);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.setnx falid", e);
        }
        return result;
    }

    /**
     * 将 key 的值设为 value ，当且仅当 key 不存在。 若给定的 key 已经存在，则 SETNX 不做任何动作。 SETNX 是『SET
     * if Not eXists』(如果不存在，则 SET)的简写。
     * <p>
     * 返回值： 设置成功，返回 1 。 设置失败，返回 0 。
     *
     * @param key
     * @param value
     * @return
     */
    public static Long setnx(byte[] key, byte[] value) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.setnx(key, value);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.setnx falid", e);
        }
        return result;
    }

    /**
     * 将值 value 关联到 key ，并将 key 的生存时间设为 seconds (以秒为单位)。 如果 key 已经存在， SETEX
     * 命令将覆写旧值。
     * <p>
     * 返回值： 设置成功时返回 OK 。 当 seconds 参数不合法时，返回一个错误。
     *
     * @param key
     * @param seconds
     * @param value
     * @return
     */
    public static boolean setex(String key, int seconds, String value) {
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getResource();
            String status = jedis.setex(key, seconds, value);
            if ("OK".equalsIgnoreCase(status)) {
                result = true;
            }
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.setex falid", e);
        }
        return result;
    }

    /**
     * 将值 value 关联到 key ，并将 key 的生存时间设为 seconds (以秒为单位)。 如果 key 已经存在， SETEX
     * 命令将覆写旧值。
     * <p>
     * 返回值： 设置成功时返回 OK 。 当 seconds 参数不合法时，返回一个错误。
     *
     * @param key
     * @param seconds
     * @param value
     * @return
     */
    public static boolean setex(byte[] key, int seconds, byte[] value) {
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getResource();
            String status = jedis.setex(key, seconds, value);
            if ("OK".equalsIgnoreCase(status)) {
                result = true;
            }
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.setex falid", e);
        }
        return result;
    }

    /**
     * 用 value 参数覆写(overwrite)给定 key 所储存的字符串值，从偏移量 offset 开始。 不存在的 key
     * 当作空白字符串处理。
     * <p>
     * 返回值： 被 SETRANGE 修改之后，字符串的长度。
     *
     * @param key
     * @param offset
     * @param value
     * @return
     */
    public static long setrange(String key, long offset, String value) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.setrange(key, offset, value);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.setrange falid", e);
        }
        return result;
    }

    /**
     * 如果 key 已经存在并且是一个字符串， APPEND 命令将 value 追加到 key 原来的值的末尾。 如果 key 不存在， APPEND
     * 就简单地将给定 key 设为 value ，就像执行 SET key value 一样。
     * <p>
     * 返回值： 追加 value 之后， key 中字符串的长度。
     *
     * @param key
     * @param value
     * @return
     */
    public static long append(String key, String value) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.append(key, value);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.append falid", e);
        }
        return result;
    }

    /**
     * 如果 key 已经存在并且是一个字符串， APPEND 命令将 value 追加到 key 原来的值的末尾。 如果 key 不存在， APPEND
     * 就简单地将给定 key 设为 value ，就像执行 SET key value 一样。
     * <p>
     * 返回值： 追加 value 之后， key 中字符串的长度。
     *
     * @param key
     * @param value
     * @return
     */
    public static long append(byte[] key, byte[] value) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.append(key, value);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.append falid", e);
        }
        return result;
    }

    /**
     * 返回 key 所关联的字符串值。 如果 key 不存在那么返回特殊值 nil 。 假如 key 储存的值不是字符串类型，返回一个错误，因为 GET
     * 只能用于处理字符串值。
     * <p>
     * 返回值： 当 key 不存在时，返回 nil ，否则，返回 key 的值。 如果 key 不是字符串类型，那么返回一个错误。
     *
     * @param key
     * @return
     */
    public static String get(String key) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.get(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.get falid", e);
        }
        return result;
    }

    /**
     * 返回 key 所关联的字符串值。 如果 key 不存在那么返回特殊值 nil 。 假如 key 储存的值不是字符串类型，返回一个错误，因为 GET
     * 只能用于处理字符串值。
     * <p>
     * 返回值： 当 key 不存在时，返回 nil ，否则，返回 key 的值。 如果 key 不是字符串类型，那么返回一个错误。
     *
     * @param key
     * @return
     */
    public static byte[] get(byte[] key) {
        byte[] result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.get(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.get falid", e);
        }
        return result;
    }

    /**
     * 返回 key 中字符串值的子字符串，字符串的截取范围由 start 和 end 两个偏移量决定(包括 start 和 end 在内)。
     * 负数偏移量表示从字符串最后开始计数， -1 表示最后一个字符， -2 表示倒数第二个，以此类推。
     * <p>
     * 返回值： 截取得出的子字符串。
     *
     * @param key
     * @param startOffset
     * @param endOffset
     * @return
     */
    public static String getrange(String key, long startOffset, long endOffset) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.getrange(key, startOffset, endOffset);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.getrange falid", e);
        }
        return result;
    }

    /**
     * 将给定 key 的值设为 value ，并返回 key 的旧值(old value)。 当 key 存在但不是字符串类型时，返回一个错误。
     * <p>
     * 返回值： 返回给定 key 的旧值。 当 key 没有旧值时，也即是， key 不存在时，返回 nil 。
     *
     * @param key
     * @param value
     * @return
     */
    public static String getSet(String key, String value) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.getSet(key, value);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.getSet falid", e);
        }
        return result;
    }

    /**
     * 将给定 key 的值设为 value ，并返回 key 的旧值(old value)。 当 key 存在但不是字符串类型时，返回一个错误。
     * <p>
     * 返回值： 返回给定 key 的旧值。 当 key 没有旧值时，也即是， key 不存在时，返回 nil 。
     *
     * @param key
     * @param value
     * @return
     */
    public static byte[] getSet(byte[] key, byte[] value) {
        byte[] result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.getSet(key, value);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.getSet falid", e);
        }
        return result;
    }

    /**
     * 将 key 中储存的数字值减一。 如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 DECR 操作。
     * 如果值包含错误的类型，或字符串类型的值不能表示为数字，那么返回一个错误。 本操作的值限制在 64 位(bit)有符号数字表示之内。
     * <p>
     * 返回值： 执行 DECR 命令之后 key 的值。
     *
     * @param key
     * @return
     */
    public static long decr(String key) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.decr(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.decr falid", e);
        }
        return result;
    }

    /**
     * 将 key 中储存的数字值减一。 如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 DECR 操作。
     * 如果值包含错误的类型，或字符串类型的值不能表示为数字，那么返回一个错误。 本操作的值限制在 64 位(bit)有符号数字表示之内。
     * <p>
     * 返回值： 执行 DECR 命令之后 key 的值。
     *
     * @param key
     * @return
     */
    public static long decr(byte[] key) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.decr(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.decr falid", e);
        }
        return result;
    }

    /**
     * 将 key 所储存的值减去减量 decrement 。 如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 DECRBY
     * 操作。 如果值包含错误的类型，或字符串类型的值不能表示为数字，那么返回一个错误。 本操作的值限制在 64 位(bit)有符号数字表示之内。
     * <p>
     * 返回值： 减去 decrement 之后， key 的值。
     *
     * @param key
     * @param integer
     * @return
     */
    public static long decrBy(String key, long integer) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.decrBy(key, integer);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.decrBy falid", e);
        }
        return result;
    }

    /**
     * 将 key 所储存的值减去减量 decrement 。 如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 DECRBY
     * 操作。 如果值包含错误的类型，或字符串类型的值不能表示为数字，那么返回一个错误。 本操作的值限制在 64 位(bit)有符号数字表示之内。
     * <p>
     * 返回值： 减去 decrement 之后， key 的值。
     *
     * @param key
     * @param integer
     * @return
     */
    public static long decrBy(byte[] key, long integer) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.decrBy(key, integer);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.decrBy falid", e);
        }
        return result;
    }

    /**
     * 将 key 中储存的数字值增一。 如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 INCR 操作。
     * 如果值包含错误的类型，或字符串类型的值不能表示为数字，那么返回一个错误。 本操作的值限制在 64 位(bit)有符号数字表示之内。
     * <p>
     * 返回值： 执行 INCR 命令之后 key 的值。
     *
     * @param key
     * @return
     */
    public static long incr(String key) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.incr(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.incr falid", e);
        }
        return result;
    }


    public static double incrByFloat(String key, double value) {
        double result = -10000.00;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.incrByFloat(key, value);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.incr falid", e);
        }
        return result;
    }

    /**
     * 将 key 中储存的数字值增一。 如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 INCR 操作。
     * 如果值包含错误的类型，或字符串类型的值不能表示为数字，那么返回一个错误。 本操作的值限制在 64 位(bit)有符号数字表示之内。
     * <p>
     * 返回值： 执行 INCR 命令之后 key 的值。
     *
     * @param key
     * @return
     */
    public static long incr(byte[] key) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.incr(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.incr falid", e);
        }
        return result;
    }

    /**
     * 将 key 所储存的值加上增量 increment 。 如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 INCRBY
     * 命令。 如果值包含错误的类型，或字符串类型的值不能表示为数字，那么返回一个错误。 本操作的值限制在 64 位(bit)有符号数字表示之内。
     * <p>
     * 返回值： 加上 increment 之后， key 的值。
     *
     * @param key
     * @param integer
     * @return
     */
    public static long incrBy(String key, long integer) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.incrBy(key, integer);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.incrBy falid", e);
        }
        return result;
    }

    /**
     * 将 key 所储存的值加上增量 increment 。 如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 INCRBY
     * 命令。 如果值包含错误的类型，或字符串类型的值不能表示为数字，那么返回一个错误。 本操作的值限制在 64 位(bit)有符号数字表示之内。
     * <p>
     * 返回值： 加上 increment 之后， key 的值。
     *
     * @param key
     * @param integer
     * @return
     */
    public static long incrBy(byte[] key, long integer) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.incrBy(key, integer);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.incrBy falid", e);
        }
        return result;
    }

    /**
     * 排序，排序默认以数字作为对象，值被解释为双精度浮点数，然后进行比较；
     * <p>
     * 返回键值从小到大排序的结果
     *
     * @param key
     * @return
     */
    public static List<String> sort(String key) {
        List<String> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.sort(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.sort falid", e);
        }
        return result;
    }

    /**
     * 排序，排序默认以数字作为对象，值被解释为双精度浮点数，然后进行比较；
     * <p>
     * 返回键值从小到大排序的结果
     *
     * @param key
     * @return
     */
    public static List<byte[]> sort(byte[] key) {
        List<byte[]> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.sort(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.sort falid", e);
        }
        return result;
    }

    /**
     * 排序，按SortingParams中的规则排序；
     * <p>
     * 返回排序后的结果
     *
     * @param key
     * @param sortingParameters
     * @return
     */
    public static List<String> sort(String key, SortingParams sortingParameters) {
        List<String> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.sort(key, sortingParameters);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.sort falid", e);
        }
        return result;
    }

    /**
     * 排序，按SortingParams中的规则排序；
     * <p>
     * 返回排序后的结果
     *
     * @param key
     * @param sortingParameters
     * @return
     */
    public static List<byte[]> sort(byte[] key, SortingParams sortingParameters) {
        List<byte[]> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.sort(key, sortingParameters);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.sort falid", e);
        }
        return result;
    }

    /* ==========================对Hash(哈希表)操作====================== */

    /**
     * 将哈希表 key 中的域 field 的值设为 value 。 如果 key 不存在，一个新的哈希表被创建并进行 HSET 操作。 如果域
     * field 已经存在于哈希表中，旧值将被覆盖。
     * <p>
     * 返回值： 如果 field 是哈希表中的一个新建域，并且值设置成功，返回 1 。 如果哈希表中域 field 已经存在且旧值已被新值覆盖，返回 0
     * 。
     *
     * @param key
     * @param field
     * @param value
     * @return
     */
    public static long hset(String key, String field, String value) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hset(key, field, value);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.hset falid", e);
        }
        return result;
    }

    /**
     * 将哈希表 key 中的域 field 的值设为 value 。 如果 key 不存在，一个新的哈希表被创建并进行 HSET 操作。 如果域
     * field 已经存在于哈希表中，旧值将被覆盖。
     * <p>
     * 返回值： 如果 field 是哈希表中的一个新建域，并且值设置成功，返回 1 。 如果哈希表中域 field 已经存在且旧值已被新值覆盖，返回 0
     * 。
     *
     * @param key
     * @param field
     * @param value
     * @return
     */
    public static long hset(byte[] key, byte[] field, byte[] value) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hset(key, field, value);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.hset falid", e);
        }
        return result;
    }

    /**
     * 将哈希表 key 中的域 field 的值设置为 value ，当且仅当域 field 不存在。 若域 field 已经存在，该操作无效。 如果
     * key 不存在，一个新哈希表被创建并执行 HSETNX 命令。
     * <p>
     * 返回值： 设置成功，返回 1 。 如果给定域已经存在且没有操作被执行，返回 0 。
     *
     * @param key
     * @param field
     * @param value
     * @return
     */
    public static long hsetnx(String key, String field, String value) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hsetnx(key, field, value);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.hsetnx falid", e);
        }
        return result;
    }

    /**
     * 将哈希表 key 中的域 field 的值设置为 value ，当且仅当域 field 不存在。 若域 field 已经存在，该操作无效。 如果
     * key 不存在，一个新哈希表被创建并执行 HSETNX 命令。
     * <p>
     * 返回值： 设置成功，返回 1 。 如果给定域已经存在且没有操作被执行，返回 0 。
     *
     * @param key
     * @param field
     * @param value
     * @return
     */
    public static long hsetnx(byte[] key, byte[] field, byte[] value) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hsetnx(key, field, value);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.hsetnx falid", e);
        }
        return result;
    }

    /**
     * 同时将多个 field-value (域-值)对设置到哈希表 key 中。 此命令会覆盖哈希表中已存在的域。 如果 key
     * 不存在，一个空哈希表被创建并执行 HMSET 操作。
     * <p>
     * 返回值： 如果命令执行成功，返回 OK 。 当 key 不是哈希表(hash)类型时，返回一个错误。
     *
     * @param key
     * @param hash
     * @return
     */
    public static boolean hmset(String key, Map<String, String> hash) {
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getResource();
            String status = jedis.hmset(key, hash);
            if ("OK".equalsIgnoreCase(status)) {
                result = true;
            }
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.hmset falid", e);
        }
        return result;
    }

    /**
     * 同时将多个 field-value (域-值)对设置到哈希表 key 中。 此命令会覆盖哈希表中已存在的域。 如果 key
     * 不存在，一个空哈希表被创建并执行 HMSET 操作。
     * <p>
     * 返回值： 如果命令执行成功，返回 OK 。 当 key 不是哈希表(hash)类型时，返回一个错误。
     *
     * @param key
     * @param hash
     * @return
     */
    public static boolean hmset(byte[] key, Map<byte[], byte[]> hash) {
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getResource();
            String status = jedis.hmset(key, hash);
            if ("OK".equalsIgnoreCase(status)) {
                result = true;
            }
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.hmset falid", e);
        }
        return result;
    }

    /**
     * 获取哈希表 key 中给定域 field 的值。
     * <p>
     * 返回值： 给定域的值。 当给定域不存在或是给定 key 不存在时，返回 nil 。
     *
     * @param key
     * @param field
     * @return
     */
    public static String hget(String key, String field) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hget(key, field);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.hget falid", e);
        }
        return result;
    }

    /**
     * 获取哈希表 key 中给定域 field 的值。
     * <p>
     * 返回值： 给定域的值。 当给定域不存在或是给定 key 不存在时，返回 nil 。
     *
     * @param key
     * @param field
     * @return
     */
    public static byte[] hget(byte[] key, byte[] field) {
        byte[] result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hget(key, field);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.hget falid", e);
        }
        return result;
    }

    /**
     * 返回哈希表 key 中，一个或多个给定域的值。 如果给定的域不存在于哈希表，那么返回一个 nil 值。 因为不存在的 key
     * 被当作一个空哈希表来处理，所以对一个不存在的 key 进行 HMGET 操作将返回一个只带有 nil 值的表。
     * <p>
     * 返回值： 一个包含多个给定域的关联值的表，表值的排列顺序和给定域参数的请求顺序一样。
     *
     * @param key
     * @param fields
     * @return
     */
    public static List<String> hmget(String key, String... fields) {
        List<String> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hmget(key, fields);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.hmget falid", e);
        }
        return result;
    }

    /**
     * 返回哈希表 key 中，一个或多个给定域的值。 如果给定的域不存在于哈希表，那么返回一个 nil 值。 因为不存在的 key
     * 被当作一个空哈希表来处理，所以对一个不存在的 key 进行 HMGET 操作将返回一个只带有 nil 值的表。
     * <p>
     * 返回值： 一个包含多个给定域的关联值的表，表值的排列顺序和给定域参数的请求顺序一样。
     *
     * @param key
     * @param fields
     * @return
     */
    public static List<byte[]> hmget(byte[] key, byte[]... fields) {
        List<byte[]> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hmget(key, fields);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.hmget falid", e);
        }
        return result;
    }

    /**
     * 返回哈希表 key 中，所有的域和值。 在返回值里，紧跟每个域名(field
     * name)之后是域的值(value)，所以返回值的长度是哈希表大小的两倍。
     * <p>
     * 返回值： 以列表形式返回哈希表的域和域的值。 若 key 不存在，返回空列表。
     *
     * @param key
     * @return
     */
    public static Map<String, String> hgetAll(String key) {
        Map<String, String> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hgetAll(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.hgetAll falid", e);
        }
        return result;
    }

    /**
     * 返回哈希表 key 中，所有的域和值。 在返回值里，紧跟每个域名(field
     * name)之后是域的值(value)，所以返回值的长度是哈希表大小的两倍。
     * <p>
     * 返回值： 以列表形式返回哈希表的域和域的值。 若 key 不存在，返回空列表。
     *
     * @param key
     * @return
     */
    public static Map<byte[], byte[]> hgetAll(byte[] key) {
        Map<byte[], byte[]> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hgetAll(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.hgetAll falid", e);
        }
        return result;
    }

    /**
     * 删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略。
     * <p>
     * 返回值: 被成功移除的域的数量，不包括被忽略的域。
     *
     * @param key
     * @param fields
     * @return
     */
    public static long hdel(String key, String... fields) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hdel(key, fields);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.hdel falid", e);
        }
        return result;
    }

    /**
     * 删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略。
     * <p>
     * 返回值: 被成功移除的域的数量，不包括被忽略的域。
     *
     * @param key
     * @param fields
     * @return
     */
    public static long hdel(byte[] key, byte[]... fields) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hdel(key, fields);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.hdel falid", e);
        }
        return result;
    }

    /**
     * 返回哈希表 key 中域的数量。
     * <p>
     * 返回值： 哈希表中域的数量。 当 key 不存在时，返回 0 。
     *
     * @param key
     * @return
     */
    public static long hlen(String key) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hlen(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.hlen falid", e);
        }
        return result;
    }

    /**
     * 返回哈希表 key 中域的数量。
     * <p>
     * 返回值： 哈希表中域的数量。 当 key 不存在时，返回 0 。
     *
     * @param key
     * @return
     */
    public static long hlen(byte[] key) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hlen(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.hlen falid", e);
        }
        return result;
    }

    /**
     * 查看哈希表 key 中，给定域 field 是否存在。
     * <p>
     * 返回值： 如果哈希表含有给定域，返回 1 。 如果哈希表不含有给定域，或 key 不存在，返回 0 。
     *
     * @param key
     * @param field
     * @return
     */
    public static boolean hexists(String key, String field) {
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hexists(key, field);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.hexists falid", e);
        }
        return result;
    }

    /**
     * 查看哈希表 key 中，给定域 field 是否存在。
     * <p>
     * 返回值： 如果哈希表含有给定域，返回 1 。 如果哈希表不含有给定域，或 key 不存在，返回 0 。
     *
     * @param key
     * @param field
     * @return
     */
    public static boolean hexists(byte[] key, byte[] field) {
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hexists(key, field);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.hexists falid", e);
        }
        return result;
    }

    /**
     * 为哈希表 key 中的域 field 的值加上增量 increment 。 增量也可以为负数，相当于对给定域进行减法操作。 如果 key
     * 不存在，一个新的哈希表被创建并执行 HINCRBY 命令。 如果域 field 不存在，那么在执行命令前，域的值被初始化为 0 。
     * 对一个储存字符串值的域 field 执行 HINCRBY 命令将造成一个错误。 本操作的值被限制在 64 位(bit)有符号数字表示之内。
     * <p>
     * 返回值： 执行 HINCRBY 命令之后，哈希表 key 中域 field 的值。
     *
     * @param key
     * @param field
     * @param value
     * @return
     */
    public static long hincrBy(String key, String field, long value) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hincrBy(key, field, value);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.hincrBy falid", e);
        }
        return result;
    }

    /**
     * 为哈希表 key 中的域 field 的值加上增量 increment 。 增量也可以为负数，相当于对给定域进行减法操作。 如果 key
     * 不存在，一个新的哈希表被创建并执行 HINCRBY 命令。 如果域 field 不存在，那么在执行命令前，域的值被初始化为 0 。
     * 对一个储存字符串值的域 field 执行 HINCRBY 命令将造成一个错误。 本操作的值被限制在 64 位(bit)有符号数字表示之内。
     * <p>
     * 返回值： 执行 HINCRBY 命令之后，哈希表 key 中域 field 的值。
     *
     * @param key
     * @param field
     * @param value
     * @return
     */
    public static long hincrBy(byte[] key, byte[] field, long value) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hincrBy(key, field, value);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.hincrBy falid", e);
        }
        return result;
    }

    /**
     * 返回哈希表 key 中的所有域。
     * <p>
     * 返回值： 一个包含哈希表中所有域的表。 当 key 不存在时，返回一个空表。
     *
     * @param key
     * @return
     */
    public static Set<String> hkeys(String key) {
        Set<String> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hkeys(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.hkeys falid", e);
        }
        return result;
    }

    /**
     * 返回哈希表 key 中的所有域。
     * <p>
     * 返回值： 一个包含哈希表中所有域的表。 当 key 不存在时，返回一个空表。
     *
     * @param key
     * @return
     */
    public static Set<byte[]> hkeys(byte[] key) {
        Set<byte[]> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hkeys(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.hkeys falid", e);
        }
        return result;
    }

    /**
     * 返回哈希表 key 中所有域的值。
     * <p>
     * 返回值： 一个包含哈希表中所有值的表。 当 key 不存在时，返回一个空表。
     *
     * @param key
     * @return
     */
    public static List<String> hvals(String key) {
        List<String> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hvals(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.hvals falid", e);
        }
        return result;
    }

    /**
     * 返回哈希表 key 中所有域的值。
     * <p>
     * 返回值： 一个包含哈希表中所有值的表。 当 key 不存在时，返回一个空表。
     *
     * @param key
     * @return
     */
    public static Collection<byte[]> hvals(byte[] key) {
        Collection<byte[]> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hvals(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.hvals falid", e);
        }
        return result;
    }

    /* ==========================对Set(集合)操作====================== */

    /**
     * 将一个或多个 member 元素加入到集合 key 当中，已经存在于集合的 member 元素将被忽略。 假如 key 不存在，则创建一个只包含
     * member 元素作成员的集合。 当 key 不是集合类型时，返回一个错误。
     * <p>
     * 返回值: 被添加到集合中的新元素的数量，不包括被忽略的元素。
     *
     * @param key
     * @param members
     * @return
     */
    public static long sadd(String key, String... members) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.sadd(key, members);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.sadd falid", e);
        }
        return result;
    }

    /**
     * 将一个或多个 member 元素加入到集合 key 当中，已经存在于集合的 member 元素将被忽略。 假如 key 不存在，则创建一个只包含
     * member 元素作成员的集合。 当 key 不是集合类型时，返回一个错误。
     * <p>
     * 返回值: 被添加到集合中的新元素的数量，不包括被忽略的元素。
     *
     * @param key
     * @param members
     * @return
     */
    public static long sadd(byte[] key, byte[]... members) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.sadd(key, members);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.sadd falid", e);
        }
        return result;
    }

    /**
     * 移除集合 key 中的一个或多个 member 元素，不存在的 member 元素会被忽略。 当 key 不是集合类型，返回一个错误。
     * <p>
     * 返回值: 被成功移除的元素的数量，不包括被忽略的元素。
     *
     * @param key
     * @param members
     * @return
     */
    public static long srem(String key, String... members) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.srem(key, members);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.srem falid", e);
        }
        return result;
    }

    /**
     * 移除集合 key 中的一个或多个 member 元素，不存在的 member 元素会被忽略。 当 key 不是集合类型，返回一个错误。
     * <p>
     * 返回值: 被成功移除的元素的数量，不包括被忽略的元素。
     *
     * @param key
     * @param members
     * @return
     */
    public static long srem(byte[] key, byte[]... members) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.srem(key, members);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.srem falid", e);
        }
        return result;
    }

    /**
     * 返回集合 key 中的所有成员。 不存在的 key 被视为空集合。
     * <p>
     * 返回值: 集合中的所有成员。
     *
     * @param key
     * @return
     */
    public static Set<String> smembers(String key) {
        Set<String> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.smembers(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.smembers falid", e);
        }
        return result;
    }

    /**
     * 返回集合 key 中的所有成员。 不存在的 key 被视为空集合。
     * <p>
     * 返回值: 集合中的所有成员。
     *
     * @param key
     * @return
     */
    public static Set<byte[]> smembers(byte[] key) {
        Set<byte[]> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.smembers(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.smembers falid", e);
        }
        return result;
    }

    /**
     * 判断 member 元素是否集合 key 的成员。
     * <p>
     * 返回值: 如果 member 元素是集合的成员，返回 1 。 如果 member 元素不是集合的成员，或 key 不存在，返回 0 。
     *
     * @param key
     * @param member
     * @return
     */
    public static boolean sismember(String key, String member) {
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.sismember(key, member);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.sismember falid", e);
        }
        return result;
    }

    /**
     * 判断 member 元素是否集合 key 的成员。
     * <p>
     * 返回值: 如果 member 元素是集合的成员，返回 1 。 如果 member 元素不是集合的成员，或 key 不存在，返回 0 。
     *
     * @param key
     * @param member
     * @return
     */
    public static boolean sismember(byte[] key, byte[] member) {
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.sismember(key, member);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.sismember falid", e);
        }
        return result;
    }

    /**
     * 返回集合 key 的基数(集合中元素的数量)。
     * <p>
     * 返回值： 集合的基数。 当 key 不存在时，返回 0 。
     *
     * @param key
     * @return
     */
    public static long scard(String key) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.scard(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.scard falid", e);
        }
        return result;
    }

    /**
     * 返回集合 key 的基数(集合中元素的数量)。
     * <p>
     * 返回值： 集合的基数。 当 key 不存在时，返回 0 。
     *
     * @param key
     * @return
     */
    public static long scard(byte[] key) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.scard(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.scard falid", e);
        }
        return result;
    }

    /**
     * 移除并返回集合中的一个随机元素。
     * <p>
     * 返回值: 被移除的随机元素。 当 key 不存在或 key 是空集时，返回 nil 。
     *
     * @param key
     * @return
     */
    public static String spop(String key) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.spop(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.spop falid", e);
        }
        return result;
    }

    /**
     * 移除并返回集合中的一个随机元素。
     * <p>
     * 返回值: 被移除的随机元素。 当 key 不存在或 key 是空集时，返回 nil 。
     *
     * @param key
     * @return
     */
    public static byte[] spop(byte[] key) {
        byte[] result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.spop(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.spop falid", e);
        }
        return result;
    }

    /**
     * 如果命令执行时，只提供了 key 参数，那么返回集合中的一个随机元素。该操作和 SPOP 相似，但 SPOP 将随机元素从集合中移除并返回，而
     * SRANDMEMBER 则仅仅返回随机元素，而不对集合进行任何改动。
     * <p>
     * 返回值: 只提供 key 参数时，返回一个元素；如果集合为空，返回 nil 。 如果提供了 count
     * 参数，那么返回一个数组；如果集合为空，返回空数组。
     *
     * @param key
     * @return
     */
    public static String srandmember(String key) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.srandmember(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.srandmember falid", e);
        }
        return result;
    }

    /**
     * 如果命令执行时，只提供了 key 参数，那么返回集合中的一个随机元素。该操作和 SPOP 相似，但 SPOP 将随机元素从集合中移除并返回，而
     * SRANDMEMBER 则仅仅返回随机元素，而不对集合进行任何改动。
     * <p>
     * 返回值: 只提供 key 参数时，返回一个元素；如果集合为空，返回 nil 。 如果提供了 count
     * 参数，那么返回一个数组；如果集合为空，返回空数组。
     *
     * @param key
     * @return
     */
    public static byte[] srandmember(byte[] key) {
        byte[] result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.srandmember(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.srandmember falid", e);
        }
        return result;
    }

    /* ==========================对List(列表)操作====================== */

    /**
     * 将一个或多个值 value 插入到列表 key 的表头 如果有多个 value 值，那么各个 value
     * 值按从左到右的顺序依次插入到表头LPUSH mylist a b c ，列表的值将是 c b a;
     * <p>
     * 返回值： 执行 LPUSH 命令后，列表的长度。
     *
     * @param key
     * @param values
     * @return
     */
    public static long lpush(String key, String... values) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.lpush(key, values);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.lpush falid", e);
        }
        return result;
    }

    /**
     * 将一个或多个值 value 插入到列表 key 的表头 如果有多个 value 值，那么各个 value
     * 值按从左到右的顺序依次插入到表头LPUSH mylist a b c ，列表的值将是 c b a;
     * <p>
     * 返回值： 执行 LPUSH 命令后，列表的长度。
     *
     * @param key
     * @param values
     * @return
     */
    public static long lpush(byte[] key, byte[]... values) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.lpush(key, values);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.lpush falid", e);
        }
        return result;
    }

    /**
     * 将值 value 插入到列表 key 的表头，当且仅当 key 存在并且是一个列表。当 key 不存在时， LPUSHX 命令什么也不做。
     * <p>
     * 返回值： LPUSHX 命令执行之后，表的长度。
     *
     * @param key
     * @param value
     * @return
     */
    public static long lpushx(String key, String value) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.lpushx(key, value);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.lpushx falid", e);
        }
        return result;
    }

    /**
     * 将值 value 插入到列表 key 的表头，当且仅当 key 存在并且是一个列表。当 key 不存在时， LPUSHX 命令什么也不做。
     * <p>
     * 返回值： LPUSHX 命令执行之后，表的长度。
     *
     * @param key
     * @param value
     * @return
     */
    public static long lpushx(byte[] key, byte[] value) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.lpushx(key, value);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.lpushx falid", e);
        }
        return result;
    }

    /**
     * 将一个或多个值 value 插入到列表 key 的表尾(最右边)。 如果有多个 value 值，那么各个 value
     * 值按从左到右的顺序依次插入到表尾：比如对一个空列表 mylist 执行 RPUSH mylist a b c ，得出的结果列表为 a b c。如果
     * key 不存在，一个空列表会被创建并执行 RPUSH 操作。 当 key 存在但不是列表类型时，返回一个错误。
     * <p>
     * 返回值： 执行 RPUSH 操作后，表的长度。
     *
     * @param key
     * @param values
     * @return
     */
    public static long rpush(String key, String... values) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.rpush(key, values);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.rpush falid", e);
        }
        return result;
    }

    /**
     * 将一个或多个值 value 插入到列表 key 的表尾(最右边)。 如果有多个 value 值，那么各个 value
     * 值按从左到右的顺序依次插入到表尾：比如对一个空列表 mylist 执行 RPUSH mylist a b c ，得出的结果列表为 a b c。如果
     * key 不存在，一个空列表会被创建并执行 RPUSH 操作。 当 key 存在但不是列表类型时，返回一个错误。
     * <p>
     * 返回值： 执行 RPUSH 操作后，表的长度。
     *
     * @param key
     * @param values
     * @return
     */
    public static long rpush(byte[] key, byte[]... values) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.rpush(key, values);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.rpush falid", e);
        }
        return result;
    }

    /**
     * 将值 value 插入到列表 key 的表尾，当且仅当 key 存在并且是一个列表。 和 RPUSH 命令相反，当 key 不存在时，
     * RPUSHX 命令什么也不做。
     * <p>
     * 返回值： RPUSHX 命令执行之后，表的长度。
     *
     * @param key
     * @param value
     * @return
     */
    public static long rpushx(String key, String value) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.rpushx(key, value);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.rpushx falid", e);
        }
        return result;
    }

    /**
     * 将值 value 插入到列表 key 的表尾，当且仅当 key 存在并且是一个列表。 和 RPUSH 命令相反，当 key 不存在时，
     * RPUSHX 命令什么也不做。
     * <p>
     * 返回值： RPUSHX 命令执行之后，表的长度。
     *
     * @param key
     * @param value
     * @return
     */
    public static long rpushx(byte[] key, byte[] value) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.rpushx(key, value);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.rpushx falid", e);
        }
        return result;
    }

    /**
     * 移除并返回列表 key 的头元素。
     * <p>
     * 返回值： 列表的头元素。 当 key 不存在时，返回 nil 。
     *
     * @param key
     * @return
     */
    public static String lpop(String key) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.lpop(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.lpop falid", e);
        }
        return result;
    }

    /**
     * 移除并返回列表 key 的头元素。
     * <p>
     * 返回值： 列表的头元素。 当 key 不存在时，返回 nil 。
     *
     * @param key
     * @return
     */
    public static byte[] lpop(byte[] key) {
        byte[] result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.lpop(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.lpop falid", e);
        }
        return result;
    }

    /**
     * 移除并返回列表 key 的尾元素。
     * <p>
     * 返回值： 列表的尾元素。 当 key 不存在时，返回 nil 。
     *
     * @param key
     * @return
     */
    public static String rpop(String key) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.rpop(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.rpop falid", e);
        }
        return result;
    }

    public static List<String> brpop(int timeout, String key) {
        List<String> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.brpop(timeout, new String[]{key});
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.rpop falid", e);
        }
        return result;
    }

    /**
     * 移除并返回列表 key 的尾元素。
     * <p>
     * 返回值： 列表的尾元素。 当 key 不存在时，返回 nil 。
     *
     * @param key
     * @return
     */
    public static byte[] rpop(byte[] key) {
        byte[] result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.rpop(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.rpop falid", e);
        }
        return result;
    }

    /**
     * 返回列表 key 的长度。 如果 key 不存在，则 key 被解释为一个空列表，返回 0 . 如果 key 不是列表类型，返回一个错误。
     * <p>
     * 返回值： 列表 key 的长度。
     *
     * @param key
     * @return
     */
    public static long llen(String key) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.llen(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.llen falid", e);
        }
        return result;
    }

    /**
     * 返回列表 key 的长度。 如果 key 不存在，则 key 被解释为一个空列表，返回 0 . 如果 key 不是列表类型，返回一个错误。
     * <p>
     * 返回值： 列表 key 的长度。
     *
     * @param key
     * @return
     */
    public static long llen(byte[] key) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.llen(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.llen falid", e);
        }
        return result;
    }

    /**
     * 返回列表 key 中指定区间内的元素，区间以偏移量 start 和 stop 指定。
     * <p>
     * 下标(index)参数 start 和 stop 都以 0 为底，也就是说，以 0 表示列表的第一个元素，以 1 表示列表的第二个元素，以此类推。
     * 你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推。 stop 下标也在 LRANGE
     * 命令的取值范围之内(闭区间)。超出范围的下标值不会引起错误。
     * <p>
     * 返回值: 一个列表，包含指定区间内的元素。
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static List<String> lrange(String key, long start, long end) {
        List<String> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.lrange(key, start, end);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.lrange falid", e);
        }
        return result;
    }

    /**
     * 返回列表 key 中指定区间内的元素，区间以偏移量 start 和 stop 指定。
     * <p>
     * 下标(index)参数 start 和 stop 都以 0 为底，也就是说，以 0 表示列表的第一个元素，以 1 表示列表的第二个元素，以此类推。
     * 你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推。 stop 下标也在 LRANGE
     * 命令的取值范围之内(闭区间)。超出范围的下标值不会引起错误。
     * <p>
     * 返回值: 一个列表，包含指定区间内的元素。
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static List<byte[]> lrange(byte[] key, int start, int end) {
        List<byte[]> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.lrange(key, start, end);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.lrange falid", e);
        }
        return result;
    }

    /**
     * 根据参数 count 的值，移除列表中与参数 value 相等的元素。
     * <p>
     * count 的值可以是以下几种： count > 0 : 从表头开始向表尾搜索，移除与 value 相等的元素，数量为 count 。 count
     * < 0 : 从表尾开始向表头搜索，移除与 value 相等的元素，数量为 count 的绝对值。 count = 0 : 移除表中所有与
     * value 相等的值。
     * <p>
     * 返回值： 被移除元素的数量。 因为不存在的 key 被视作空表(empty list)，所以当 key 不存在时， LREM 命令总是返回 0 。
     *
     * @param key
     * @param count
     * @param value
     * @return
     */
    public static long lrem(String key, long count, String value) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.lrem(key, count, value);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.lrem falid", e);
        }
        return result;
    }

    /**
     * 根据参数 count 的值，移除列表中与参数 value 相等的元素。
     * <p>
     * count 的值可以是以下几种： count > 0 : 从表头开始向表尾搜索，移除与 value 相等的元素，数量为 count 。 count
     * < 0 : 从表尾开始向表头搜索，移除与 value 相等的元素，数量为 count 的绝对值。 count = 0 : 移除表中所有与
     * value 相等的值。
     * <p>
     * 返回值： 被移除元素的数量。 因为不存在的 key 被视作空表(empty list)，所以当 key 不存在时， LREM 命令总是返回 0 。
     *
     * @param key
     * @param count
     * @param value
     * @return
     */
    public static long lrem(byte[] key, int count, byte[] value) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.lrem(key, count, value);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.lrem falid", e);
        }
        return result;
    }

    /**
     * 将列表 key 下标为 index 的元素的值设置为 value 。
     * <p>
     * 当 index 参数超出范围，或对一个空列表( key 不存在)进行 LSET 时，返回一个错误。
     * <p>
     * 返回值： 操作成功返回 ok ，否则返回错误信息。
     *
     * @param key
     * @param index
     * @param value
     * @return
     */
    public static boolean lset(String key, long index, String value) {
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getResource();
            String status = jedis.lset(key, index, value);
            if ("OK".equalsIgnoreCase(status)) {
                result = true;
            }
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.lset falid", e);
        }
        return result;
    }

    /**
     * 将列表 key 下标为 index 的元素的值设置为 value 。
     * <p>
     * 当 index 参数超出范围，或对一个空列表( key 不存在)进行 LSET 时，返回一个错误。
     * <p>
     * 返回值： 操作成功返回 ok ，否则返回错误信息。
     *
     * @param key
     * @param index
     * @param value
     * @return
     */
    public static boolean lset(byte[] key, int index, byte[] value) {
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getResource();
            String status = jedis.lset(key, index, value);
            if ("OK".equalsIgnoreCase(status)) {
                result = true;
            }
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.lset falid", e);
        }
        return result;
    }

    /**
     * 对一个列表进行修剪(trim)，就是说，让列表只保留指定区间内的元素，不在指定区间之内的元素都将被删除。 举个例子，执行命令 LTRIM list
     * 0 2 ，表示只保留列表 list 的前三个元素，其余元素全部删除。
     * <p>
     * 下标(index)参数 start 和 stop 都以 0 为底，也就是说，以 0 表示列表的第一个元素，以 1 表示列表的第二个元素，以此类推。
     * 你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推。 当 key
     * 不是列表类型时，返回一个错误。超出范围的下标值不会引起错误。
     * <p>
     * 返回值: 命令执行成功时，返回 ok 。
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static boolean ltrim(String key, long start, long end) {
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getResource();
            String status = jedis.ltrim(key, start, end);
            if ("OK".equalsIgnoreCase(status)) {
                result = true;
            }
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.ltrim falid", e);
        }
        return result;
    }

    /**
     * 对一个列表进行修剪(trim)，就是说，让列表只保留指定区间内的元素，不在指定区间之内的元素都将被删除。 举个例子，执行命令 LTRIM list
     * 0 2 ，表示只保留列表 list 的前三个元素，其余元素全部删除。
     * <p>
     * 下标(index)参数 start 和 stop 都以 0 为底，也就是说，以 0 表示列表的第一个元素，以 1 表示列表的第二个元素，以此类推。
     * 你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推。 当 key
     * 不是列表类型时，返回一个错误。超出范围的下标值不会引起错误。
     * <p>
     * 返回值: 命令执行成功时，返回 ok 。
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static boolean ltrim(byte[] key, int start, int end) {
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getResource();
            String status = jedis.ltrim(key, start, end);
            if ("OK".equalsIgnoreCase(status)) {
                result = true;
            }
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.ltrim falid", e);
        }
        return result;
    }

    /**
     * 返回列表 key 中，下标为 index 的元素。
     * <p>
     * 下标(index)参数 start 和 stop 都以 0 为底，也就是说，以 0 表示列表的第一个元素，以 1 表示列表的第二个元素，以此类推。
     * 你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推。 如果 key 不是列表类型，返回一个错误。
     * <p>
     * 返回值: 列表中下标为 index 的元素。 如果 index 参数的值不在列表的区间范围内(out of range)，返回 nil 。
     *
     * @param key
     * @param index
     * @return
     */
    public static String lindex(String key, long index) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.lindex(key, index);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.lindex falid", e);
        }
        return result;
    }

    /**
     * 返回列表 key 中，下标为 index 的元素。
     * <p>
     * 下标(index)参数 start 和 stop 都以 0 为底，也就是说，以 0 表示列表的第一个元素，以 1 表示列表的第二个元素，以此类推。
     * 你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推。 如果 key 不是列表类型，返回一个错误。
     * <p>
     * 返回值: 列表中下标为 index 的元素。 如果 index 参数的值不在列表的区间范围内(out of range)，返回 nil 。
     *
     * @param key
     * @param index
     * @return
     */
    public static byte[] lindex(byte[] key, int index) {
        byte[] result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.lindex(key, index);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.lindex falid", e);
        }
        return result;
    }

    /**
     * 将值 value 插入到列表 key 当中，位于值 pivot 之前或之后。
     * <p>
     * 当 pivot 不存在于列表 key 时，不执行任何操作。 当 key 不存在时， key 被视为空列表，不执行任何操作。 如果 key
     * 不是列表类型，返回一个错误。
     * <p>
     * 返回值: 如果命令执行成功，返回插入操作完成之后，列表的长度。 如果没有找到 pivot ，返回 -1 。 如果 key 不存在或为空列表，返回
     * 0 。
     *
     * @param key
     * @param where
     * @param pivot
     * @param value
     * @return
     */
    public static long linsert(String key, BinaryClient.LIST_POSITION where, String pivot, String value) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.linsert(key, where, pivot, value);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.linsert falid", e);
        }
        return result;
    }

    /**
     * 将值 value 插入到列表 key 当中，位于值 pivot 之前或之后。
     * <p>
     * 当 pivot 不存在于列表 key 时，不执行任何操作。 当 key 不存在时， key 被视为空列表，不执行任何操作。 如果 key
     * 不是列表类型，返回一个错误。
     * <p>
     * 返回值: 如果命令执行成功，返回插入操作完成之后，列表的长度。 如果没有找到 pivot ，返回 -1 。 如果 key 不存在或为空列表，返回
     * 0 。
     *
     * @param key
     * @param where
     * @param pivot
     * @param value
     * @return
     */
    public static long linsert(byte[] key, BinaryClient.LIST_POSITION where, byte[] pivot, byte[] value) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.linsert(key, where, pivot, value);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.linsert falid", e);
        }
        return result;
    }

    /* ==========================对Sorted set(有序集)操作====================== */

    /**
     * 将一个member 元素及其 score 值加入到有序集 key 当中。
     * <p>
     * 如果某个 member 已经是有序集的成员，那么更新这个 member 的 score 值，并通过重新插入这个 member 元素，来保证该
     * member 在正确的位置上。 score 值可以是整数值或双精度浮点数。 如果 key 不存在，则创建一个空的有序集并执行 ZADD 操作。 当
     * key 存在但不是有序集类型时，返回一个错误。
     * <p>
     * 返回值: 被成功添加的新成员的数量，不包括那些被更新的、已经存在的成员。
     *
     * @param key
     * @param score
     * @param member
     * @return
     */
    public static long zadd(String key, double score, String member) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zadd(key, score, member);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zadd falid", e);
        }
        return result;
    }

    /**
     * 将一个member 元素及其 score 值加入到有序集 key 当中。
     * <p>
     * 如果某个 member 已经是有序集的成员，那么更新这个 member 的 score 值，并通过重新插入这个 member 元素，来保证该
     * member 在正确的位置上。 score 值可以是整数值或双精度浮点数。 如果 key 不存在，则创建一个空的有序集并执行 ZADD 操作。 当
     * key 存在但不是有序集类型时，返回一个错误。
     * <p>
     * 返回值: 被成功添加的新成员的数量，不包括那些被更新的、已经存在的成员。
     *
     * @param key
     * @param score
     * @param member
     * @return
     */
    public static long zadd(byte[] key, double score, byte[] member) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zadd(key, score, member);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zadd falid", e);
        }
        return result;
    }

    /**
     * 将多个member 元素及其 score 值加入到有序集 key 当中。
     * <p>
     * 如果某个 member 已经是有序集的成员，那么更新这个 member 的 score 值，并通过重新插入这个 member 元素，来保证该
     * member 在正确的位置上。 score 值可以是整数值或双精度浮点数。 如果 key 不存在，则创建一个空的有序集并执行 ZADD 操作。 当
     * key 存在但不是有序集类型时，返回一个错误。
     * <p>
     * 返回值: 被成功添加的新成员的数量，不包括那些被更新的、已经存在的成员。
     *
     * @param key
     * @param scoreMembers
     * @return
     */
    public static long zadd(String key, Map<String, Double> scoreMembers) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zadd(key, scoreMembers);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zadd falid", e);
        }
        return result;
    }

    /**
     * 将多个member 元素及其 score 值加入到有序集 key 当中。
     * <p>
     * 如果某个 member 已经是有序集的成员，那么更新这个 member 的 score 值，并通过重新插入这个 member 元素，来保证该
     * member 在正确的位置上。 score 值可以是整数值或双精度浮点数。 如果 key 不存在，则创建一个空的有序集并执行 ZADD 操作。 当
     * key 存在但不是有序集类型时，返回一个错误。
     * <p>
     * 返回值: 被成功添加的新成员的数量，不包括那些被更新的、已经存在的成员。
     *
     * @param key
     * @param scoreMembers
     * @return
     */
    public static long zadd(byte[] key, Map<byte[], Double> scoreMembers) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zadd(key, scoreMembers);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zadd falid", e);
        }
        return result;
    }

    /**
     * 移除有序集 key 中的一个或多个成员，不存在的成员将被忽略。 当 key 存在但不是有序集类型时，返回一个错误。
     * <p>
     * 返回值: 被成功移除的成员的数量，不包括被忽略的成员。
     *
     * @param key
     * @param members
     * @return
     */
    public static long zrem(String key, String... members) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zrem(key, members);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zrem falid", e);
        }
        return result;
    }

    /**
     * 移除有序集 key 中的一个或多个成员，不存在的成员将被忽略。 当 key 存在但不是有序集类型时，返回一个错误。
     * <p>
     * 返回值: 被成功移除的成员的数量，不包括被忽略的成员。
     *
     * @param key
     * @param members
     * @return
     */
    public static long zrem(byte[] key, byte[]... members) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zrem(key, members);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zrem falid", e);
        }
        return result;
    }

    /**
     * 返回有序集 key 的集合中的数量。
     * <p>
     * 返回值: 当 key 存在且是有序集类型时，返回有序集的基数。 当 key 不存在时，返回 0 。
     *
     * @param key
     * @return
     */
    public static long zcard(String key) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zcard(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zcard falid", e);
        }
        return result;
    }

    /**
     * 返回有序集 key 的集合中的数量。
     * <p>
     * 返回值: 当 key 存在且是有序集类型时，返回有序集的基数。 当 key 不存在时，返回 0 。
     *
     * @param key
     * @return
     */
    public static long zcard(byte[] key) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zcard(key);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zcard falid", e);
        }
        return result;
    }

    /**
     * 返回有序集 key 中， score 值在 min 和 max 之间(默认包括 score 值等于 min 或 max )的成员的数量。
     * <p>
     * 返回值: score 值在 min 和 max 之间的成员的数量。
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public static long zcount(String key, double min, double max) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zcount(key, min, max);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zcount falid", e);
        }
        return result;
    }

    /**
     * 返回有序集 key 中， score 值在 min 和 max 之间(默认包括 score 值等于 min 或 max )的成员的数量。
     * <p>
     * 返回值: score 值在 min 和 max 之间的成员的数量。
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public static long zcount(byte[] key, double min, double max) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zcount(key, min, max);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zcount falid", e);
        }
        return result;
    }

    /**
     * 返回有序集 key 中， member的score值在minmember和maxmember的score值之间(默认包括
     * member的score值等于minmember或maxmemberscore值)的成员的数量。
     * <p>
     * 返回值: member的score值在minmember和maxmember的score值之间的成员的数量。
     *
     * @param key
     * @param minmember
     * @param maxmember
     * @return
     */
    public static long zcount(String key, String minmember, String maxmember) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zcount(key, minmember, maxmember);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zcount falid", e);
        }
        return result;
    }

    /**
     * 返回有序集 key 中， member的score值在minmember和maxmember的score值之间(默认包括
     * member的score值等于minmember或maxmemberscore值)的成员的数量。
     * <p>
     * 返回值: member的score值在minmember和maxmember的score值之间的成员的数量。
     *
     * @param key
     * @param minmember
     * @param maxmember
     * @return
     */
    public static long zcount(byte[] key, byte[] minmember, byte[] maxmember) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zcount(key, minmember, maxmember);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zcount falid", e);
        }
        return result;
    }

    /**
     * 返回有序集 key 中，成员 member 的 score 值。如果 member 元素不是有序集 key 的成员，或 key 不存在，返回
     * nil 。
     * <p>
     * 返回值: member 成员的 score 值，以字符串形式表示。
     *
     * @param key
     * @param member
     * @return
     */
    public static double zscore(String key, String member) {
        double result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zscore(key, member) == null ? 0 : jedis.zscore(key, member);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zscore falid", e);
        }
        return result;
    }

    /**
     * 返回有序集 key 中，成员 member 的 score 值。如果 member 元素不是有序集 key 的成员，或 key 不存在，返回
     * nil 。
     * <p>
     * 返回值: member 成员的 score 值，以字符串形式表示。
     *
     * @param key
     * @param member
     * @return
     */
    public static double zscore(byte[] key, byte[] member) {
        double result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zscore(key, member);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zscore falid", e);
        }
        return result;
    }

    /**
     * 为有序集 key 的成员 member 的 score 值加上增量 increment 。
     * <p>
     * 可以通过传递一个负数值 increment ，让 score 减去相应的值，比如 ZINCRBY key -5 member ，就是让
     * member 的 score 值减去 5 。 当 key 不存在，或 member 不是 key 的成员时， ZINCRBY key
     * increment member 等同于 ZADD key increment member 。 当 key 不是有序集类型时，返回一个错误。
     * score 值可以是整数值或双精度浮点数。
     * <p>
     * 返回值: member 成员的新 score 值，以字符串形式表示。
     *
     * @param key
     * @param score
     * @param member
     * @return
     */
    public static double zincrby(String key, double score, String member) {
        double result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zincrby(key, score, member);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zincrby falid", e);
        }
        return result;
    }

    /**
     * 为有序集 key 的成员 member 的 score 值加上增量 increment 。
     * <p>
     * 可以通过传递一个负数值 increment ，让 score 减去相应的值，比如 ZINCRBY key -5 member ，就是让
     * member 的 score 值减去 5 。 当 key 不存在，或 member 不是 key 的成员时， ZINCRBY key
     * increment member 等同于 ZADD key increment member 。 当 key 不是有序集类型时，返回一个错误。
     * score 值可以是整数值或双精度浮点数。
     * <p>
     * 返回值: member 成员的新 score 值，以字符串形式表示。
     *
     * @param key
     * @param score
     * @param member
     * @return
     */
    public static double zincrby(byte[] key, double score, byte[] member) {
        double result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zincrby(key, score, member);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zincrby falid", e);
        }
        return result;
    }

    /**
     * 返回有序集 key 中，指定区间内的成员。 其中成员的位置按 score 值递增(从小到大)来排序。 具有相同 score
     * 值的成员按字典序(lexicographical order )来排列。如果你需要成员按 score 值递减(从大到小)来排列，请使用
     * ZREVRANGE 命令。
     * <p>
     * 下标参数 start 和 stop 都以 0 为底，也就是说，以 0 表示有序集第一个成员，以 1 表示有序集第二个成员，以此类推。
     * 你也可以使用负数下标，以 -1 表示最后一个成员， -2 表示倒数第二个成员，以此类推。 超出范围的下标并不会引起错误。
     * <p>
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static Set<String> zrange(String key, long start, long end) {
        Set<String> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zrange(key, start, end);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zrange falid", e);
        }
        return result;
    }

    /**
     * 返回有序集 key 中，指定区间内的成员。 其中成员的位置按 score 值递增(从小到大)来排序。 具有相同 score
     * 值的成员按字典序(lexicographical order )来排列。如果你需要成员按 score 值递减(从大到小)来排列，请使用
     * ZREVRANGE 命令。
     * <p>
     * 下标参数 start 和 stop 都以 0 为底，也就是说，以 0 表示有序集第一个成员，以 1 表示有序集第二个成员，以此类推。
     * 你也可以使用负数下标，以 -1 表示最后一个成员， -2 表示倒数第二个成员，以此类推。 超出范围的下标并不会引起错误。
     * <p>
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static Set<byte[]> zrange(byte[] key, int start, int end) {
        Set<byte[]> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zrange(key, start, end);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zrange falid", e);
        }
        return result;
    }

    /**
     * 返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。有序集成员按 score
     * 值递增(从小到大)次序排列。 具有相同 score 值的成员按字典序(lexicographical
     * order)来排列(该属性是有序集提供的，不需要额外的计算)。
     * <p>
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param key
     * @param max
     * @param min
     * @return
     */
    public static Set<String> zrangeByScore(String key, double min, double max) {
        Set<String> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zrangeByScore(key, min, max);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zrangeByScore falid", e);
        }
        return result;
    }

    /**
     * 返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。有序集成员按 score
     * 值递增(从小到大)次序排列。 具有相同 score 值的成员按字典序(lexicographical
     * order)来排列(该属性是有序集提供的，不需要额外的计算)。
     * <p>
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public static Set<byte[]> zrangeByScore(byte[] key, double min, double max) {
        Set<byte[]> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zrangeByScore(key, min, max);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zrangeByScore falid", e);
        }
        return result;
    }

    /**
     * 返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。有序集成员按 score
     * 值递增(从小到大)次序排列。 具有相同 score 值的成员按字典序(lexicographical
     * order)来排列(该属性是有序集提供的，不需要额外的计算)。
     * <p>
     * 可选的 LIMIT 参数指定返回结果的数量及区间(就像SQL中的 SELECT LIMIT offset, count )，注意当 offset
     * 很大时，定位 offset 的操作可能需要遍历整个有序集，此过程最坏复杂度为 O(N) 时间。
     * <p>
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param key
     * @param min
     * @param max
     * @param offset
     * @param count
     * @return
     */
    public static Set<String> zrangeByScore(String key, double min, double max, int offset, int count) {
        Set<String> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zrangeByScore(key, min, max, offset, count);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zrangeByScore falid", e);
        }
        return result;
    }

    /**
     * 返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。有序集成员按 score
     * 值递增(从小到大)次序排列。 具有相同 score 值的成员按字典序(lexicographical
     * order)来排列(该属性是有序集提供的，不需要额外的计算)。
     * <p>
     * 可选的 LIMIT 参数指定返回结果的数量及区间(就像SQL中的 SELECT LIMIT offset, count )，注意当 offset
     * 很大时，定位 offset 的操作可能需要遍历整个有序集，此过程最坏复杂度为 O(N) 时间。
     * <p>
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param key
     * @param min
     * @param max
     * @param offset
     * @param count
     * @return
     */
    public static Set<byte[]> zrangeByScore(byte[] key, double min, double max, int offset, int count) {
        Set<byte[]> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zrangeByScore(key, min, max, offset, count);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zrangeByScore falid", e);
        }
        return result;
    }

    /**
     * 返回有序集 key 中，所有 member的score 值介于 minmember 和 maxmember 的score 值之间(包括等于
     * minmember 或 maxmember 的score 值 )的成员。有序集成员按 score 值递增(从小到大)次序排列。 具有相同
     * score 值的成员按字典序(lexicographical order)来排列(该属性是有序集提供的，不需要额外的计算)。
     * <p>
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param key
     * @param minmember
     * @param maxmember
     * @return
     */
    public static Set<String> zrangeByScore(String key, String minmember, String maxmember) {
        Set<String> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zrangeByScore(key, minmember, maxmember);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zrangeByScore falid", e);
        }
        return result;
    }

    /**
     * 返回有序集 key 中，所有 member的score 值介于 minmember 和 maxmember 的score 值之间(包括等于
     * minmember 或 maxmember 的score 值 )的成员。有序集成员按 score 值递增(从小到大)次序排列。 具有相同
     * score 值的成员按字典序(lexicographical order)来排列(该属性是有序集提供的，不需要额外的计算)。
     * <p>
     * 可选的 LIMIT 参数指定返回结果的数量及区间(就像SQL中的 SELECT LIMIT offset, count )，注意当 offset
     * 很大时，定位 offset 的操作可能需要遍历整个有序集，此过程最坏复杂度为 O(N) 时间。
     * <p>
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param key
     * @param minmember
     * @param maxmember
     * @param offset
     * @param count
     * @return
     */
    public static Set<String> zrangeByScore(String key, String minmember, String maxmember, int offset, int count) {
        Set<String> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zrangeByScore(key, minmember, maxmember, offset, count);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zrangeByScore falid", e);
        }
        return result;
    }

    /**
     * 返回有序集 key 中， score 值介于 max 和 min 之间(默认包括等于 max 或 min )的所有的成员。有序集成员按 score
     * 值递减(从大到小)的次序排列。具有相同 score 值的成员按字典序的逆序(reverse lexicographical order )排列。
     * <p>
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param key
     * @param max
     * @param min
     * @return
     */
    public static Set<String> zrevrangeByScore(String key, double max, double min) {
        Set<String> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zrevrangeByScore(key, max, min);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zrevrangeByScore falid", e);
        }
        return result;
    }

    /**
     * 返回有序集 key 中， score 值介于 max 和 min 之间(默认包括等于 max 或 min )的所有的成员。有序集成员按 score
     * 值递减(从大到小)的次序排列。具有相同 score 值的成员按字典序的逆序(reverse lexicographical order )排列。
     * <p>
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public static Set<byte[]> zrevrangeByScore(byte[] key, double max, double min) {
        Set<byte[]> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zrevrangeByScore(key, max, min);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zrevrangeByScore falid", e);
        }
        return result;
    }

    /**
     * 返回有序集 key 中， score 值介于 max 和 min 之间(默认包括等于 max 或 min )的所有的成员。有序集成员按 score
     * 值递减(从大到小)的次序排列。具有相同 score 值的成员按字典序的逆序(reverse lexicographical order )排列。
     * <p>
     * 可选的 LIMIT 参数指定返回结果的数量及区间(就像SQL中的 SELECT LIMIT offset, count )，注意当 offset
     * 很大时，定位 offset 的操作可能需要遍历整个有序集，此过程最坏复杂度为 O(N) 时间。
     * <p>
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param key
     * @param min
     * @param max
     * @param offset
     * @param count
     * @return
     */
    public static Set<String> zrevrangeByScore(String key, double max, double min, int offset, int count) {
        Set<String> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zrevrangeByScore(key, max, min, offset, count);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zrevrangeByScore falid", e);
        }
        return result;
    }

    /**
     * 返回有序集 key 中， score 值介于 max 和 min 之间(默认包括等于 max 或 min )的所有的成员。有序集成员按 score
     * 值递减(从大到小)的次序排列。具有相同 score 值的成员按字典序的逆序(reverse lexicographical order )排列。
     * <p>
     * 可选的 LIMIT 参数指定返回结果的数量及区间(就像SQL中的 SELECT LIMIT offset, count )，注意当 offset
     * 很大时，定位 offset 的操作可能需要遍历整个有序集，此过程最坏复杂度为 O(N) 时间。
     * <p>
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param key
     * @param min
     * @param max
     * @param offset
     * @param count
     * @return
     */
    public static Set<byte[]> zrevrangeByScore(byte[] key, double max, double min, int offset, int count) {
        Set<byte[]> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zrevrangeByScore(key, max, min, offset, count);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zrevrangeByScore falid", e);
        }
        return result;
    }

    /**
     * 返回有序集 key 中，所有 member的score 值介于 的score 值之间(包括等于 maxmember 和 minmember
     * 的score 值 )的成员。有序集成员按 score 值递增(从大到小)次序排列。 具有相同 score 值的成员按字典逆序(reverse
     * lexicographical order )来排列(该属性是有序集提供的，不需要额外的计算)。
     * <p>
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param key
     * @param minmember
     * @param maxmember
     * @return
     */
    public static Set<String> zrevrangeByScore(String key, String maxmember, String minmember) {
        Set<String> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zrevrangeByScore(key, maxmember, minmember);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zrevrangeByScore falid", e);
        }
        return result;
    }

    /**
     * 返回有序集 key 中，所有 member的score 值介于 的score 值之间(包括等于 maxmember 和 minmember
     * 的score 值 )的成员。有序集成员按 score 值递增(从大到小)次序排列。 具有相同 score 值的成员按字典逆序(reverse
     * lexicographical order )来排列(该属性是有序集提供的，不需要额外的计算)。
     * <p>
     * 可选的 LIMIT 参数指定返回结果的数量及区间(就像SQL中的 SELECT LIMIT offset, count )，注意当 offset
     * 很大时，定位 offset 的操作可能需要遍历整个有序集，此过程最坏复杂度为 O(N) 时间。
     * <p>
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param key
     * @param minmember
     * @param maxmember
     * @param offset
     * @param count
     * @return
     */
    public static Set<String> zrevrangeByScore(String key, String maxmember, String minmember, int offset, int count) {
        Set<String> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zrevrangeByScore(key, maxmember, minmember, offset, count);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zrevrangeByScore falid", e);
        }
        return result;
    }

    /**
     * 返回有序集 key 中成员 member 的排名。其中有序集成员按 score 值递增(从小到大)顺序排列。 排名以 0 为底，也就是说，
     * score 值最小的成员排名为 0 。
     * <p>
     * 返回值: 如果 member 是有序集 key 的成员，返回 member 的排名。 如果 member 不是有序集 key 的成员，返回 nil
     * 。
     *
     * @param key
     * @param member
     * @return
     */
    public static long zrank(String key, String member) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zrank(key, member);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zrank falid", e);
        }
        return result;
    }

    /**
     * 返回有序集 key 中成员 member 的排名。其中有序集成员按 score 值递增(从小到大)顺序排列。 排名以 0 为底，也就是说，
     * score 值最小的成员排名为 0 。
     * <p>
     * 返回值: 如果 member 是有序集 key 的成员，返回 member 的排名。 如果 member 不是有序集 key 的成员，返回 nil
     * 。
     *
     * @param key
     * @param member
     * @return
     */
    public static long zrank(byte[] key, byte[] member) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zrank(key, member);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zrank falid", e);
        }
        return result;
    }

    /**
     * 返回有序集 key 中成员 member 的排名。其中有序集成员按 score 值递减(从大到小)排序。 排名以 0 为底，也就是说， score
     * 值最大的成员排名为 0 。
     * <p>
     * 返回值: 如果 member 是有序集 key 的成员，返回 member 的排名。 如果 member 不是有序集 key 的成员，返回 nil
     * 。
     *
     * @param key
     * @param member
     * @return
     */
    public static long zrevrank(String key, String member) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            Long rank = jedis.zrevrank(key, member);
            if (rank != null) {
                result = rank;
            }
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zrevrank falid", e);
        }
        return result;
    }

    /**
     * 返回有序集 key 中成员 member 的排名。其中有序集成员按 score 值递减(从大到小)排序。 排名以 0 为底，也就是说， score
     * 值最大的成员排名为 0 。
     * <p>
     * 返回值: 如果 member 是有序集 key 的成员，返回 member 的排名。 如果 member 不是有序集 key 的成员，返回 nil
     * 。
     *
     * @param key
     * @param member
     * @return
     */
    public static long zrevrank(byte[] key, byte[] member) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zrevrank(key, member);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zrevrank falid", e);
        }
        return result;
    }

    /**
     * 移除有序集 key 中，指定排名(rank)区间内的所有成员。
     * <p>
     * 区间分别以下标参数 start 和 stop 指出，包含 start 和 stop 在内。 下标参数 start 和 stop 都以 0
     * 为底，也就是说，以 0 表示有序集第一个成员，以 1 表示有序集第二个成员，以此类推。 你也可以使用负数下标，以 -1 表示最后一个成员， -2
     * 表示倒数第二个成员，以此类推。
     * <p>
     * 返回值: 被移除成员的数量。
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static long zremrangeByRank(String key, long start, long end) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zremrangeByRank(key, start, end);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zremrangeByRank falid", e);
        }
        return result;
    }

    /**
     * 移除有序集 key 中，指定排名(rank)区间内的所有成员。
     * <p>
     * 区间分别以下标参数 start 和 stop 指出，包含 start 和 stop 在内。 下标参数 start 和 stop 都以 0
     * 为底，也就是说，以 0 表示有序集第一个成员，以 1 表示有序集第二个成员，以此类推。 你也可以使用负数下标，以 -1 表示最后一个成员， -2
     * 表示倒数第二个成员，以此类推。
     * <p>
     * 返回值: 被移除成员的数量。
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static long zremrangeByRank(byte[] key, int start, int end) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zremrangeByRank(key, start, end);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zremrangeByRank falid", e);
        }
        return result;
    }

    /**
     * 移除有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。
     * <p>
     * 返回值: 被移除成员的数量。
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static long zremrangeByScore(String key, double start, double end) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zremrangeByScore(key, start, end);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zremrangeByScore falid", e);
        }
        return result;
    }

    /**
     * 移除有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。
     * <p>
     * 返回值: 被移除成员的数量。
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static long zremrangeByScore(byte[] key, double start, double end) {
        long result = -10000;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zremrangeByScore(key, start, end);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zremrangeByScore falid", e);
        }
        return result;
    }

    public static Set<String> keys(String pattern) {
        Set<String> set = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            set = jedis.keys(pattern);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zremrangeByScore falid", e);
        }
        return set;
    }

    public static Set<byte[]> keys(byte[] pattern) {
        Set<byte[]> set = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            set = jedis.keys(pattern);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zremrangeByScore falid", e);
        }
        return set;
    }

    /**
     * @param key
     * @param msg
     * @return
     * @Title publicMsg
     * @Description <p>
     * 向指定的频道发送消息
     * </p>
     * @author pro
     * @dateTime 2015年10月22日 下午3:13:01
     */
    public static Long publicMsg(String key, String msg) {
        Jedis jedis = null;
        Long count = null;
        try {
            jedis = getResource();
            count = jedis.publish(key, msg);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zremrangeByScore falid", e);
        }
        return count;

    }

    /**
     * @param pubSub
     * @param channels 订阅的名字
     * @Title subscribeChannel
     * @Description <p>
     * 订阅给定的一个或多个频道的信息
     * </p>
     * @author pro
     * @dateTime 2015年10月22日 下午3:08:22
     */
    public static void subscribeChannel(JedisPubSub pubSub, String... channels) {
        Jedis jedis = null;
        try {
            jedis = getResource();
            jedis.subscribe(pubSub, channels);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zremrangeByScore falid", e);
        }
    }

    public static void unSubscribeChannel(JedisPubSub pubSub, String... channels) {
        pubSub.unsubscribe(channels);
    }

    public static void pSubscribeChannel(JedisPubSub pubSub, String... patterns) {
        Jedis jedis = null;
        try {
            jedis = getResource();
            jedis.psubscribe(pubSub, patterns);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zremrangeByScore falid", e);
        }
    }

    public static void unPSubscribeChannel(JedisPubSub pubSub, String... patterns) {
        pubSub.punsubscribe(patterns);
    }

    /**
     * @param channels
     * @return map key为频道名，value为数量
     * @Title pubsubNumsubChannel
     * @Description <p>
     * 获取对应的一个或者多个频道的订阅数量
     * </p>
     * @author pro
     * @dateTime 2015年10月22日 下午3:23:32
     */
    public static Map<String, String> pubsubNumsubChannel(String... channels) {
        Map<String, String> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.pubsubNumSub(channels);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zremrangeByScore falid", e);
        }
        return result;
    }

    public static List<String> scan(String pattern, int count) {
        List<String> list = new ArrayList<String>();
        Jedis jedis = null;
        String cursor = ScanParams.SCAN_POINTER_START;
        try {
            jedis = getResource();
            ScanParams params = new ScanParams();
            params.count(count);
            params.match(pattern);
            do {
                ScanResult<String> scanResult = jedis.scan(cursor, params);
                list.addAll(scanResult.getResult());
                cursor = scanResult.getStringCursor();
            } while (!"0".equals(cursor));
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.scan falid", e);
        }
        return list;
    }

    public static List<byte[]> scan(byte[] pattern, int count) {
        List<byte[]> list = new ArrayList<byte[]>();
        Jedis jedis = null;
        byte[] cursor = ScanParams.SCAN_POINTER_START_BINARY;
        try {
            jedis = getResource();
            ScanParams params = new ScanParams();
            params.count(count);
            params.match(pattern);
            do {
                ScanResult<byte[]> scanResult = jedis.scan(cursor, params);
                list.addAll(scanResult.getResult());
                cursor = scanResult.getCursorAsBytes();
            } while (!"0".equals(cursor));
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.scan falid", e);
        }
        return list;
    }

    /**
     * @param channel
     * @return
     * @Title pubsubNumsubSingleChannel
     * @Description <p>
     * 获取对应频道的订阅数量
     * </p>
     * @author pro
     * @dateTime 2015年10月22日 下午3:23:32
     */
    public static Long pubsubNumsubSingleChannel(String channel) {
        Map<String, String> result = pubsubNumsubChannel(channel);
        Long count = null;
        if (result != null) {
            count = Long.valueOf(result.get(channel));
        }
        return count;
    }

    /**
     * @param key
     * @param offset
     * @param count
     * @return
     * @Title zrevrange
     * @Description <p>
     * 获取添加数据的反向排序
     * </p>
     * @author pro
     * @dateTime 2016年7月29日 上午11:16:07
     */
    public static Set<String> zrevrange(String key, int offset, int count) {
        Set<String> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zrevrange(key, offset, count);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zrevrange falid", e);
        }
        return result;
    }

    /**
     * @param key
     * @param offset
     * @param count
     * @return
     * @Title zrevrangeWithScores
     * @Description <p>
     * 获取添加数据的反向排序(带score)
     * </p>
     * @author pro
     * @dateTime 2018年10月19日 上午15:37:07
     */
    public static Set<Tuple> zrevrangeWithScores(String key, int offset, int count) {
        Set<Tuple> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zrevrangeWithScores(key, offset, count);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zrevrangeWithScores falid", e);
        }
        return result;
    }

    /**
     * 返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。有序集成员按 score
     * 值递增(从小到大)次序排列。 具有相同 score 值的成员按字典序(lexicographical
     * order)来排列(该属性是有序集提供的，不需要额外的计算)。
     * <p>
     * 可选的 LIMIT 参数指定返回结果的数量及区间(就像SQL中的 SELECT LIMIT offset, count )，注意当 offset
     * 很大时，定位 offset 的操作可能需要遍历整个有序集，此过程最坏复杂度为 O(N) 时间。
     * <p>
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param key
     * @param min
     * @param max
     * @param offset
     * @param count
     * @return
     */
    public static Set<Tuple> zrangeByScoreWithScores(String key, double min, double max, int offset, int count) {
        Set<Tuple> result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.zrangeByScoreWithScores(key, min, max, offset, count);
            returnResource(jedis);
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("JedisCache.zrangeByScoreWithScores falid", e);
        }
        return result;
    }


}
