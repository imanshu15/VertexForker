/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.util;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author d.jayasinghe
 */
public class AuthenticationHelper {

    public static String getIpAddress() {
        String ip = null;
        try {
            String command = null;
            if (System.getProperty("os.name").equals("Linux")) {
                command = "ifconfig";
            } else {
                command = "ipconfig";
            }
            Runtime r = Runtime.getRuntime();
            Process p = r.exec(command);
            Scanner s = new Scanner(p.getInputStream());

            StringBuilder sb = new StringBuilder("");
            while (s.hasNext()) {
                sb.append(s.next());
            }
            String ipconfig = sb.toString();
//            Pattern pt = Pattern.compile("172\\.28\\.[0-9]{1,3}\\.[0-9]{1,3}");
            Pattern pt = Pattern.compile("192\\.168\\.[0-9]{1,3}\\.[0-9]{1,3}");
            Matcher mt = pt.matcher(ipconfig);
            if (mt.find()) {
                ip = mt.group();
            } else {
                ip = "127.0.0.1";
            }
        } catch (IOException ex) {
            Logger.getLogger(AuthenticationHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ip;
    }
}
