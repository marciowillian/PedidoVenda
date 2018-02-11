package com.mwcc.pedidovenda.controller;

import com.mwcc.pedidovenda.model.Categoria;
import com.mwcc.pedidovenda.model.Produto;
import com.mwcc.pedidovenda.repository.Categorias;
import com.mwcc.pedidovenda.service.CadastroProdutoService;
import com.mwcc.pedidovenda.util.jsf.FacesUtil;


import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable{

    private static final long serialVersionUID = 1L;

    @Inject
    private Categorias categorias;

    @Inject
    private CadastroProdutoService cadastroProdutoService;

    private Categoria categoriaPai;
    private Produto produto;

    private List<Categoria> categoriasRaizes;
    private List<Categoria> subcategorias;


    public CadastroProdutoBean() {
        limpar();
    }

    public void inicializar(){
        if (FacesUtil.isNotPostBack()){
            categoriasRaizes = categorias.raizes();
        }

    }

    public void carregarSubcategorias(){
        subcategorias = categorias.subcategoriasDe(categoriaPai);
    }

    private void limpar(){
        produto = new Produto();
        categoriaPai = null;
        subcategorias = new ArrayList<>();
    }

    public void salvar(){
        this.cadastroProdutoService.salvar(this.produto);
        limpar();
        FacesUtil.addInfoMessage("Produto salvo com sucesso!");
    }

    public Produto getProduto() {
        return produto;
    }

    public List<Categoria> getCategoriasRaizes() {
        return categoriasRaizes;
    }

    @NotNull
    public Categoria getCategoriaPai() {
        return categoriaPai;
    }

    public void setCategoriaPai(Categoria categoriaPai) {
        this.categoriaPai = categoriaPai;
    }

    public List<Categoria> getSubcategorias() {
        return subcategorias;
    }
}
