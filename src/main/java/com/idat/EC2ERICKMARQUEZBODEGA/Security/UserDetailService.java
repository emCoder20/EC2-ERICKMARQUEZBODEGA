package com.idat.EC2ERICKMARQUEZBODEGA.Security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if( "profesor".equals(username)) {
            return new User("profesor", "123", new ArrayList<>());
        }else
            throw new UsernameNotFoundException("Usuario no existe " + username);
    }

}
