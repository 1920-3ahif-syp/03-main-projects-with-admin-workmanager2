package at.htl.workmanager.model;

public class Role {

    private static long id;
    private RoleState roleName;

    public Role(long id, RoleState roleName) {
        this.id = id;
        setRoleName(roleName);
    }

    public static long getId() {
        return id;
    }

    public RoleState getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleState roleName) {
        this.roleName = roleName;
    }
}
