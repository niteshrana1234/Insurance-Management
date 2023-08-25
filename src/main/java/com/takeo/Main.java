package com.takeo;

import com.takeo.main.ClaimManagementModule;
import com.takeo.main.CustomerManagementModule;
import com.takeo.main.PolicyManagementModule;
import com.takeo.model.*;

import java.util.Scanner;

public class Main {

    static String username = "admin";
    static String password = "password";

    static Scanner scanner = new Scanner(System.in);
    static CustomerManagementModule customerManagementModule = new CustomerManagementModule();
    static PolicyManagementModule policyManagementModule = new PolicyManagementModule();
    static ClaimManagementModule claimManagementModule = new ClaimManagementModule();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nSelect module: \n1.Admin \n2.Client \n3.Exit");
            int module = scanner.nextInt();
            switch (module) {
                case 1:
//                    System.out.println("Enter user id:");
//                    String userId = scanner.next().toLowerCase();
//                    System.out.println("Enter password:");
//                    String pass = scanner.next().toLowerCase();
                    if (username.equals("admin") && password.equals("password")) {
                        innerLoop:
                        while (true) {
                            Menu.adminMenu();
                            int input = scanner.nextInt();
                            switch (input) {
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
                                case 5:
                                    break innerLoop;

                            }
                        }
                    }
                    break;
                case 2:
                    if (customerManagementModule.customerLogin()) {
                        innerLoop:
                        while (true) {
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
                                case 6:
                                    policyManagementModule.listPolicy();
                                    break;

                                case 7:
                                    break innerLoop;

                                default:
                                    System.out.println("Invalid input");
                            }
                        }

                    } else {
                        System.out.println("Invalid input");
                    }
                    break;
                case 3:
                    System.exit(0);

                default:
                    System.out.println("Invalid input");
                    break;

            }

        }
    }
}
