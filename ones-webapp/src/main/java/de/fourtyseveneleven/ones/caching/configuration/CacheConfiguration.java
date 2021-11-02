package de.fourtyseveneleven.ones.caching.configuration;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.HOURS;

@Configuration
public class CacheConfiguration {

    @Bean
    @Qualifier("eventCacheManager")
    public CacheManager eventCacheManager() {

        return new OnesCacheManager(10_000, Duration.of(1, HOURS));
    }

    private static class OnesCacheManager extends CaffeineCacheManager {

        private final int maximumSize;
        private final Duration expireAfterWrite;

        private OnesCacheManager(int maximumSize, Duration expireAfterWrite) {
            this.maximumSize = maximumSize;
            this.expireAfterWrite = expireAfterWrite;
        }

        @Override
        @NonNull
        protected Cache<Object, Object> createNativeCaffeineCache(@NonNull String name) {

            return Caffeine.newBuilder()
                    .maximumSize(maximumSize)
                    .expireAfterWrite(expireAfterWrite)
                    .build();
        }
    }
}
