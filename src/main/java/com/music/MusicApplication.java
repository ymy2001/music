package com.music;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class MusicApplication {

    public static void main(String[] args) {

        SpringApplication.run(MusicApplication.class, args);
        log.info("服务启动");
    }

}
