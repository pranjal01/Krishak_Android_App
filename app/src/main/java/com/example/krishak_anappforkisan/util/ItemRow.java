package com.example.krishak_anappforkisan.util;


public class ItemRow {
    private String title, desc;
    private String  connectedWith;

    public ItemRow() {
    }

    public ItemRow(String title,  String desc, String connectedWith) {
        this.title = title;
        this.desc = desc;
        this.connectedWith = connectedWith;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getConnectedWith() {
        return connectedWith;
    }

    public void setConnectedWith(String connectedWith) {
        this.connectedWith = connectedWith;
    }
}