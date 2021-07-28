package com.api.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.val;

import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.lang.NonNull;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
public class ServiceConfiguration {

    @NonNull
    private ObjectMapper objectMapper;
    @NonNull
    private HttpProperties httpProperties;

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {

        val mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter(objectMapper);
        val restTemplate = new RestTemplate();
        val factory = new HttpComponentsClientHttpRequestFactory();
        factory.setHttpClient(HttpClientBuilder.create()
                                               .setMaxConnPerRoute(httpProperties.getMaxConnectRoute())
                                               .setMaxConnTotal(httpProperties.getMaxConnect())
                                               .build());
        factory.setConnectionRequestTimeout(httpProperties.getConnectRequestTimeout());
        factory.setConnectTimeout(httpProperties.getConnectTimeout());
        factory.setReadTimeout(httpProperties.getSocketTimeout());

        restTemplate.setRequestFactory(factory);

        val messageConverters = restTemplate.getMessageConverters();
        messageConverters.removeIf(m -> m.getClass()
                                         .equals(MappingJackson2HttpMessageConverter.class));
        messageConverters.add(mappingJackson2HttpMessageConverter);

        return restTemplate;
    }
}
