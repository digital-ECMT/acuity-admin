package com.acuity.visualisations.web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;

/**
 * Overrides EhCacheCacheManager so that any caches in the application that arent configured in the ehcache.xml are then
 * created on the fly.
 *
 * @author glen
 */
@Slf4j
public class CustomEhCacheCacheManager extends EhCacheCacheManager {
    @Override
    public Cache getCache(String name) {
        boolean exists = getCacheManager().cacheExists(name); // used defaultcache implementation
        if (!exists) {
            getCacheManager().addCacheIfAbsent(name);
            log.debug("Created cache {}, {}", name, getCacheManager().getActiveConfigurationText(name));
        }
        return super.getCache(name);
    }
}
