package br.com.remartins.chatsocket.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import br.com.remartins.chatsocket.ProcessSocket;


public class Client {

	public static void main(String[] args) {

		try (
				Socket cliente = new Socket("127.0.0.1", 1234);
				DataOutputStream out = new DataOutputStream(cliente.getOutputStream());
				Scanner scanner = new Scanner(System.in);	
			) {

			String msg = null;
			
			new Thread(new ProcessSocket(cliente)).start();

			while (true) {
				System.out.print("Mensagem > ");
				msg = scanner.nextLine();
				out.writeUTF(msg);
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
