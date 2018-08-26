package com.rodger.atividadeMongodb.dao;

import com.mongodb.client.result.DeleteResult;
import com.rodger.atividadeMongodb.database.MongoConnectionPojo;
import com.rodger.atividadeMongodb.model.ItemVenda;
import com.rodger.atividadeMongodb.model.Venda;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class VendaDao {

    private MongoCollection collection;

    public VendaDao(){
        collection = new MongoConnectionPojo()
                .getCollection("Venda", Venda.class);
    }

    public void salvar_venda(Venda venda){
        collection.insertOne(venda);
    }

    public List<Venda> listar_venda(){
        MongoCursor cursor = collection.find().iterator();

        List<Venda> vendas = new ArrayList<>();

        while (cursor.hasNext()){
            vendas.add((Venda) cursor.next());
        }

        return vendas;
    }


    //buscar vendas por código
    public Venda buscar_venda(int codigo){
        MongoCursor cursor = collection.find(eq("codigo", codigo)).iterator();

        return (Venda) cursor.next();
    }

    //deletar vendas por código
    public boolean deletar_venda(int codigo) {
        DeleteResult result = collection.deleteOne(eq("codigo", codigo));

        return result.getDeletedCount() > 0;
    }

    //insere um ítem de venda em uma venda, caso ela exista
    public boolean insereItem_venda(int codigo, ItemVenda item) {
        return Boolean.parseBoolean(null + "Not work yet :(");
    }
}
