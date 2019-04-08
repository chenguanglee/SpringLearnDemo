package com.chenguangli.spring.soudsystem;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.inject.Named;

@Component
@Primary
//@Named
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt....";

    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by" + artist);
    }

    @Override
    public void playTrack(int trackNum) {

    }
}
