import models.Abonents;
import utils.ServerHandler;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by 26str on 19.02.2017.
 */
public class Server {
    static ServerSocket serverSocket;
    public Server()
    {
        Abonents abonents = new Abonents();
    }


    public static void main(String[] args)
    {
        try {
            serverSocket = new ServerSocket(9154);
            System.out.println("Server start at port "+serverSocket.getLocalPort());
            ServerHandler serverHandler = new ServerHandler(serverSocket);
        }catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
