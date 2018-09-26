/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author ckinateder
 */
public class TwitterSkimmer {
    public static void skim(){
        
    }
    // Encodes the consumer key and secret to create the basic authorization key
    private static String encodeKeys(String consumerKey, String consumerSecret) {
            try {
                    String encodedConsumerKey = URLEncoder.encode(consumerKey, "UTF-8");
                    String encodedConsumerSecret = URLEncoder.encode(consumerSecret, "UTF-8");

                    String fullKey = encodedConsumerKey + ":" + encodedConsumerSecret;
                    byte[] encodedBytes = Base64.encodeBase64(fullKey.getBytes());
                    return new String(encodedBytes);  
            }
            catch (UnsupportedEncodingException e) {
                    return new String();
            }
    }

}
