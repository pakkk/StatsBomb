package es.iesjandula.statsbomb.webportal.security.users;


import es.iesjandula.statsbomb.webportal.models.modelsSecurity.Role;
import es.iesjandula.statsbomb.webportal.models.modelsSecurity.User;
import es.iesjandula.statsbomb.webportal.repositorySecurity.IRoleSecurity;
import es.iesjandula.statsbomb.webportal.repositorySecurity.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 17/02/2023
 */
@Service
public class UserService
{

    private IUserRepository userRepository;

    private IRoleSecurity roleRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(
            IUserRepository userRepository,
            IRoleSecurity roleRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder
    )
    {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByUserName(String username)
    {
        return userRepository.findByUserName(username);
    }

    public User findUserByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }

    public User saveUser(User user)
    {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(Collections.singletonList(userRole));
        return userRepository.save(user);
    }

}
