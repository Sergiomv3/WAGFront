package controller;

import dto.AnagramDTO;
import interfaces.GetRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class AnagramController {

    @Autowired
    GetRequestService getRequestService;

    @GetMapping("/anagram")
    public String greeting(@RequestParam(name="word") String word, Model model) {

        AnagramDTO dto = getRequestService.getAnagramsByGetRequest(word);

        model.addAttribute("word", dto.getWord());
        model.addAttribute("anagrams", dto.getListOfAnagrams().toString());

        return "anagram";
    }

}
