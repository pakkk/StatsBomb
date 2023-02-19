package es.iesjandula.statsbomb.webportal.security.users;


import es.iesjandula.statsbomb.webportal.models.modelsSecurity.Role;
import es.iesjandula.statsbomb.webportal.models.modelsSecurity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 17/02/2023
 */
@Service
public class MyUserDetalisService implements UserDetailsService
{

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userService.findUserByUserName(username);
        if (user == null)
        {
            throw new UsernameNotFoundException("User not found");
        }
        List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
        return buildUserForAuthentication(user, authorities);
    }

    private List<GrantedAuthority> getUserAuthority(List<Role> userRoles)
    {
        List<GrantedAuthority> roles = new ArrayList<>();
        for (Role role : userRoles)
        {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new ArrayList<>(roles);
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities)
    {
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                user.getActive(), true, true, true, authorities);
    }
}
