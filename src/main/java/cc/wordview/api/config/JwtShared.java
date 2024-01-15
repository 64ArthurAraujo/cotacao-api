package cc.wordview.api.config;

import org.springframework.beans.factory.annotation.Autowired;

import cc.wordview.api.service.JwtUserDetailsService;

public class JwtShared {
        @Autowired
        public static JwtUserDetailsService jwtUserDetailsService;
}
