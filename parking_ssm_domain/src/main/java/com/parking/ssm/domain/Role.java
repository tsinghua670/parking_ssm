package com.parking.ssm.domain;

import java.util.List;

public class Role {
    private Integer id;
    private String roleName;
    private String roleDesces;
    private List<UserInfo> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesces() {
        return roleDesces;
    }

    public void setRoleDesces(String roleDesces) {
        this.roleDesces = roleDesces;
    }

    public List<UserInfo> getUsers() {
        return users;
    }

    public void setUsers(List<UserInfo> users) {
        this.users = users;
    }
}
