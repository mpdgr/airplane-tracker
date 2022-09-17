package mpdgr.airplanetracker.web.restcontrollers.config;

import org.springframework.context.annotation.Configuration;
import javax.servlet.http.HttpServletRequest;

@Configuration
public class LogConfig {
    public String controllerLog(HttpServletRequest request, String path){
        return "Http request: path: " + path +
                "; user name: " + request.getRemoteUser() + " " +
                "; remote address: " + request.getRemoteAddr() + " " +
                "; remote host: " + request.getRemoteHost() + " " +
                "; user agent: " + request.getHeader("User-Agent");
    }
}
