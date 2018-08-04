package com.martin.anagram.controller;

import com.martin.anagram.dto.AnagramDTO;
import com.martin.anagram.interfaces.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnagramController {

    @Autowired
    RequestService requestService;

    @GetMapping("/anagram")
    public String greeting(@RequestParam(name="word") String word, Model model) {

        AnagramDTO dto = requestService.getAnagramsByGetRequest(word);

        model.addAttribute("word", dto.getWord());
        model.addAttribute("anagrams", dto.getListOfAnagrams().toString());

        return "anagram";
    }

}
