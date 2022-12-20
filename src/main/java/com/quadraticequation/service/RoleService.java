package com.quadraticequation.service;

import com.quadraticequation.model.entity.Role;

public interface RoleService {
    Role saveRole(Role role);

    Role getRole(String name);
}
