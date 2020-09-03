package com.example.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.client.ConfigServicePropertySourceLocator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * @author ：ligh
 * @date ：Created in 2020/5/24 0024 15:58
 */
@RestController
public class HelloHandle {

    private static Log logger = LogFactory.getLog(HelloHandle.class);

    @Autowired
    private HttpServletRequest request;



    @RequestMapping("/hello")
    public String helloSpringBoot() {

        logger.info("访问者ip"+ getIpAddr(request));

        return "Hello SpringBoot Project.";
    }


    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
