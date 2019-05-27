package com.chenguangli.es;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetAddress;

/**
 * @author chenguangli
 * @date 2019/5/27 22:21
 */
@Configuration
@ComponentScan
public class EsConfiguration {

    private String esHost="localhost";

    private int esPort=9300;

    private TransportClient client;

    @PostConstruct
    public void initialize() throws Exception {
        Settings settings = Settings.builder().put("cluster.name","elasticsearch").build();
        client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName(esHost),esPort));
    }

    @Bean
    public Client client() {
        return client;
    }

    @PreDestroy
    public void destroy() {
        if (client != null) {
            client.close();
        }
    }
}
