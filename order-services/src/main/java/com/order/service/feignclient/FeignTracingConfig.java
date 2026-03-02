package com.order.service.feignclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;
import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;

@Configuration
public class FeignTracingConfig {

	@Bean
	public RequestInterceptor tracingRequestInterceptor(Tracer tracer) {
		return requestTemplate -> {
			Span span = tracer.currentSpan();
			if (span != null) {
				requestTemplate.header("X-B3-TraceId", span.context().traceId());
				requestTemplate.header("X-B3-SpanId", span.context().spanId());
			}
		};
	}
}
