package com.rodger.atividadeMongodb.view;

import com.rodger.atividadeMongodb.dao.PessoaDao;
import com.rodger.atividadeMongodb.dao.VendaDao;
import com.rodger.atividadeMongodb.model.ItemVenda;
import com.rodger.atividadeMongodb.model.Pessoa;
import com.rodger.atividadeMongodb.model.Produto;
import com.rodger.atividadeMongodb.model.Venda;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        PessoaDao dao = new PessoaDao();
//
//        dao.salvar(new Pessoa("222.222.222-02", "Maria", 19));
//
//        System.out.println(dao.listar());
//
//        System.out.println(dao.buscarPorCpf("XXX"));
//
//        dao.atualizar(new Pessoa("111.111.111-01",
//                "João Paulo", 22));

        VendaDao dao = new VendaDao();

        System.out.println(dao.listar());

//        Produto produto1 = new Produto(1, "Teclado", 30);
//        Produto produto2 = new Produto(2, "Mouse", 20);
//
//        ItemVenda item1 = new ItemVenda(produto1, 1);
//        ItemVenda item2 = new ItemVenda(produto2, 2);
//
//        List<ItemVenda> itens = new ArrayList<>();
//        itens.add(item1);
//        itens.add(item2);
//
//        Venda venda = new Venda(1, itens, LocalDateTime.now());
//
//        dao.salvar(venda);


    }

}
