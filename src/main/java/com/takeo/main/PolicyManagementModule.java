package com.takeo.main;

import com.takeo.model.Customer;
import com.takeo.model.Policy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PolicyManagementModule {
    LocalDate today = LocalDate.now();
    LocalDate expirationDate = today.plusYears(1);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    static Scanner scanner = new Scanner(System.in);
   public static Map<String,Policy> policyList = new HashMap<>();
    CustomerManagementModule customerManagementModule = new CustomerManagementModule();

    public String generateRandom(){
        Random random = new Random();
        int randomNum = random.nextInt(999)+100;

        while(policyList.containsKey(randomNum)){
            randomNum = random.nextInt(999)+100;
        }
        return "P" + randomNum;
    }
    public void addPolicy(){

        System.out.println("Customer ID:");
        int id = scanner.nextInt();
        if(verifyPolicy(id)){
            System.out.println("Pick a policy type, Enter a number:");
            System.out.println("1.Home insurance \n2.Auto insurance \n3.Health insurance");
            String policyType = "";
            int input = scanner.nextInt();
            if(input == 1){
                policyType = "Home";
            } else if(input == 2){
                policyType = "Auto";
            }
            else if(input == 3){
                policyType = "Health";
            }
            String startDate = today.format(formatter);
            String expirationDates = expirationDate.format(formatter);
            Policy policy = new Policy(id,policyType,startDate,expirationDates);
            savePolicy(policy);
        }else {
            System.out.println("No matched id found");
        }


    }
    public void savePolicy(Policy policy) {
        String policyId = generateRandom();
        policy.setPolicyNumber(policyId);
        policyList.put(policyId,policy);
        System.out.println("Policy ID : "+policyId + ", Policy type : "+ policy.getPolicyType());
    }

    public void modifyPolicy() {
        System.out.println("Customer ID:");
        int id = scanner.nextInt();
        System.out.println("Enter policy Number: ");
        String policyNum = scanner.next();
        if (verifyPolicy(id)) {
            System.out.println("Pick a policy type, Enter a number:");
            System.out.println("1.Home insurance \n2.Auto insurance \n3.Health insurance");
            String policyType = "";
            int input = scanner.nextInt();
            if (input == 1) {
                policyType = "Home";
            } else if (input == 2) {
                policyType = "Auto";
            } else if (input == 3) {
                policyType = "Health";
            }
            Iterator <Map.Entry<String,Policy>> iterator = policyList.entrySet().iterator();
            while(iterator.hasNext()){
                Policy policy = iterator.next().getValue();
                if(policy.getPolicyNumber().equals(policyNum)){
                    policy.setPolicyType(policyType);
                    break;
                }
            }

        }
        else{
            System.out.println("No match policy found");
        }
    }

    public void removePolicy() {
        System.out.println("Enter customer id: ");
        int id = scanner.nextInt();
        System.out.println("Enter policy Number: ");
        String policyNum = scanner.next();
        if(verifyPolicy(id)){
            Iterator <Map.Entry<String,Policy>> iterator = policyList.entrySet().iterator();
            while(iterator.hasNext()){
                Policy policy = iterator.next().getValue();
                if(policy.getPolicyNumber().equals(policyNum)){
                    iterator.remove();
                    break;
                }
            }
        } else {
            System.out.println("No matched policy found with given information");
        }

    }

    public void displayPolicies() {
        for (Map.Entry<String,Policy> map : policyList.entrySet()) {
            Customer customer = CustomerManagementModule.customerList.get(map.getValue().getCustomerId());
            System.out.println("Full name : "+ customer.getFullName() +", Policy type : " + map.getValue().getPolicyType() +
                    ", Policy no. : " + map.getValue().getPolicyNumber()+", Start date : "+  map.getValue().getStartDate()+
                    ", Expire date : "+ map.getValue().getExpireDate());

        }

    }

    public Boolean verifyPolicy(int id) {
        Customer customer = CustomerManagementModule.customerList.get(id);

        if (customer!=null) {
            String name = customer.getFullName();
            System.out.println("You're verified Mr/s." + name);
            return true;
        } else {
            System.out.println("Invalid information!!");
        }
        return false;
    }
}
