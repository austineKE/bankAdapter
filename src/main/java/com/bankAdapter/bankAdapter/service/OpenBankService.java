package com.bankAdapter.bankAdapter.service;

import com.bankAdapter.bankAdapter.openBankObj.Transaction;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class OpenBankService {
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactionList = new ArrayList<>();
        try {
            URL url = new URL("http://localhost:8080/transaction/list");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            String output;
            System.out.println("Default port "+url.getDefaultPort());
            System.out.println("\nOutput from Server .... ");
            ObjectMapper mapper = new ObjectMapper();

            while ((output = br.readLine()) != null) {
                System.out.println(output);
                    transactionList = mapper.readValue(output, new
                        TypeReference<List<Transaction>>() {
                        });
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return transactionList;
    }

    public List<Transaction> getAllTransactionsBasedOnType(String type){
        List<Transaction> list=new ArrayList<>();
        try {
            URL url = new URL("http://localhost:8080/transaction/list/"+ type);
            HttpURLConnection con= (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept","application/json");
            if (con.getResponseCode() != 200)
                throw new RuntimeException("Failed : Http Response code "+con.getResponseCode());
            BufferedReader reader=new BufferedReader(new InputStreamReader(con.getInputStream()));
            String output;
            System.out.println("Default port "+url.getFile());
            System.out.println("\nOutput from server ......");
            ObjectMapper mapper=new ObjectMapper();
            while ((output=reader.readLine()) != null){
                System.out.println(output);
                list=mapper.readValue(output, new
                        TypeReference<List<Transaction>>() {
                        });
            }
            con.disconnect();
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
}

    public Double getTotalTransactionsAmountBasedOnType(String type) {
        double transactionAmount=0;
        try {
            URL url = new URL("http://localhost:8080/totalAmount/"+ type);
            HttpURLConnection con= (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept","application/json");
            if (con.getResponseCode() != 200){
                throw new RuntimeException("Failed : Http Response code "+con.getResponseCode());
            }
            BufferedReader reader=new BufferedReader(new InputStreamReader(con.getInputStream()));
            transactionAmount=reader.read();
            con.disconnect();
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactionAmount;
    }
}
