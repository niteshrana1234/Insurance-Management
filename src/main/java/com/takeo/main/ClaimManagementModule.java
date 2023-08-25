package com.takeo.main;

import com.takeo.model.Claim;
import com.takeo.model.Customer;
import com.takeo.model.Policy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ClaimManagementModule {
    LocalDate today = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    Scanner scanner = new Scanner(System.in);
    public static Map<String, Claim> claimList = new HashMap<>();

    public String generateRandom() {
        Random random = new Random();
        int randomNum = random.nextInt(9999) + 1000;

        while (claimList.containsKey(randomNum)) {
            randomNum = random.nextInt(9999) + 1000;
        }
        return "C" + randomNum;
    }

    public Boolean verifyCustomer(int id, String policyNum) {
        Policy policy = PolicyManagementModule.policyList.get(policyNum);

        if (policy != null && policy.getCustomerId() == id) {

            String name = CustomerManagementModule.customerList.get(id).getFullName();
            System.out.println("You're verified Mr/s." + name);
            return true;
        } else {
            System.out.println("Invalid information!!");
        }
        return false;
    }

    public void saveClaim(Claim claim) {
        String claimNum = generateRandom();
        claim.setClaimNumber(claimNum);
        claimList.put(claimNum, claim);
    }

    public void fileClaim() {

        System.out.print("\nEnter Id:");
        int id = scanner.nextInt();
        System.out.print("Enter policy number:");
        String policyNum = scanner.next();

        String dateFilled = today.format(formatter);
        boolean claimStatus = false;
        if (verifyCustomer(id, policyNum)) {
            System.out.print("Enter claim amount: ");
            int claimAmt = scanner.nextInt();
            Claim claim = new Claim(id, policyNum, claimAmt, dateFilled, claimStatus);
            saveClaim(claim);
            System.out.println("Claim filled successfully \nClaim number : " + claim.getClaimNumber());
        }

    }

    public void updateClaim() {
        System.out.print("\nEnter Id:");
        int id = scanner.nextInt();
        System.out.print("Enter policy number:");
        String policyNum = scanner.next();

        if (verifyCustomer(id, policyNum)) {
            for (Map.Entry<String, Claim> map : claimList.entrySet()) {
                if (policyNum.equals(map.getValue().getPolicyNumber())) {
                    Claim claim = claimList.get(map.getKey());
                    System.out.print("Enter claim amount: ");
                    int claimAmt = scanner.nextInt();
                    claim.setClaimAmount(claimAmt);
                    System.out.println("Claim filled updated \nClaim number : " + claim.getClaimNumber() + ", Claim amount : " + claim.getClaimAmount());
                }
            }
        } else {
            System.out.println("Invalid information");
        }

    }

    public void deleteClaim() {
        System.out.print("\nEnter Id:");
        int id = scanner.nextInt();
        System.out.print("Enter policy number:");
        String policyNum = scanner.next();
        if (verifyCustomer(id, policyNum)) {
            for (Map.Entry<String, Claim> map : claimList.entrySet()) {
                if (policyNum.equals(map.getValue().getPolicyNumber())) {
                    claimList.remove(map.getKey());
                    System.out.println("Claim deleted successfully");
                    break;
                } else {
                    System.out.println("Error after verification!!");
                }
            }

        } else {
            System.out.println("Invalid information");
        }
    }

    public void listClaim() {
        for (Map.Entry<String, Claim> map : claimList.entrySet()) {
            Claim claim = map.getValue();
            int customerId = map.getValue().getCustomerId();
            Customer customer = CustomerManagementModule.customerList.get(customerId);
            System.out.println("Name : " + customer.getFullName() + ", Claim number : " + claim.getClaimNumber() + ", Claim amount : " + claim.getClaimAmount());
        }

    }

    public void claimStatus() {
        System.out.print("\nEnter Id:");
        int id = scanner.nextInt();
        System.out.print("Enter policy number:");
        String policyNum = scanner.next();
        if (verifyCustomer(id, policyNum)) {
            for (Map.Entry<String, Claim> map : claimList.entrySet()) {
                if (policyNum.equals(map.getValue().getPolicyNumber())) {
                    boolean check = map.getValue().getClaimStatus();
                    if (check) {
                        System.out.println("Claim status : Approved");
                    } else if (!check) {
                        System.out.println("Claim status : Processed");
                    }
                }
                else{
                    System.out.println("No claims filled yet");
                }
            }
        } else {
            System.out.println("Invalid information");
        }

    }

    public void ModifyStatus() {
        System.out.print("\nEnter Id:");
        int id = scanner.nextInt();
        System.out.print("Enter policy number:");
        String policyNum = scanner.next();
        if (verifyCustomer(id, policyNum)) {
            for (Map.Entry<String, Claim> map : claimList.entrySet()) {
                if (policyNum.equals(map.getValue().getPolicyNumber())) {
                    Claim claim = map.getValue();
                    boolean check = claim.getClaimStatus();
                    if (check) {
                        System.out.println("Status : Claim Approved, No change needed");
                    } else if (!check) {
                        System.out.println("Status : Claim Processed");
                        System.out.println("Change to approved ?\nEnter (Y/N)");
                        String input = scanner.next().toUpperCase();
                        switch (input) {
                            case "Y":
                                claim.setClaimStatus(true);
                                System.out.println("Done!!");
                                break;
                            case "N":
                                break;

                        }
                    }
                }
            }

        }
    }

}
