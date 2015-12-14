package masterSpringMvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by dlok on 14/12/2015.
 */
@Configuration
@Profile("redis")
@EnableRedisHttpSession
public class RedisConfig {
}
