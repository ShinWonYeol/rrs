package com.juju.review.api;

import org.springframework.web.bind.annotation.*;

@RestController
public class _01_TestApi {

    @GetMapping("/hellow/world")
    public String hellowWorld(){
        return "[Get] hellow World!";
    }

    @PostMapping("/hellow/world")
    public String postHellowWorld(){
        return "[Post] Hellow Wrold!";
    }

    @PutMapping("/hellow/world")
    public String putHellowWorld(){
        return "[Put] Hellow Wrold!";
    }

    @DeleteMapping("/hellow/world")
    public String deleteHellowWorld(){
        return "[Delete] Hellow World!";
    }

}
