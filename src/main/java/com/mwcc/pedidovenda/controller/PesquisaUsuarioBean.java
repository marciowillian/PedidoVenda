package com.mwcc.pedidovenda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PesquisaUsuarioBean {

	private List<String> usuariosFiltrados;
	
	public PesquisaUsuarioBean() {
		usuariosFiltrados = new ArrayList<>();
		
		for(int i = 0; i < 3; i++) {
			usuariosFiltrados.add("João das Couves Junior");
		}
		
	}

	public List<String> getUsuariosFiltrados() {
		return usuariosFiltrados;
	}

	public void setUsuariosFiltrados(List<String> usuariosFiltrados) {
		this.usuariosFiltrados = usuariosFiltrados;
	}

	
	
}
