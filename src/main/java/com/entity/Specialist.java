package com.entity;

public class Specialist {
    private int id;
    private String specalistname;

    public Specialist(){
        super();
    }


    public Specialist(int id,String specalistname){
        super();
        this.id=id;
        this.specalistname=specalistname;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecalistname() {
        return specalistname;
    }

    public void setSpecalistname(String specalistname) {
        this.specalistname = specalistname;
    }
}
