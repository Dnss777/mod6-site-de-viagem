package com.Mod5.boraAgora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

	@GetMapping(value = { "/", "/index.html" })
	public String home() {
		return "index.html";
	}

	@GetMapping("/promocoes")
	public String promocao() {
		return "Compra/promocao";
	}

	@GetMapping("/destino")
	public String destino() {
		return "Destino/destino";
	}

	@GetMapping("/contato")
	public String contato() {
		return "/contato";

	}

	@GetMapping("/entrar")
	public String entrar() {
		return "/entrar";
	}

	@GetMapping("/cadastro")
	public String cadastro() {
		return "/cadastro";
	}

}
