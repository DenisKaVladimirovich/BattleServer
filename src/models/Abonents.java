package models;

import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by 26str on 19.02.2017.
 */
public class Abonents {

    public ArrayList<Abonent> abonents = new ArrayList<Abonent>();

    public void addPlayer(Abonent abonent)
    {
        abonents.add(abonent);
    }


    public void rmPlayer(Abonent abonent)
    {
        abonents.remove(abonent);
    }

}
