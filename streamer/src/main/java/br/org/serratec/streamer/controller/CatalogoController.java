package br.org.serratec.streamer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.streamer.dto.DadosEpisodio;
import br.org.serratec.streamer.dto.DadosTitulo;
import br.org.serratec.streamer.service.CatalogoService;

@RestController
@RequestMapping("/catalogo")
public class CatalogoController {
	
	@Autowired
	private CatalogoService servico;
	
	@GetMapping
	public DadosTitulo obterDados(@RequestParam String titulo) {
		return servico.obterDados(titulo);
	}
	
	@GetMapping("/episodios")
	public List<DadosEpisodio> obterEpisodios(@RequestParam String titulo,
			@RequestParam int temporada) {
		return servico.obterDadosEpisodio(titulo, temporada);
	}

}
