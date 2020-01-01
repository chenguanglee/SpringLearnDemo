package com.chenguangli.spring.es;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetAddress;

/**
 * @author chenguangli
 * @date 2019/5/27 22:21
 */
@Configuration
@ComponentScan
@PropertySource("classpath:/app.properties")
public class EsConfiguration {

    @Autowired
    private Environment environment;

    @Value("${es.host}")
    private String esHost;

    @Value("${es.port}")
    private String esPort;

    private TransportClient client;

    @PostConstruct
    public void initialize() throws Exception {
        Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();
        client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName(esHost), Integer.parseInt(esPort)));
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

    public String getEsHost() {
        return environment.getProperty("es.host", "localhost");
    }

    public String getEsPort() {
        return environment.getProperty("es.port", "9300");

    }
}
