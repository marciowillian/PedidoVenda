package com.mwcc.pedidovenda.service;

import com.mwcc.pedidovenda.model.Produto;
import com.mwcc.pedidovenda.repository.Produtos;
import com.mwcc.pedidovenda.util.jpa.Transactional;

import javax.inject.Inject;
import java.io.Serializable;

public class CadastroProdutoService implements Serializable{

    private static final long serialVersionUID = 1L;

    @Inject
    private Produtos produtos;

    @Transactional
    public Produto salvar(Produto produto){

        Produto produtoExistente = produtos.porSku(produto.getSku());

        if (produtoExistente != null){
            throw new NegocioException("Já existe um produto com SKU informado.");
        }

        return produtos.guardar(produto);
    }

}
