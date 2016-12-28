package com.idea.quickstart.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * @author andaicheng
 * @version 2016/12/28
 */
@Component
public class RedisCache {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Object get(Object key) {
        final String keyf = key.toString();
        Object object = null;

        object = redisTemplate.execute(new RedisCallback<Object>() {
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] key = keyf.getBytes();
                byte[] value = connection.get(key);
                if (value == null) {
                    return null;
                }
                return toObject(value);
            }
        });
        return object;
    }

    public void put(Object key, Object value, final long liveTime) {
        final String keyf = key.toString();
        final Object valuef = value;

        redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] keyb = keyf.getBytes();
                byte[] valueb = toByteArray(valuef);
                connection.set(keyb, valueb);
                if (liveTime > 0) {
                    connection.expire(keyb, liveTime);
                }
                return 1L;
            }
        });
    }

    /**
     * < Object转byte[] >. <br>
     */
    private byte[] toByteArray(Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
            oos.close();
            bos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bytes;
    }

    /**
     * < byte[]转Object >. <br>
     */
    private Object toObject(byte[] bytes) {
        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            obj = ois.readObject();
            ois.close();
            bis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return obj;
    }

    public void del(Object key) {
        final String keyf = key.toString();
        redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.del(keyf.getBytes());
            }
        });
    }

    public void exprie(Object key, final long liveTime) {
        final String keyf = key.toString();
        redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.expire(keyf.getBytes(), liveTime);
            }
        });
    }

    public Boolean exist(Object key) {
        final String keyf = key.toString();
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.exists(keyf.getBytes());
            }
        });
    }

    public void clear() {
        redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                connection.flushDb();
                return "ok";
            }
        });
    }

    /**
     * 方法描述:对key的值做加加操作,并返回新的值。 incr一个不存在的key，则设置key为1 方法描述: <br>
     * 创建时间: 2016年5月6日 下午6:51:28 <br>
     *
     * @param key key
     * @return 返回值：Long <br>
     */
    public Long incr(Object key) {
        final String keyf = key.toString();
        return redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.incr(keyf.getBytes());
            }
        });
    }

    /**
     * 方法描述: 对key的值做的是减减操作，decr一个不存在key，则设置key为-1 <br>
     * 创建时间: 2016年5月6日 下午6:53:01 <br>
     *
     * @param key key
     * @return 返回值：Long <br>
     */
    public Long decr(Object key) {
        final String keyf = key.toString();
        return redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.decr(keyf.getBytes());
            }
        });
    }

}
