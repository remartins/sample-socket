package br.com.remartins.chatsocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ProcessSocket implements Runnable {

	private Socket socket;

	public ProcessSocket(Socket socket) {
		super();
		this.socket = socket;
	}

	public void run() {
		String msg = null;
		
		try (DataInputStream di = new DataInputStream(socket.getInputStream());
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());) {
			while (true) {
				msg = di.readUTF();
				System.out.println(msg);
				
				//respondendo ao cliente
				//out.writeUTF("Hey, você enviou: " + msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
