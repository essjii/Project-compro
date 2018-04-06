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
public class ElectronicDoor extends Door{

    private String identifyCode;
    private String model;

    public ElectronicDoor(int doorId, String identifyCode, String model) {
        super(doorId);
        this.identifyCode = identifyCode;
        this.model = model;
    }

    //Add Code Here

    public String getIdentifyCode() {
        return identifyCode;
    }

    public void setIdentifyCode(String identifyCode) {
        this.identifyCode = identifyCode;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    @Override
    public boolean lock(){
        super.setStatus(false);
        return isStatus();
    }
    
    @Override
    public boolean unlock(Key key){
        Card theKey = new Card();
        theKey = (Card)key;
        if(this.identifyCode.equalsIgnoreCase(theKey.getIdentifyCode())){
            super.setStatus(true);
            return isStatus();
        }
        return super.isStatus();
    }

    @Override
    public String toString() {
        return "ElectronicDoor{" + "identifyCode=" + identifyCode + ", model=" + model + '}';
    }


}
