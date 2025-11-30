package com.epam.edp.demo;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class AppMemoryMetrics {

    public AppMemoryMetrics(MeterRegistry registry) {

        Runtime runtime = Runtime.getRuntime();
        Gauge.builder("app_memory_usage_e02ai1iz", runtime, r ->
                (r.totalMemory() - r.freeMemory())
        )
        .description("App memory usage for task e02ai1iz")
        .baseUnit("bytes")
        .register(registry);
    }
}
