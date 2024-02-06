import java.net.ServerSocket;
import java.net.Socket;
import java.net.*;
import java.io.*;
import java.util.*;

public class Server
{
    private ServerSocket server;
    
    public  Server (int a )
    {  try{ server = new ServerSocket(a);
    }
catch(IOException e)
{
    System.out.println(e);
}}
public void startServer()
{  
    try
    {
    while(!server.isClosed())
    {
       Socket socket = server.accept();
       System.out.println("A new client has connected!");
       ClientHandler clientHandler = new ClientHandler(socket);
       Thread thread = new Thread(clientHandler);
       thread.start();
    }
    }
    catch(IOException e)
    {
        System.out.println(e);
    }
}

public void closeServerSocket()
{
    try
    {
        if(server!= null)
        {
            server.close();
        }
    }
        catch(IOException e)
        {
            System.out.println(e);
        }

}
public static void main(String[] args) {
    
     Server server = new Server(5000);
    server.startServer();
    
    
}
}