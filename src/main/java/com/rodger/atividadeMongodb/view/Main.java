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

        VendaDao dao = new VendaDao();

        //System.out.println(dao.listar_venda());

        //PARTE 1 - salva os itens na "tabela" Venda
//        Produto produto1 = new Produto(1, "Teclado", 30);
//        Produto produto2 = new Produto(2, "Mouse", 20);
//        Produto produto3 = new Produto(3, "Monitor", 20);
//
//        ItemVenda item1 = new ItemVenda(produto1, 1);
//        ItemVenda item2 = new ItemVenda(produto2, 2);
//        ItemVenda item3 = new ItemVenda(produto3, 3);
//
//        List<ItemVenda> itens = new ArrayList<>();
//        List<ItemVenda> itens2 = new ArrayList<>();
//
//        itens.add(item1);
//        itens.add(item2);
//
//        itens2.add(item1);
//        itens2.add(item3);
//
//        Venda venda = new Venda(1, itens, LocalDateTime.now());
//        Venda venda2 = new Venda(2, itens, LocalDateTime.now());
//
//        dao.salvar_venda(venda);
//        dao.salvar_venda(venda2);

        //PARTE 2 - deletar item com codigo 2 da "tabela" Venda

//        dao.deletar_venda(1);


        //PARTE 3 - inserir item em venda existente

        Produto produto3 = new Produto(3, "Monitor", 20);

        ItemVenda item = new ItemVenda(produto3, 1);

        dao.insereItem_venda(2, item);

    }

}
