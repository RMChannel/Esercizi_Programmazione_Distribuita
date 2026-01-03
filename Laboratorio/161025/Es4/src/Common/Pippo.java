package Common;

import java.io.Serializable;

public class Pippo implements Serializable {
    private final String temp1="Ciao1";
    private final String temp2="Ciao2";
    private final String temp3="Ciao3";

    public String getTemp1() {
        return temp1;
    }

    public String getTemp2() {
        return temp2;
    }

    public String getTemp3() {
        return temp3;
    }
}
