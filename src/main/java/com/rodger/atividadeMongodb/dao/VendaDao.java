package com.rodger.atividadeMongodb.dao;

import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.rodger.atividadeMongodb.database.MongoConnectionPojo;
import com.rodger.atividadeMongodb.model.ItemVenda;
import com.rodger.atividadeMongodb.model.Venda;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.push;

public class VendaDao {

    private MongoCollection collection;

    public VendaDao(){
        collection = new MongoConnectionPojo()
                .getCollection("Venda", Venda.class);

        collection.createIndex(new Document()
                        .append("codigo", 1),
                new IndexOptions().unique(true)
        );
    }

    public void salvar_venda(Venda venda){
        collection.insertOne(venda);
    }

    //lista todas as vendas, caso exista
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
        if  (buscar_venda(codigo) != null) {
            UpdateResult result = collection.updateOne(eq("codigo", codigo),
                                                       push("itens", new Document("produto", item.getProduto())
                                                       .append("quantidade", item.getQuantidade())));
            return result.getModifiedCount() > 0;
        }

        return false;

    }

}
