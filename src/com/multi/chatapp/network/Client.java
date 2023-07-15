package com.multi.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

import com.multi.chatapp.utils.ConfigReader;

public class Client {
	ClientWorker worker;
    Socket socket;
    InputStream in;
    OutputStream out;
    JTextArea textArea;
    InetAddress ip = InetAddress.getLocalHost();
    
	  public Client(JTextArea textArea) throws UnknownHostException, IOException{//constructor 
		int port=Integer.parseInt(ConfigReader.getValue("portno"));
		socket = new Socket(ip, port);//  connection created 
		System.out.println("client comes...");
		this.textArea = textArea;
		in = socket.getInputStream();
		out = socket.getOutputStream();
		readMessage();
			
	}
	
	public void sendMessage(String message) throws IOException {
		message = message + "\n";
		out.write(message.getBytes());
	}
	
	public void readMessage() {
		worker = new ClientWorker(in,textArea);//calling the thread
		worker.start();
	}
	
//	public static void  main(String[] args) throws UnknownHostException, IOException {
//		Client client = new Client();
//		
//	}
}
