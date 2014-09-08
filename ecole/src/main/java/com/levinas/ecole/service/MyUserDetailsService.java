/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.service;

import com.levinas.ecole.dao.UserDao;
import com.levinas.ecole.model.Role;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrateur
 */

@Configuration
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.levinas.ecole.model.User user = userDao.findByUsername(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getRoleCollection());

        return buildUserForAuthentication(user, authorities);
    }
    
    
    private User buildUserForAuthentication(com.levinas.ecole.model.User user, 
            List<GrantedAuthority> authorities) {
            return new User(user.getUsername(), 
                    user.getPassword(), user.getEnabled(), 
                    true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Collection<Role> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (Role userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getLibelle()));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }

}
