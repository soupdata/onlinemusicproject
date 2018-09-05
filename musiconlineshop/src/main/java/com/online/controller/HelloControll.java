package com.online.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.online.data.User;


// 代表这个类是springmvc的controller
@Controller
@RequestMapping("/")
public class HelloControll {
    /** get类型的访问方式
     * 访问网站的根目录就会执行printWelcome函数
     */
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model){
        model.addAttribute("message","Hello world");
        //或者put也是可以的
        //model.put("","");
        // 返回一个jsp页面
        return "hello";
    }
//
//    /**
//     * url get类型访问方式为：http://localhost:8080/page/zqr/20
//     * @param map ModelMap对象,与模板参数进行沟通的一个参数
//     * @param name url中的一个参数
//     * @param age url中的一个参数
//     * @return 一个jsp的名字
//     */
//    @RequestMapping(value = "/page/{name}/{age}",method = RequestMethod.GET)
//    public String printName(ModelMap map, @PathVariable("name") String name, @PathVariable("age") int age){
//        map.addAttribute("name",name);
//        map.addAttribute("age",age);
//        return "name";
//    }

    /**
     * 访问方式http://localhost:8080/result?name=zqr&age=20
     * RequestMethod.GET接收方式
     * @param map
     * @param name
     * @param age
     * @return
     */
//    @RequestMapping(value = "/result",method = RequestMethod.POST)
//    public String rusult(ModelMap map, @RequestParam String name,@RequestParam int age) {
//        map.addAttribute("name",name);
//        map.addAttribute("age",age);
//        return "result";
//    }

//    @RequestMapping(value = "/adduser",method = RequestMethod.GET)
//    public String adduser(ModelMap map) {
//        User user=new User();
//        user.setAge(20);
//        user.setName("zyb");
//        //排除为空，空报异常
//        map.addAttribute("user",user);
//        return "add_user";
//    }

}
