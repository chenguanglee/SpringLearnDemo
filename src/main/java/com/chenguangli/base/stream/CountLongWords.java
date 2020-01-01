package com.chenguangli.base.stream;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author chenguangli
 * @date 2019/4/22 22:50
 */
public class CountLongWords {
    public static void main(String[] args) throws IOException {
        Reader in = new InputStreamReader(System.in);
        File file = new File("");
        System.out.println(file.getCanonicalPath());

        String contents = new String(Files.readAllBytes(Paths.get(".\\src\\main\\java\\com\\chenguangli\\stream\\stream.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("\\PL+"));
        long count = 0;
        for (String w : words) {
            if (w.length() > 3) count++;
        }
        System.out.println(count);

        count = words.stream().filter(w -> w.length() > 2).count();
        System.out.println(count);

        count = words.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 2;
            }
        }).count();
        System.out.println(count);


        count = words.parallelStream().filter(w -> w.length() > 3).count();
        System.out.println(count);
    }
}
