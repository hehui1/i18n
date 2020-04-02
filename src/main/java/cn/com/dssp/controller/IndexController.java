package cn.com.dssp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * cwy 2020/2/18 16:22
 **/
@Controller
public class IndexController {


    @RequestMapping("/index")
    public String index(HttpSession session) {

        return "index";
    }

}
