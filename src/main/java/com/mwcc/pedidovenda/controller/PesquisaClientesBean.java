package com.mwcc.pedidovenda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PesquisaClientesBean {
	
	private List<String> clientesFiltrados;
	
	public PesquisaClientesBean() {
		clientesFiltrados =  new ArrayList<>();
		for(int i = 0; i <3; i++) {
			clientesFiltrados.add("Supermercado João das Couves LTDA");
		}
	}

	public List<String> getClientesFiltrados() {
		return clientesFiltrados;
	}
	
	
}
