package ru.job4j.generics;

public class Role extends Base {
    private final String roleuser;

    public Role(String id, String role) {
        super(id);
        this.roleuser = role;
    }

    public String getRoleuser() {
        return roleuser;
    }
}
