package com.example.soap_dev.webservices;

import com.example.soap_dev.models.Product;
import com.example.soap_dev.repo.ProdctRepo;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService(serviceName = "ProductWS")
public class ProductWebService {

    ProdctRepo productRepo;

    @WebMethod(operationName = "sellingPrice")
    public Double sellingPrice(@WebParam(name = "Price") Double price) {
        return price * 1.5;
    }

    @WebMethod
    public Product getProduct(Integer code) {
        return productRepo.findById(code)
                .orElseThrow(() -> new RuntimeException("Produit id= " + code + " not found"));

    }

    @WebMethod
    public List<Product> productList() {
        return productRepo.findAll();
    }
}
