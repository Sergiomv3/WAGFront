package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class GreetingController {

    @GetMapping("/anagram")
    public String greeting(@RequestParam(name="word") String word, Model model) {

        String url = "http://localhost:8081/anagram?word=" + word;

        RestTemplate restTemplate = new RestTemplate();
        AnagramDTO dto = restTemplate.getForObject(url, AnagramDTO.class);

        model.addAttribute("word", dto.getWord());
        model.addAttribute("anagrams", dto.getListOfAnagrams().toString());

        return "greeting";
    }

}
