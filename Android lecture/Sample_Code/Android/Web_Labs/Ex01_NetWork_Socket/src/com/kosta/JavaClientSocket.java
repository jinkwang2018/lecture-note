package com.kosta;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class JavaClientSocket {

	public static void main(String[] args) {
		try{
			int portNumber=9999;
			Socket socket = new Socket("192.168.0.50",portNumber);
			
			//Server Write
			ObjectOutputStream outstream = new ObjectOutputStream(socket.getOutputStream());
			outstream.writeObject("Hello Android Data");
			outstream.flush();
			
			ObjectInputStream instream = new ObjectInputStream(socket.getInputStream());
			Object obj = instream.readObject();
			System.out.println("return server data : " + obj);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
