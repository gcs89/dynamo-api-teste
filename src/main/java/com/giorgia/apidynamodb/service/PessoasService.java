package com.giorgia.apidynamodb.service;

import com.giorgia.apidynamodb.model.Pessoas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.util.stream.Collectors;

@Service
public class PessoasService {
    private final DynamoDbTable<Pessoas> pessoasDynamoDbTable;
    @Autowired
    public PessoasService(DynamoDbClient dynamoDbClient) {
        DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClient)
                .build();

        this.pessoasDynamoDbTable = enhancedClient.table("Pessoas", TableSchema.fromBean(Pessoas.class));
    }

    public Iterable<Pessoas> getAll(){
        PageIterable<Pessoas> result = pessoasDynamoDbTable.scan();
        return result.items().stream().collect(Collectors.toList());
    }

    public void save (Pessoas pessoas){
        pessoasDynamoDbTable.putItem(pessoas);
    }

    public Pessoas findById(String id) {
        return pessoasDynamoDbTable.getItem(r -> r.key(k -> k.partitionValue(id)));
    }


}
