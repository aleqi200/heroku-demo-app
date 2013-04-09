package spring.bean;

import model.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.bean.repository.HelloRepository;

import javax.validation.Valid;

@Controller
public class SendHelloController {

    @Autowired
    HelloRepository helloRepository;

    @RequestMapping(value = "hello",method = RequestMethod.POST)
    public String sendHello(@ModelAttribute("hello") @Valid Hello hello, ModelMap modelMap){
        helloRepository.save(hello);
        return home(modelMap);
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(ModelMap model) {
        model.addAttribute("messages", helloRepository.getAll());
        return "index";
    }

    @ModelAttribute("hello")
    public Hello hello(){
        return new Hello();
    }

}
