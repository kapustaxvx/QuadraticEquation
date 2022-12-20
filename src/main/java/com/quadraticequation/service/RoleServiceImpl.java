package com.quadraticequation.service;

import com.quadraticequation.model.entity.Role;
import com.quadraticequation.repo.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private final static Logger LOG = LoggerFactory.getLogger(RoleServiceImpl.class);
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role saveRole(Role role) {
        LOG.info("Сохраняем новую роль: {} в БД", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public Role getRole(String name) {
        LOG.info("Получаем роль с имемен: {}", name);
        return roleRepository.findByName(name);
    }
}
