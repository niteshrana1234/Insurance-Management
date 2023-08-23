package com.takeo;

import com.takeo.main.ClaimManagementModule;
import com.takeo.main.CustomerManagementModule;
import com.takeo.main.PolicyManagementModule;
import com.takeo.model.Address;
import com.takeo.model.Customer;
import com.takeo.model.Policy;

import java.util.Date;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static CustomerManagementModule customerManagementModule = new CustomerManagementModule();
    static PolicyManagementModule policyManagementModule = new PolicyManagementModule();

    public static void main(String[] args) {
        // public Address(int buildingNumber, String street, String state, int postalCode, String city, String country)
        Address address = new Address(903,"orange zest lane","texas", 4909,"houston","US");
        Address address1 = new Address(903,"orange zest lane","texas", 4909,"houston","US");

        Customer customer = new Customer("Nitesh Magar","8326917830","01141997",address);
        Customer customer1 = new Customer("Asha Magar","8326917830","01141997",address1);

        customerManagementModule.addCustomer(customer);
        customerManagementModule.addCustomer(customer1);
//        customerManagementModule.modifyCustomerInfo();
//        customerManagementModule.listOfCustomer();

//       Policy policy = new Policy(1,"Home","08-21-2023","08-21-2024");
//       Policy policy1 = new Policy(2,"Auto","2023-08-09","2024-08-09");

        policyManagementModule.userInput();
        policyManagementModule.userInput();

        System.out.println("------------------------------");
        System.out.println("Enter number");
        String num = scanner.next();
        policyManagementModule.removePolicy(num);
        System.out.println("------------------------------");

        policyManagementModule.displayPolicies();






    }
}
