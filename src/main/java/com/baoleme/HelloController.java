package com.baoleme;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alex on 17/6/25.
 */
@RestController
public class HelloController {

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String Hello(){
        return "1111";
    }
}
