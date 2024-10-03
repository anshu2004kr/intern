package org.example.assetmanagement;

import org.hyperledger.fabric.contract.annotation.Default;
import org.hyperledger.fabric.contract.annotation.Property;
import org.hyperledger.fabric.contract.annotation.Transaction;
import org.hyperledger.fabric.contract.ContractInterface;
import org.hyperledger.fabric.contract.Context;

import java.util.HashMap;
import java.util.Map;

@Default
public class AssetManagement implements ContractInterface {

    private final Map<String, Asset> assetList = new HashMap<>();

    public static class Asset {
        public String dealerId;
        public String msisdn;
        public String mpin;
        public double balance;
        public String status;
        public double transAmount;
        public String transType;
        public String remarks;

        public Asset(String dealerId, String msisdn, String mpin, double balance, String status, double transAmount, String transType, String remarks) {
            this.dealerId = dealerId;
            this.msisdn = msisdn;
            this.mpin = mpin;
            this.balance = balance;
            this.status = status;
            this.transAmount = transAmount;
            this.transType = transType;
            this.remarks = remarks;
        }
    }


    @Transaction
    
public void createAsset(Context ctx, String dealerId, String msisdn, String mpin, double balance, String status) {
        Asset asset = new Asset(dealerId, msisdn, mpin, balance, status, 0, "", "");
        assetList.put(dealerId, asset);
    }

    @Transaction
    public Asset getAsset(Context ctx, String dealerId) {
        return assetList.get(dealerId);
    }

    @Transaction
    public void updateAsset(Context ctx, String dealerId, double transAmount, String transType, String remarks) {
        Asset asset = assetList.get(dealerId);
        if (asset != null) {
            asset.transAmount = transAmount;
            asset.transType = transType;
            asset.remarks = remarks;
            asset.balance += transAmount; // Update balance based on transaction type logic
        }
    }

    // You can implement more methods for querying, deleting, etc.
}
plugins {
    id 'java'
    id 'application'
}

repositories {
    mavenCentral();
}

dependencies {
    implementation 'org.hyperledger.fabric:fabric-chaincode-java:2.4.0'
}

mainClassName = 'org.example.assetmanagement.AssetManagement';
public class AssetManagementApp {
    public static void main(String[] args) {
        // Initialize SDK and set up connection to the Fabric network
        // Call chaincode methods using the SDK to manage assets
Asset s=new Asset();
S. Asset(String dealerId, String msisdn, String mpin, double balance, String status, double transAmount, String transType, String remarks);
s. createAsset(Context ctx, String dealerId, String msisdn, String mpin, double balance, String status);
s. updateAsset(Context ctx, String dealerId, double transAmount, String transType, String remarks);


    }
}
