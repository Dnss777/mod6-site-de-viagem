package com.Mod5.boraAgora.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Mod5.boraAgora.entities.Compra;
import com.Mod5.boraAgora.repositories.ClienteRepository;
import com.Mod5.boraAgora.repositories.CompraRepository;
import com.Mod5.boraAgora.repositories.DestinoRepository;

@Controller
@RequestMapping("/compra")
public class CompraController {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private CompraRepository compraRepository;
	@Autowired
	private DestinoRepository destinoRepository;

	//@Transactional
	@GetMapping
	public ModelAndView reserva() {

		ModelAndView modelAndView = new ModelAndView("Compra/list");
		modelAndView.addObject("listaCliente", clienteRepository.findAll());
		modelAndView.addObject("listaDestino", destinoRepository.findAll());
		modelAndView.addObject("compras", compraRepository.findAll());
		modelAndView.addObject("compra", new Compra());
		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("Compra/form");
		modelAndView.addObject("compra", new Compra());
		modelAndView.addObject("listaCliente", clienteRepository.findAll());
		modelAndView.addObject("listaDestino", destinoRepository.findAll());
		return modelAndView;
	}

    @PostMapping("/cadastrar")
	public ModelAndView cadastrar1(Compra compra) throws IOException {

		ModelAndView modelAndView = new ModelAndView("redirect:/compra");

		compraRepository.save(compra);

		return modelAndView;
	}
	
	  @GetMapping("/{id}/editar")
		public ModelAndView editar(@PathVariable Long id) {
			ModelAndView modelAndView = new ModelAndView("Compra/edit"); //nome da pasta / arquivo html
	 
			Compra compra = compraRepository.getReferenceById(id);
			modelAndView.addObject("listaCliente", clienteRepository.findAll());
			modelAndView.addObject("listaDestino", destinoRepository.findAll());
			modelAndView.addObject("compra", compra);
	 
			return modelAndView;
		}

	@PostMapping({"/{id}/editar"})
	public ModelAndView cadastrar(Compra compra) {
		compraRepository.save(compra);
		ModelAndView modelAndView = new ModelAndView("redirect:/compra");
		return modelAndView;
	}

	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/compra");
		compraRepository.deleteById(id);
		return modelAndView;
	}
}