package com.chenguangli.spring.soudsystem;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class TrackCounter {

    private Map<Integer, Integer> trackCounts = new HashMap<>();


    @Pointcut("execution(* com.chenguangli.spring.soudsystem.CompactDisc.playTrack(int))" + " && args(trackNum)")
    public void trackPlayed(int trackNum) {
    }

    @Before("trackPlayed(trackNum)")
    public void countTrack(int trackNum) {
        int currentCount = getPlayCount(trackNum);
        trackCounts.put(trackNum, currentCount + 1);
    }

    public int getPlayCount(int trackNum) {
        return trackCounts.containsKey(trackNum) ? trackCounts.get(trackNum) : 0;
    }
}
