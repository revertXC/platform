package com.deer.controller.activemq;

import com.deer.activemq.producer.TestProducerable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;

@Controller
@RequestMapping("v1/activemq")
public class ActivemqTestController {

    @Autowired
    TestProducerable testProducerable;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String sendTestInfo(){
        testProducerable.testSendMessage("Hello World!!!");
        return "success";
    }




}
