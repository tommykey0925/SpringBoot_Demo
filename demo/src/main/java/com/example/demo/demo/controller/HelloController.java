package com.example.demo.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController{

  //helloに変更する
  @RequestMapping("/hello")
  public String index(){
    return "hello";
  }
  
}