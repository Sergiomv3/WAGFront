package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {

        String url = "http://localhost:8081/anagram?word=" + name;

        RestTemplate restTemplate = new RestTemplate();
        AnagramDTO dto = restTemplate.getForObject(url, AnagramDTO.class);

        model.addAttribute("name", dto.toString());

        return "greeting";
    }

}
