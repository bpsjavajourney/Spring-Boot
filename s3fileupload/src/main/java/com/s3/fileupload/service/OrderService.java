package com.s3.fileupload.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.s3.fileupload.model.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final S3Client s3Client;
    private final ObjectMapper objectMapper;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    public OrderService(S3Client s3Client) {
        this.s3Client = s3Client;
        this.objectMapper = new ObjectMapper();
    }

    public String uploadListOfOrders(List<Order> orders) throws Exception {
        String json = objectMapper.writeValueAsString(orders);
        String key = "orders/orders_" + UUID.randomUUID() + ".json";

        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .contentType("application/json")
                .build();

        s3Client.putObject(putObjectRequest, software.amazon.awssdk.core.sync.RequestBody.fromString(json));
       
    // S3 automatically provides checksum validation for uploaded objects.
    // You can retrieve the checksum from the PutObjectResponse if needed.
    // No need to manually calculate checksum here.
   // software.amazon.awssdk.services.s3.model.PutObjectResponse response = s3Client.putObject(putObjectRequest, software.amazon.awssdk.core.sync.RequestBody.fromString(json));
   // String checksum = response.checksumSHA256();
    // Optionally, you can validate or log the checksum here

        return key;
    }
}