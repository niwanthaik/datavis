package org.uom.fit.level2.datavis.controllers.login;



import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.uom.fit.level2.datavis.model.login.Role;
import org.uom.fit.level2.datavis.model.login.User;
import org.uom.fit.level2.datavis.repository.login.UserRepository;

//port org.uom.fit.level2.datavis.repository.login.RoleRepository;


/**
 * Created by asiri on 3/14/17.
 */
@RestController
@RequestMapping("/apidata")
public class LoginController {


    private UserRepository userRepository;
    //private RoleRepository roleRepository;
    private String user;
    //private String role;


    @Autowired
    public LoginController(
            UserRepository userRepository) {
        this.userRepository = userRepository;

    }


    @RequestMapping(value = "/register",method = RequestMethod.POST)
   public String addUser(@RequestBody User user){


        Role admin=new Role();
        admin.setRole(user.getRolename());
        User userl =new User();

        userl.setUserName(user.getUserName());
        userl.setPassword(user.getPassword());
        userl.setEmail(user.getEmail());
        userl.setCountry(user.getCountry());
        userl.setQuestion1(user.getQuestion1());
        userl.setQuestion2(user.getQuestion2());
        userl.setRole(admin);

        User user1 = (User) userRepository.save(userl);


       /*System.out.println(user1.getUserName());
       System.out.println(user1.getPassword());*/

        return null;
    }



    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String checkUser(@RequestBody User user) {
        boolean success;
        User usr=userRepository.findByUserName(user.getUserName());
        User pwd=userRepository.findByPassword(user.getPassword());
        System.out.println(pwd);

        String rl=usr.getRole().getRole();
        System.out.println(usr.getUserName());

        System.out.println(rl);

        if(usr==null||pwd==null)
            success=false;
        else
            success=true;

        System.out.println(success);
        JSONObject o=new JSONObject();
        o.put("validation",success);

        o.put("rol",rl);
    return o.toString();
    }


}
