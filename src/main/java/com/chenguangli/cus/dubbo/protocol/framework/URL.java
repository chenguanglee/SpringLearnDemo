package com.chenguangli.cus.dubbo.protocol.framework;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chenguangli
 * @date 2019/12/18 23:38
 */
@Data
public class URL implements Serializable {

    private String hostName;
    private int port;
}
