import java.net.*;
import java.util.*;
import java.io.*;
public class Server
{
 public static void main(String args[])
 	{
 	 int portno=7777;
 	 String msgin="s",msgout="s";
 	 Scanner sin = new Scanner(System.in);
 	 System.out.println("While running the server,\nmake sure to Port forward if the client is not connecting locally");
 	 System.out.print("Enter the port number to host: ");
 	 portno = sin.nextInt();
 	 sin.nextLine();
 	 try{
 	 	 ServerSocket servs = new ServerSocket(portno);
 	 	 servs.setSoTimeout(30000);
 	 	 System.out.println("Listening on port " + portno +" for 30 seconds");
 	 	 Socket s_server= servs.accept();
 	 	 System.out.println("Client has connected. waiting for message");
 	 	 System.out.println("Type \"exit\" to end the conversation");
 	 	 DataOutputStream serverout = new DataOutputStream(s_server.getOutputStream());
 	 	 DataInputStream serverin  = new DataInputStream(s_server.getInputStream());
 	 	 while(!(msgout.equals("exit")||msgin.equals("exit")))
 	 	 	{	
 	 	 	 msgin=serverin.readUTF();
 	 	 	 if(msgin.equals("exit"))
 	 	 	  	System.out.println("Client has Disconnected");	
 	 	 	 else
 	 	 	  	{
 	 	 	  	 System.out.println("Client: "+ msgin);
 	 	 	  	 System.out.print("Server: ");	
 	 	 		 msgout=sin.nextLine();
 	 	 		 serverout.writeUTF(msgout);
 	 	 		 if(msgout.equals("exit"))
 	 	 		 	{
 	 	 		 	 System.out.println("Server has Disconnected");
 	 	 		 	 serverout.flush();	
 	 	 		 	}
 	 	 		}
 	 	 	}
 	 	 serverout.close();
 	 	 serverin.close();
 	 	 servs.close();
 		}catch(Exception e)
 		{
 		 System.out.println(e);
 		}
 	}
}
