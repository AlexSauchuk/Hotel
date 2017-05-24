package by.hotel.builder;

import by.hotel.bean.Role;

public class RoleBuilder {
    private int id;
    private String nameRole;
    private byte update;
    private byte delete;
    private byte insert;
    private byte create;
    private byte select;
    private byte drop;
    private byte grant;

    public RoleBuilder id(int id) {
        this.id = id;
        return this;
    }

    public RoleBuilder nameRole(String namRole) {
        this.nameRole = namRole;
        return this;
    }

    public RoleBuilder update(byte update) {
        this.update = update;
        return this;
    }

    public RoleBuilder delete(byte delete) {
        this.delete = delete;
        return this;
    }

    public RoleBuilder insert(byte insert) {
        this.insert = insert;
        return this;
    }

    public RoleBuilder create(byte create) {
        this.create = create;
        return this;
    }

    public RoleBuilder select(byte select) {
        this.select = select;
        return this;
    }

    public RoleBuilder drop(byte drop) {
        this.drop = drop;
        return this;
    }

    public RoleBuilder grant(byte grant) {
        this.grant = grant;
        return this;
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

    public Role build() {
        return new Role(this);
    }
}
