package br.org.serratec.streamer.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ConsumoApi {

	private static String buscaDados(String endereco) {
		HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(endereco)).build();

		HttpResponse<String> response = null;

		try {
			response = client.send(request, BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		return response.body();
	}
	
	
	public static String obterDados(String titulo) {
		String endereco = "https://www.omdbapi.com/?t=" 
				+ titulo.replace(" ", "+") 
				+ "&apikey=6585022c";

		return buscaDados(endereco);
	}

	public static String obterDados(String titulo, int temporada) {
		String endereco = "https://www.omdbapi.com/?t=" 
				+ titulo.replace(" ", "+") 
				+ "&season=" + temporada
				+ "&apikey=6585022c";

		return buscaDados(endereco);
	}
}
