package utils;

import models.Abonent;
import models.Abonents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 26str on 19.02.2017.
 */
public class ServerHandler extends Thread{

    private static ServerSocket serverSocket;
    public Abonents abonents;
    public ServerHandler(ServerSocket serverSocket)
    {
        this.serverSocket = serverSocket;
        start();
        abonents = new Abonents();
    }



    private void end()
    {
        try {
            serverSocket.close();
            System.out.println("Server close");
        }catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        while (true)
        {
            try {
                Socket client = serverSocket.accept();
                Abonent abonent = new Abonent(client);
                abonents.addPlayer(abonent);

                System.out.print("Abonent connected:" + client.getInetAddress()+":"+client.getPort()+"\n");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                Thread.sleep(33);
            }catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
