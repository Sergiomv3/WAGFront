package com.martin.anagram.service;

import com.martin.anagram.dto.AnagramDTO;
import com.martin.anagram.interfaces.RequestService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/** Implements the inteface RequestService and returns the response of Rest com.martin.anagram.service
 * @author Sergio Martin
 * @version 1.0
 */
@Service("requestService")
public class RequestServiceImpl implements RequestService {

    /*The constant url for get request*/
    public static final String HTTP_LOCALHOST_8081_ANAGRAM_WORD = "http://localhost:8081/anagram?word";

    @Override
    public AnagramDTO getAnagramsByGetRequest(String word) {
        String url = HTTP_LOCALHOST_8081_ANAGRAM_WORD + "=" + word;

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, AnagramDTO.class);
    }
}
