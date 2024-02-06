import java.util.*;
import java.net.*;
import java.io.*;
import java.net.Socket;
public class Client {
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String username;

    public Client ( String username)
    {try { 
        socket = new Socket("127.0.0.1",5000);
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.username = username;

    }
    catch(IOException e)
       {
        closeEverything(socket , bufferedReader , bufferedWriter);

       } 
    }
       public void sendMessage()
       {
        try
        {
            bufferedWriter.write(username);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            
            Scanner sc = new Scanner(System.in);
            while(socket.isConnected())
            {
                String messageToSend = sc.nextLine();
                bufferedWriter.write(username + ": " + messageToSend);
                bufferedWriter.newLine();
                bufferedWriter.flush();

            }
        }
        catch(IOException e)
       {
        closeEverything(socket , bufferedReader , bufferedWriter);

       } 
       }
       public void listenformessage()
       {
        new Thread(new Runnable()
        {
            public void run()
            {
              String messagefromgroupchat;
              while(socket.isConnected())
              {
                try{
                    messagefromgroupchat = bufferedReader.readLine();
                    System.out.println(messagefromgroupchat);
                }
                catch(IOException e)
       {
        closeEverything(socket , bufferedReader , bufferedWriter);

       } 
              }

            }
        }).start();
       }
       public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter)
    {

      try{
        if(bufferedReader!=null)
        {
            bufferedReader.close();
        }
        if(bufferedWriter!=null)
        {
            bufferedWriter.close();
        }
        if(socket!=null)
        {
            socket.close();
        }
      }
      catch(IOException e)
      {
        e.printStackTrace();
      }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username for group chat : ");
        String username = sc.nextLine();
        
    Client client = new Client(username);
    client.listenformessage();
    client.sendMessage();
    }
}


