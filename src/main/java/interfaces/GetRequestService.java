package interfaces;

import dto.AnagramDTO;

/**
 * Interface that contains the methods for get request to Rest service.
 * @author Sergio Martin
 * @version 1.0
 */
public interface GetRequestService {
    public AnagramDTO getAnagramsByGetRequest(String word);
}
