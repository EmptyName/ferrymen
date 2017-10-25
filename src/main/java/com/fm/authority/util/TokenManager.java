package com.fm.authority.util;

import com.fm.authority.token.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by aiyi on 2017/5/6.
 */
@Component
public class TokenManager {

    private RedisTemplate<Long, String> redisTemplate;


    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.redisTemplate.setKeySerializer(new JdkSerializationRedisSerializer());
    }

    public Token createToken(Long uid) {
        String uuid = UUID.randomUUID().toString().replaceAll("_", "");
        Token token = Token.creatToken(uid, uuid);
        redisTemplate.boundValueOps(uid).set(uuid, 2, TimeUnit.HOURS);
        return token;
    }

    public boolean checkToken(Token token) {
        if (token == null) {
            return false;
        }

        String uuid = redisTemplate.boundValueOps(token.getUid()).get();
        if (uuid == null || !token.getUuid().equals(uuid)) {
            return false;
        }
        redisTemplate.boundValueOps(token.getUid()).expire(2, TimeUnit.HOURS);
        return true;
    }

    public Token getToken(String token) {
        if (token == null || token.length() == 0) {
            return null;
        }
        String[] split = token.split("_");
        if (split.length != 2) {
            return null;
        }
        Long uid = null;
        try {
            uid = Long.parseLong(split[0]);
        } catch (NumberFormatException e) {
            return null;
        }
        String uuid = split[1];
        return Token.creatToken(uid, uuid);
    }


    public void add1s(Token token) {
        redisTemplate.boundValueOps(token.getUid()).expire(2, TimeUnit.HOURS);
    }


}
