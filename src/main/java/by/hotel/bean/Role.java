package by.hotel.bean;

public class Role {
    private int id;
    private String name;
    private byte update;
    private byte delete;
    private byte insert;
    private byte create;
    private byte select;
    private byte drop;
    private byte grant;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
