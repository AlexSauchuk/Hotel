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
}
