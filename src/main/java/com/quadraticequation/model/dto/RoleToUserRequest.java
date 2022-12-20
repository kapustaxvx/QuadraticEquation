package com.quadraticequation.model.dto;

import java.util.Objects;

public class RoleToUserRequest {
    private String userName;
    private String role;

    public RoleToUserRequest(String userName, String role) {
        this.userName = userName;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleToUserRequest that = (RoleToUserRequest) o;
        return Objects.equals(userName, that.userName) && Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, role);
    }

    @Override
    public String toString() {
        return "RoleToUserRequest{" +
                "userName='" + userName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
