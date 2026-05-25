package com.mycompany.prog5121poepart2;
import java.util.Scanner;

public class Prog5121POEPart2 {

    public static void main(String[] args) {
       
        Scanner input = new Scanner(System.in);
        int totalSent = 0;
        Login userlogin = new Login();
        Message messageChecker = new Message();
        
        String username;
        String password;
        String cellphoneNumber;
        
        //Username Validation
        do {
            System.out.println("Please enter username: ");
            username = input.nextLine();
            
            if (!userlogin.checkUserName(username)) {
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.");
                
            }
            
        } while (!userlogin.checkUserName(username));
        
        System.out.println("Username successfully captured");
        
        //Password validation
        do {
            System.out.println("Enter your password: ");
            password = input.nextLine();
            
            if (!userlogin.checkPasswordComplexity(password)) {
                System.out.println("password is not correctly formatted, please ensure that the password contains at least eight characters, a capi tal letter, a number, and a special character.");
            }
        } while(!userlogin.checkPasswordComplexity(password));
        
        System.out.println("Password successfully captured");
        
        //Phone number validation
        do {
            System.out.print("Enter your cellphone number: ");
            cellphoneNumber = input.nextLine();
            
        //Check if the input is valid for SA    
            if (!Login.checkCellphoneNumber(cellphoneNumber)) {
                System.out.println("Invalid phone number. Ensure it includes the +27 SA code and correct length.");
            }
            
        } while (!Login.checkCellphoneNumber(cellphoneNumber));
        
        System.out.println("Phone number successfully captured");
        
        //register user section
       String registrationMessage = userlogin.registerUser(username, password, cellphoneNumber);
        System.out.println(registrationMessage);
        
        //Login Section
        System.out.println("\n=== LOGIN ===");
        
        System.out.println("Enter username: ");
        String loginUsername = input.nextLine();
        
        System.out.println("Enter password: ");
        String loginPassword = input.nextLine();
        
        boolean loginResult = userlogin.loginUser(loginUsername, loginPassword);
        
        System.out.println(userlogin.returnLoginStatus(loginResult));
        
        //Part 2 starts here, Only if login worked
        if(loginResult){
            System.out.println("Welcome to QuickChat.");
            
            boolean running = true;
            while(running){
                System.out.println("\n=== QuickChat Menu ===");
                System.out.println("1)Send Messages");
                System.out.println("2)Show recently sent messages");
                System.out.println("3)Quit");
                System.out.println("Enter choice: ");
                
                int choice = input.nextInt();
                input.nextLine(); //Fixes the scanner
                
                if(choice==1){
                    System.out.print("How many messages do u want to send?");
                    int numMessages = input.nextInt();
                    input.nextLine(); //Fixes scanner bug
                    
                    int i =0;
                    while(i<numMessages){
                        System.out.println("\n---Message"+(i+1)+"of"+ numMessages+"---");
                        
                        System.out.print("Enter recipient cell number:");
                        String recipient = input.nextLine();
                        
                        if(!messageChecker.checkRecipientCell(recipient)){
                            System.out.println("Cell phone number is incorrectly formatted or does not contain an international code. please correct the number and try again.");
                            continue;
                        }
                        System.out.print("Enter your message: ");
                        String message = input.nextLine();
                        String messageID = messageChecker.createMessageID();
                        String messageHash = messageChecker.createMessageHash(messageID,i+1,message);
                        
                        //POE RULE:Check if message is lower than 250 characters
                        if(message.length()>250){
                            int excess = message.length()-250;
                            System.out.println("Message exceeds 250 characters by"+excess+",please reduce size.");
                            continue;
                        }else{
                            System.out.println("Message ready to send.");
                            System.out.println("Choose option: ");
                            System.out.println("1)Send Message"); 
                            System.out.println("2)Disregard Message");
                            System.out.println("3)Store Message to send later");
                            int action = input.nextInt();
                            input.nextLine();
                            
                            if(action ==1){
                                System.out.println("Message successfully sent.");
                                totalSent++;
                                System.out.println("MessageID:"+messageID);
                                System.out.println("Message Hash:"+messageHash);
                                System.out.println("To:"+recipient);
                                System.out.println("Message:"+message);
                            }
                            else if(action ==2){
                                System.out.println("Press 0 to delete the message.");
                                continue;
                            }
                            else if(action ==3){
                                System.out.println("Message successfully stored.");
                                continue;
                            }
                            
                        }
                        i++; //Only count if message was sent
                    }
                }else if(choice==2){
                    System.out.println("Coming Soon.");
                }else if(choice==3){
                    System.out.println("Total messages sent:"+totalSent);
                    running = false;
                    System.out.println("Goodbye!");
                }else{
                    System.out.println("Invalid option. Try 1,2 or 3.");
                }
            }
        }
                input.close();
        }
    }
