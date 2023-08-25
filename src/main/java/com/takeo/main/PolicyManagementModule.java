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

        System.out.print("\nCustomer ID:");
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
        System.out.println("Successfully added new policy");
        System.out.println("Policy ID : "+policyId + ", Policy type : "+ policy.getPolicyType());
    }

    public void modifyPolicy() {
        System.out.print("Enter policy Number: ");
        String policyNum = scanner.next();
        if (verifyPolicy(policyNum)) {
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
        System.out.print("Enter policy Number: ");
        String policyNum = scanner.next();
        if(verifyPolicy(policyNum)){
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

    public Boolean verifyPolicy(String policyNum) {
      Policy policy = policyList.get(policyNum);

        if (policy!=null) {
            Customer customer = CustomerManagementModule.customerList.get(policy.getCustomerId());
            System.out.println("You're verified Mr/s." + customer.getFullName());
            return true;
        } else {
            System.out.println("Invalid information!!");
        }
        return false;
    }
    public Boolean verifyPolicy(int id) {
        Customer customer = CustomerManagementModule.customerList.get(id);

        if (customer!=null) {
            System.out.println("You're verified Mr/s." + customer.getFullName());
            return true;
        } else {
            System.out.println("Invalid information!!");
        }
        return false;
    }

    public void listPolicy(){
        CustomerManagementModule cm = new CustomerManagementModule();
        System.out.print("Enter id:");
        int id = scanner.nextInt();
        if(cm.verifyCustomer(id)){
            Customer customer = CustomerManagementModule.customerList.get(id);
            System.out.println("\n\u001B[4mPolicy holder: " + customer.getFullName() + "\u001B[0m");
//            System.out.println("\nPolicy holder: "+customer.getFullName());
            for(Map.Entry<String,Policy> map : policyList.entrySet()){
                Policy policy = map.getValue();
                if(id == policy.getCustomerId()){
                    System.out.println( "Policy type : "+policy.getPolicyType()+"\nPolicy Number : "+policy.getPolicyNumber()+
                     "\nStart date : "+policy.getStartDate()+"\nEnd date : "+policy.getExpireDate());
                }
                else{
                    System.out.println("No policy found");
                }
            }
        }
        else{
            System.out.println("Id not found");
        }


    }


}
