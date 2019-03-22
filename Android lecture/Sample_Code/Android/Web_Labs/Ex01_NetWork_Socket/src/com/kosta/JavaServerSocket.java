package com.kosta;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaServerSocket {

	public static void main(String[] args) {
	
	 try{
		 
		 int portNumber = 9999;
		 System.out.println("Start Java Server Socket");
		 
		 //1. ServerSocket
		 ServerSocket serversocket = new ServerSocket(portNumber);
		 System.out.println("Listening at port : " + portNumber);
		 
		 while(true){
			 Socket socket =  serversocket.accept();
			 InetAddress clientHost = socket.getLocalAddress();
			 int clientPort = socket.getPort();
			 System.out.println("Client connected host : " + clientHost 
					                         + ", port : " + clientPort );
			 
			 //Client read
			 ObjectInputStream instream = new ObjectInputStream(socket.getInputStream());
			 Object obj = instream.readObject();
			 System.out.println("input : " + obj);
			 
			 
			 //Client Write
			 ObjectOutputStream outstream = new ObjectOutputStream(socket.getOutputStream());
			 outstream.writeObject(obj + "from server");
			 
			 outstream.close();
			 instream.close();
			 
		 }
		 
		 
	 }catch(Exception e){
		 System.out.println(e.getMessage());
	 }
		

	}

}
