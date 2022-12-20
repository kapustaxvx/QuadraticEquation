package com.quadraticequation.service;

import com.quadraticequation.model.entity.Role;
import com.quadraticequation.model.entity.User;
import com.quadraticequation.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    private final static Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private  final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleService roleService,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            LOG.error("Пользователь: {} не найден", username);
            throw new UsernameNotFoundException(username);
        } else {
            LOG.info("Пользователь: {} найден", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
    }

    @Override
    public User saveUser(User user) {
        LOG.info("Сохраняем нового пользователя: {} в БД", user.getName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        LOG.info("Добавляем роль: {} пользователю: {}", roleName, userName);
        User user = userRepository.findByUserName(userName);
        Role role = roleService.getRole(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String userName) {
        LOG.info("Получаем пользователя по username: {}", userName);
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<User> getUsers() {
        LOG.info("Список всех пользователей");
        return userRepository.findAll();
    }
}
