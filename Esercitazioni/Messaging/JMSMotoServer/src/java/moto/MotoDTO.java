/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moto;

import java.io.Serializable;

/**
 *
 * @author Roberto
 */
public class MotoDTO implements Serializable {
    private String model;
    private String frame;
    private String tire;

    public MotoDTO() {
    }

    public MotoDTO(String model, String frame, String tire) {
        this.model = model;
        this.frame = frame;
        this.tire = tire;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getTire() {
        return tire;
    }

    public void setTire(String tire) {
        this.tire = tire;
    }

    @Override
    public String toString() {
        return "Moto: {" + "model=" + model + ", frame=" + frame + ", tire=" + tire + '}';
    }
}
