package com.chenguangli.spring.soudsystem;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlankDisc implements CompactDisc {

    private String title;

    private String artist;

    private List<String> tracks;

    public BlankDisc(@Value("${disc.title}") String title, String artist, List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }


    @Override
    public void play() {
        System.out.println("Playing" + title + "by " + artist);
        for (String str : tracks) {
            System.out.println("-tracks is " + str);
        }
    }
}
