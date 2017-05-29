package by.hotel.bean;

import by.hotel.builder.RoleBuilder;
public class Role {
    private int id;
    private String nameRole;
    private byte update;
    private byte delete;
    private byte insert;
    private byte create;
    private byte select;
    private byte drop;
    private byte grant;

    public Role() {
    }

    public Role(RoleBuilder roleBuilder){
        this.id = roleBuilder.getId();
        this.nameRole = roleBuilder.getNameRole();
        this.update = roleBuilder.getUpdate();
        this.delete = roleBuilder.getDelete();
        this.insert = roleBuilder.getInsert();
        this.create = roleBuilder.getCreate();
        this.select = roleBuilder.getSelect();
        this.drop = roleBuilder.getDrop();
        this.grant = roleBuilder.getGrant();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public byte getUpdate() {
        return update;
    }

    public void setUpdate(byte update) {
        this.update = update;
    }

    public byte getDelete() {
        return delete;
    }

    public void setDelete(byte delete) {
        this.delete = delete;
    }

    public byte getInsert() {
        return insert;
    }

    public void setInsert(byte insert) {
        this.insert = insert;
    }

    public byte getCreate() {
        return create;
    }

    public void setCreate(byte create) {
        this.create = create;
    }

    public byte getSelect() {
        return select;
    }

    public void setSelect(byte select) {
        this.select = select;
    }

    public byte getDrop() {
        return drop;
    }

    public void setDrop(byte drop) {
        this.drop = drop;
    }

    public byte getGrant() {
        return grant;
    }

    public void setGrant(byte grant) {
        this.grant = grant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (update != role.update) return false;
        if (delete != role.delete) return false;
        if (insert != role.insert) return false;
        if (create != role.create) return false;
        if (select != role.select) return false;
        if (drop != role.drop) return false;
        if (grant != role.grant) return false;
        return nameRole.equals(role.nameRole);
    }

    @Override
    public int hashCode() {
        int result = nameRole.hashCode();
        result = 31 * result + (int) update;
        result = 31 * result + (int) delete;
        result = 31 * result + (int) insert;
        result = 31 * result + (int) create;
        result = 31 * result + (int) select;
        result = 31 * result + (int) drop;
        result = 31 * result + (int) grant;
        return result;
    }
}
