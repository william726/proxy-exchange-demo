//package com.example.demo.configuration;
//
//import java.util.Optional;
//
//import javax.net.ssl.SSLException;
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.cloud.gateway.webflux.config.ProxyExchangeArgumentResolver;
//import org.springframework.cloud.gateway.webflux.config.ProxyProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.client.reactive.ClientHttpConnector;
//import org.springframework.http.client.reactive.ReactorClientHttpConnector;
//import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
//import org.springframework.web.reactive.function.client.WebClient;
//
//import io.netty.handler.ssl.SslContext;
//import io.netty.handler.ssl.SslContextBuilder;
//import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
//import reactor.netty.http.client.HttpClient;
//
//@Configuration(proxyBeanMethods = false)
//@ConditionalOnWebApplication
//@ConditionalOnClass({ HandlerMethodReturnValueHandler.class })
//@EnableConfigurationProperties(ProxyProperties.class)
//public class ProxyResponseAutoConfiguration {
//
//    @Bean
//    public ProxyExchangeArgumentResolver proxyExchangeArgumentResolver(
//            Optional<WebClient.Builder> optional, ProxyProperties proxy) throws SSLException {
//        WebClient.Builder builder = optional.orElse(WebClient.builder());
//        
//        SslContext sslContext = SslContextBuilder
//                .forClient()
//                .trustManager(InsecureTrustManagerFactory.INSTANCE)
//                .build();
//        HttpClient httpClient = HttpClient.create().secure(sslContextSpec -> sslContextSpec.sslContext(sslContext));
//        ClientHttpConnector httpConnector = new ReactorClientHttpConnector(httpClient);
//        WebClient template = builder.clientConnector(httpConnector).build();
//        
//        ProxyExchangeArgumentResolver resolver = new ProxyExchangeArgumentResolver(
//                template);
//        resolver.setHeaders(proxy.convertHeaders());
//        resolver.setAutoForwardedHeaders(proxy.getAutoForward());
//        resolver.setSensitive(proxy.getSensitive()); // can be null
//        return resolver;
//    }
//
//}
