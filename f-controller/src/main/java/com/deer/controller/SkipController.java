package com.deer.controller;

import com.deer.model.mysql.binaryTree.BinaryTreeUtil;
import com.deer.model.mysql.binaryTree.NodeModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("v1/page")
@Controller
public class SkipController {

    @RequestMapping("index")
    public String getIndex(){
        return "index";
    }
    @RequestMapping("login")
    public String getLogin(){
        return "login";
    }

    @RequestMapping("binaryTree")
    public String getBinaryTree(){
        return "binaryTree";
    }

    @RequestMapping("binaryTree/generate")
    @ResponseBody
    public NodeModel getBinaryTree(@RequestParam("vals") String vals, @RequestParam("rootPlace")Integer rootPlace){
        String array[] = vals.split(",");
        if(array == null){
            array = vals.split("，");
            if(array == null)
                return null;
        }
        NodeModel nodeModel = BinaryTreeUtil.getCaseNodeModel(array, (int)rootPlace);
        return nodeModel;
    }


}
