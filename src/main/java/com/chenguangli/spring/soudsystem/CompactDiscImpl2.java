package com.chenguangli.spring.soudsystem;

import org.springframework.stereotype.Component;

@Component
public class CompactDiscImpl2 implements CompactDisc {

    @Override
    public void play() {
        System.out.println("chenguangli custom impl");
    }
}
