package com.chenguangli.spring.soudsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.inject.Named;

@Component //方式一
//@Named  //方式二

@Qualifier("cDPlayer")
public class CDPlayer implements MediaPlayer {

    private CompactDisc cd;

    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play() {
        cd.play();
    }

    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }
}
