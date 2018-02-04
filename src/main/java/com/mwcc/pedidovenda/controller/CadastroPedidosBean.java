package com.mwcc.pedidovenda.controller;

import com.mwcc.pedidovenda.service.NegocioException;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CadastroPedidosBean {

	private List<Integer> itens;
	
	public CadastroPedidosBean() {
		itens = new ArrayList<Integer>();
		itens.add(1);
		
	}

	public void salvar(){
		throw new NegocioException("Pedido não pode ser salvo, pois ainda não foi implementado.");
	}

	public List<Integer> getItens() {
		return itens;
	}
}
