package service;

import dto.AnagramDTO;
import interfaces.GetRequestService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/** Implements the inteface GetRequestService and returns the response of Rest service
 * @author Sergio Martin
 * @version 1.0
 */
@Service("getRequestService")
public class GetRequestServiceImpl implements GetRequestService {

    /*The constant url for get request*/
    public static final String HTTP_LOCALHOST_8081_ANAGRAM_WORD = "http://localhost:8081/anagram?word";

    @Override
    public AnagramDTO getAnagramsByGetRequest(String word) {
        String url = HTTP_LOCALHOST_8081_ANAGRAM_WORD + "=" + word;

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, AnagramDTO.class);
    }
}
