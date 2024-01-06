package com.giorgia.apidynamodb.model;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.util.UUID;

@DynamoDbBean
public class Pessoas {
    private String id;
    private String email;
    private String nome;
    @DynamoDbPartitionKey
    public String getId() {
        this.id = UUID.randomUUID().toString();
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @DynamoDbAttribute(value = "email")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @DynamoDbAttribute(value = "nome")
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
