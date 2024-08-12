package com.boluo.controller;

import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chao
 * @date 2022/10/29 12:56
 * @desc
 */
@Api(value = "测试value", tags = "测试tag")
@RestController // 数据将以json格式返回
public class HelloController {

    // RequestMapping 会在swagger-ui上产生多个
    @PostMapping("/hello")
    public String hello() {
        return "hello";
    }


    @PostMapping(value = "/kafka/consumerMsg")
    public ResponseEntity<String> getMsgByKafka() {
        try {
            return ResponseEntity.ok().body("测试信息!!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}
