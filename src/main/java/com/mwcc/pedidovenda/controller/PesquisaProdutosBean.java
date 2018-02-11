package com.mwcc.pedidovenda.controller;

import com.mwcc.pedidovenda.model.Produto;
import com.mwcc.pedidovenda.repository.Produtos;
import com.mwcc.pedidovenda.repository.filter.ProdutoFilter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class PesquisaProdutosBean{

	@Inject
	private Produtos produtos;

	private ProdutoFilter filter;
	private List<Produto> produtosFiltrados;

	public PesquisaProdutosBean(){
		filter= new ProdutoFilter();
	}

	public void pesquisar(){
		produtosFiltrados = produtos.filtrados(filter);
	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public ProdutoFilter getFilter() {
		return filter;
	}
}
