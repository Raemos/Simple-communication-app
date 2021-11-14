import java.net.*;
import java.util.*;
import java.io.*;
public class Client
{
 public static void main(String args[])
 	{
 	 int portno=7777;
 	 String ipaddress = "localhost",msgout="s",msgin="s";
 	 Scanner sin = new Scanner(System.in);
 	 System.out.print("Enter the Ip address: ");
 	 ipaddress = sin.nextLine();
 	 System.out.print("Enter the port number: ");
 	 portno = sin.nextInt();
 	 sin.nextLine();
 	 try{
 	 	 Socket s_client = new Socket(ipaddress,portno);
 	 	 System.out.println("You are now connected. Send the first message");
 	 	 System.out.println("Type \"exit\" to end the conversation");
 	 	 DataOutputStream clientout = new DataOutputStream(s_client.getOutputStream());
 	 	 DataInputStream clientin = new DataInputStream(s_client.getInputStream()); 
 	 	 while(!(msgout.equals("exit")||msgin.equals("exit")))
 	 	 	{
 	 	 	 System.out.print("Client: ");	
 	 	 	 msgout = sin.nextLine();
 	 	 	 clientout.writeUTF(msgout);
 	 	 	 if(msgout.equals("exit"))
 	 	 	 	{
 	 	 	 	 System.out.println("Client has Disconnected");	
 	 	 	 	 clientout.flush();
 	 	 	 	}
 	 	 	 else
 	 	 	    {
 	 	 	     msgin=clientin.readUTF();
 	 	 	     if(msgin.equals("exit"))
 	 	 	     	{
 	 	 	     	 System.out.println("Server has Disconnected");
 	 	 	     	}
 	 	 	     else
 	 	 	     	{
 	 	 	     	 System.out.println("Server: "+msgin);
 	 	 	     	}	
 	 	 	 	}	
 	 	 	} 
 	 	 clientin.close();	
 	 	 clientout.close();	
 	 	 s_client.close();	
 	 	}catch(Exception e)
 	 	{
 	     System.out.println(e);
 	 	}
 	}	
}
