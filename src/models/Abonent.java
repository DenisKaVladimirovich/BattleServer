package models;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InterfaceAddress;
import java.net.Socket;

/**
 * Created by 26str on 19.02.2017.
 */
public class Abonent extends Thread {
    private Socket socket;
    private static InputStream inputStream;
    private static OutputStream outputStream;
    public Abonent(Socket socket) throws IOException
    {
        this.socket=socket;
        inputStream = this.socket.getInputStream();
        outputStream = this.socket.getOutputStream();
        start();

    }

    @Override
    public void run()
    {
            while (true)
            {
                    try {
                        if (inputStream.available() > 0) {
                            System.out.println("Have messege\n");

                            byte[] bytes = new byte[1024];
                            int length;
                            length = inputStream.read(bytes);
                            System.out.println(length);
                            String result =new String(bytes, 0, length);
                            System.out.println(result);
                            String[] parse = result.split("-");
                            String code = parse[0];
                            System.out.print("Operationcode:  "+ code);
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                try {
                    Thread.sleep(33);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
    }
}
