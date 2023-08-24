package com.takeo;

import com.takeo.main.ClaimManagementModule;
import com.takeo.main.CustomerManagementModule;
import com.takeo.main.PolicyManagementModule;
import com.takeo.model.*;

import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static String username = "admin";
    static String password = "password";

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
                String userId = scanner.next().toLowerCase();
                System.out.println("Enter password:");
                String pass = scanner.next().toLowerCase();
                if (username.equals(userId) && password.equals(pass)) {
                    Menu.adminMenu();
                    switch (scanner.nextInt()) {
                        case 1:
                            customerManagementModule.addCustomer(customerManagementModule.customerInput());
                            break;

                        case 2:
                            customerManagementModule.removeCustomer();
                            break;

                        case 3:
                            policyManagementModule.removePolicy();
                            break;

                        case 4:
                            claimManagementModule.ModifyStatus();
                            break;

                    }
                }

            } else if (module == 2) {
                if (customerManagementModule.customerLogin()) {

                    Menu.clientMenu();
                    switch (scanner.nextInt()) {
                        case 1:
                            customerManagementModule.modifyCustomerInfo();
                            break;

                        case 2:
                            policyManagementModule.addPolicy();
                            break;
                        case 3:
                            policyManagementModule.modifyPolicy();
                            break;
                        case 4:
                            claimManagementModule.fileClaim();
                            break;
                        case 5:
                            claimManagementModule.claimStatus();
                            break;

                    }


                } else {
                    System.out.println("Login failed");
                }


            } else {
                System.out.println("Invalid input!!");
            }

        }
    }
}
