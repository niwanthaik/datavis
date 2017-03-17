package org.uom.fit.level2.datavis.controllers.login;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.util.JSON;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.uom.fit.level2.datavis.model.login.User;


/**
 * Created by asiri on 3/14/17.
 */
@Controller
@RequestMapping("/")
public class LoginController {
    //private UserRepository userRepository;
    //private RoleRepository roleRepository;
    private String user;
    //private String role;


 /* @Autowired
    public LoginController(
          UserRepository userRepository) {
       this.userRepository = userRepository;
   }*/






        @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(){

        return "register";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){

        return "login";
    }
    /*@RequestMapping(value="/{login}", method=RequestMethod.POST)
    public String addTouserList(
            @ModelAttribute String usr, User user) {
       // user.setUserName(usr);
        userRepository.save(user);
        return "success";

    }*/
//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public @ResponseBody User addUser(User user){
//        User user1 =  userRepository.save(user);
//        return user1;
//    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
   public @ResponseBody String addUser(@RequestBody User user){
/*       User user1 =  userRepository.save(user);
       System.out.println(user1.getUserName());
       System.out.println(user1.getPassword());*/
        return "ok";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String checkUser(@RequestBody User user) {

        System.out.print(user.getUserName());
//        User usr=userRepository.findByUserName(user.getUserName());
//
//        if(usr==null)
//          return "login";
//
//        else
//            return "register";

        JSONObject o=new JSONObject();
        o.put("validation",true);

//
    return o.toString();
    }


}
