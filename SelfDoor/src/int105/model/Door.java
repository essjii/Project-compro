/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int105.model;

/**
 *
 * @author Tisanai.Cha
 */
public abstract class Door {
	//Add Code Here
    private int doorId;
    private boolean status;

    public Door() {
        
    }

    public Door(int doorId) {
        this.doorId = doorId;
    }

    public int getDoorId() {
        return doorId;
    }

    public void setDoorId(int doorId) {
        this.doorId = doorId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
       
    public abstract boolean lock();
    public abstract boolean unlock(Key key);
        
}
