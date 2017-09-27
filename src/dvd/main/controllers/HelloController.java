package dvd.main.controllers;

import dvd.main.entities.User;
import dvd.main.services.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by anya on 14.09.2017.
 */
@Controller
@Log
public class HelloController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String listContacts(Map<String, Object> map) {

        map.put("users", new User());
        map.put("userList", userService.getAllUsers());

        return "user";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact") User user,
                             BindingResult result) {

        userService.addUser(user);
        return "redirect:/index";
    }

    @RequestMapping("/delete/{contactId}")
    public String deleteContact(@PathVariable("contactId") Long contactId) {

        userService.removeUser(contactId);
        return "redirect:/index";
    }
}
