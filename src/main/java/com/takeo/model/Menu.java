package com.takeo.model;

public class Menu {

    public static void adminMenu(){

        System.out.println("\n1.Create customer \n2.Delete customer \n3.Delete policy \n4.Set claim status \n5.Go to main menu");
        System.out.print("Enter your choice:");
    }

    public static void clientMenu(){
        System.out.println("\n1.Edit customer information \n2.Buy policy \n3.Edit policy " +
                "\n4.File a claim \n5.Check claim status \n6.View policy details \n7.Go to main menu");
        System.out.print("Enter your choice:");
    }


}
