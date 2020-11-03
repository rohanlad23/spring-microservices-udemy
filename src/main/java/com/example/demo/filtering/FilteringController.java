package com.example.demo.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean getSomeBean(){
        SomeBean someBean=new SomeBean("val1","val2","val3");
        return someBean;
    }

    @GetMapping("/list")
    public List<SomeBean> getSomeBeans(){
        return Arrays.asList(new SomeBean("val1","val2","val3"),
                new SomeBean("val1","val2","val3"));
    }
}
