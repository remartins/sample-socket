package br.com.remartins.chatsocket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import br.com.remartins.chatsocket.ProcessSocket;

public class Server {
	
	private int port;

	public Server(int port) {
		super();
		this.port = port;
	}
	
	public static void main(String[] args) {
		Server server = new Server(1234);
		server.start();
	}
	
	public void start() {
		Socket socket = null;

		try (ServerSocket serverSocket = new ServerSocket(port)) {
			while (true) {
				socket = serverSocket.accept();
				new Thread(new ProcessSocket(socket)).start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null)
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}
