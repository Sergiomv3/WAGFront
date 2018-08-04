package com.martin.anagram.interfaces;

import com.martin.anagram.dto.AnagramDTO;

/**
 * Interface that contains the methods for get request to Rest com.martin.anagram.service.
 * @author Sergio Martin
 * @version 1.0
 */
public interface RequestService {
    public AnagramDTO getAnagramsByGetRequest(String word);
}
