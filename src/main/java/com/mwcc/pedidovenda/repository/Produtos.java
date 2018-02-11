package com.mwcc.pedidovenda.repository;

import com.mwcc.pedidovenda.model.Produto;
import com.mwcc.pedidovenda.repository.filter.ProdutoFilter;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Produtos implements Serializable {
    private static final long serialVersionUID = 1L;


    @Inject
    private EntityManager manager;

    private Produto produtosBuscados;


    public Produto guardar(Produto produto) {

        return produto = manager.merge(produto);

    }

    public Produto porSku(String sku) {

        try {
            return manager.createQuery("from Produto where upper(sku) = :sku",
                    Produto.class).setParameter("sku", sku.toUpperCase()).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Produto> filtrados(ProdutoFilter filtro){

        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Produto.class);

        if (StringUtils.isNotBlank(filtro.getSku())){
            criteria.add(Restrictions.eq("sku", filtro.getSku()));
        }

        if (StringUtils.isNotBlank(filtro.getNome())){
            criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
        }

        return criteria.addOrder(Order.asc("nome")).list();

    }

}
