package com.mwcc.pedidovenda.controller;

import com.mwcc.pedidovenda.model.EnderecoEntrega;
import com.mwcc.pedidovenda.model.Pedido;
import com.mwcc.pedidovenda.service.NegocioException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class CadastroPedidosBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Pedido pedido;
	private List<Integer> itens;
	
	public CadastroPedidosBean() {
		pedido = new Pedido();
		pedido.setEnderecoEntrega(new EnderecoEntrega());
		itens = new ArrayList<Integer>();
		itens.add(1);
		
	}

	public void salvar(){
		throw new NegocioException("Pedido não pode ser salvo, pois ainda não foi implementado.");
	}

	public List<Integer> getItens() {
		return itens;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}
