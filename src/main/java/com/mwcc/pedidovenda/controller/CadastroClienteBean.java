package com.mwcc.pedidovenda.controller;

import com.mwcc.pedidovenda.model.Cliente;
import com.mwcc.pedidovenda.model.Endereco;
import com.mwcc.pedidovenda.model.Usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Cliente cliente;
	private Endereco endereco;
	private Usuario usuario;



	public void salvar(){
		cliente = new Cliente();
		endereco = new Endereco();
		usuario = new Usuario();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
