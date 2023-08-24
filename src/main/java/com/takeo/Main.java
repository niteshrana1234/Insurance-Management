package com.takeo;

import com.takeo.main.ClaimManagementModule;
import com.takeo.main.CustomerManagementModule;
import com.takeo.main.PolicyManagementModule;
import com.takeo.model.Address;
import com.takeo.model.Claim;
import com.takeo.model.Customer;
import com.takeo.model.Policy;

import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static CustomerManagementModule customerManagementModule = new CustomerManagementModule();
    static PolicyManagementModule policyManagementModule = new PolicyManagementModule();
    static ClaimManagementModule claimManagementModule = new ClaimManagementModule();

    public static void main(String[] args) {
        System.out.println("Select module: \n1.Admin \n2.Client");
        int module = scanner.nextInt();
        while (true) {
            if (module == 1) {
                System.out.println("Enter user id:");
                String userId = scanner.next();
                System.out.println("Enter password:");
                String pass = scanner.next();

            } else if (module == 2) {

            } else {
                System.out.println("Invalid input!!");
            }

        }
    }
}
