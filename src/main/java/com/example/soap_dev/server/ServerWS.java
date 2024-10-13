package com.example.soap_dev.server;

import com.example.soap_dev.SoapDevApplication;
import com.example.soap_dev.models.Product;
import com.example.soap_dev.repo.ProdctRepo;
import jakarta.xml.ws.Endpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.soap_dev.webservices.ProductWebService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ServerWS implements CommandLineRunner {
    @Autowired
    private ProdctRepo productRepo;

    public static void main(String[] args){
        String url = "http://localhost:8088/";
        Endpoint.publish(url, new ProductWebService());
        System.out.println(url + " deployed");
        SpringApplication.run(SoapDevApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Product> products = List.of(
                new Product(1, "cheese", 30.00, new Date()),
                new Product(2, "Table", 300.00, new Date()),
                new Product(3, "Tableaux", 700.00, new Date()),
                new Product(4, "Tablette", 3000.00, new Date())
        );
        productRepo.saveAll(products);
    }
}
