package br.com.prog3.Trabfinal.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

public class TrabfinalResource {

	@GetMapping
	public String mensagem() {
		return "Este é meu primeiro webservice. Que legal!!!!!!";
	}
}
