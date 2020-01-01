package com.chenguangli.spring.es;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chenguangli
 * @date 2019/5/27 23:06
 */
@Component
public class EsService {

    @Autowired
    private Client client;

    private String index = "lee_index";

    private String type="table";

    public void query(String id) {
        GetResponse getResponse = client.prepareGet(index, type, id).get();
        System.out.println("");
    }
}
