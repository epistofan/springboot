package hello;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    UserRepository userRepo;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }
    @GetMapping("main")
    public String main(Map<String, Object>model){
        Iterable<User>Users = userRepo.findAll();
        model.put("users", Users);

        return "main";
    }

    @PostMapping("main")
    public String add(@RequestParam String name, @RequestParam String email, Map<String, Object> model){
        User user1 = new User();
        user1.setName(name);
        user1.setEmail(email);

        userRepo.save(user1);

        Iterable<User>Users = userRepo.findAll();
        model.put("users", Users);
        return "main";
    }
    @GetMapping("calculator")
    public String calc(){

        return "calculator";
    }
}
