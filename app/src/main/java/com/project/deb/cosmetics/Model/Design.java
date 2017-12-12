package com.project.deb.cosmetics.Model;

/**
 * Created by jose on 12/11/17.
 */

public class Design {

    private int resourceID;
    private String name;

    public Design(){

    }

    public Design(int rid, String name){
        this.resourceID = rid;
        this.name = name;
    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
