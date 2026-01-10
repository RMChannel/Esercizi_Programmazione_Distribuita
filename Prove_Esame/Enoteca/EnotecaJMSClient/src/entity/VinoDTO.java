/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author Roberto
 */
public class VinoDTO implements Serializable {
    private int id;
    private int bottiglie;
    
    public VinoDTO() {}

    public VinoDTO(int id, int bottiglie) {
        this.id = id;
        this.bottiglie = bottiglie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBottiglie() {
        return bottiglie;
    }

    public void setBottiglie(int bottiglie) {
        this.bottiglie = bottiglie;
    }
    
    
}
