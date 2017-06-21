/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.connection;

import com.jme3.network.serializing.Serializer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Imanshu
 */
public class ConnectionUtil {
    
    public static final String SERVER_IP_ADDRESS = "localhost";
    public static final int SERVER_PORT = 4444;
    
    public static void initSerializers(){
        Serializer.registerClass(TextMessage.class );
        Serializer.registerClass(PlayerMessage.class );
    }
   
    private static Pattern pattern;
    private static Matcher matcher;

    private static final String IPADDRESS_PATTERN =
		"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    
    public static boolean validate(final String ip){
          pattern = Pattern.compile(IPADDRESS_PATTERN);
	  matcher = pattern.matcher(ip);
	  return matcher.matches();
    }
    
}
