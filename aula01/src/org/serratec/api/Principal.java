package org.serratec.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner leitura = new Scanner(System.in);
		
		System.out.println("Digite o cep desejado: ");
		var cep = leitura.nextLine();
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		         .uri(URI.create("https://viacep.com.br/ws/" + cep + "/json/"))
		         .build();
		   
		HttpResponse<String> response = client
			     .send(request, BodyHandlers.ofString()); 
		System.out.println(response.body());

	}

}
