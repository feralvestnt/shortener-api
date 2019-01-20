package com.shortener.demo.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ShortenerHealthIndicator implements HealthIndicator{

    @Override
    public Health health() {
        return Health.up().build();
    }
}
