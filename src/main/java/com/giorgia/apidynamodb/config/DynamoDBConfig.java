package com.giorgia.apidynamodb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class DynamoDBConfig {
    @Value("${aws.access.key}")
    private String awsAccessKey;

    @Value("${aws.secret.key}")
    private String awsSecretKey;

    @Bean
    public DynamoDbClient dynamoDbClient(){
        return DynamoDbClient.builder()
                .region(Region.SA_EAST_1)
                .credentialsProvider(() -> AwsBasicCredentials.create(awsAccessKey,awsSecretKey))
                .build();
    }

//    @Bean
//    public DynamoDbClient dynamoDbClient() {
//        return DynamoDbClient.builder()
//                .credentialsProvider(DefaultCredentialsProvider.create())
//                .region(Region.SA_EAST_1)
//                .build();
//    }
}
