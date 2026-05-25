package com.mycompany.prog5121poepart2;

public class Login {
    
    //store fields
    static String storedUsername = "";
    static String storedPassword = "";
    static String storedCellphoneNumber = "";
    
    
    //Check username method
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }
    
    //Check password complexity method
    public boolean checkPasswordComplexity(String password) {
        if (password.length() < 8){
            return false;
        }
        
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasCapital = true;
            else if (Character.isDigit(ch)) hasNumber = true;
            else if (!Character.isLetterOrDigit(ch)) hasSpecial = true;
        }    
        //Check after loop finnishes, not inside it.
        return hasCapital && hasNumber && hasSpecial ;
    }
   
    //Cellphone Number method
    public static boolean checkCellphoneNumber (String cellphoneNumber) {
        return cellphoneNumber.matches("\\+27\\d{9}");
    }
    
    //Register User Method
    public String registerUser(String username, String password, String cellphoneNumber) {
        
        if (!checkUserName(username)){
            return "Username is not correctly formatted.";
        
    }
        
        if (!checkPasswordComplexity(password)) {
           return "Password does not meet complexity requirements.";
    }
        if (!checkCellphoneNumber(cellphoneNumber)){
           return "Invalid phone number. Ensure it includes the +27 SA code and correct length.";
        }
    
        storedUsername = username;
        storedPassword = password;
        storedCellphoneNumber = cellphoneNumber;
        
        return "User has been registered successfully.";
    }
//login user method
public String returnLoginStatus(boolean loginSuccess) {
    if (loginSuccess){
        return "Login successful.";
    } else {
     return "Login failed.";
    }
}

    boolean loginUser(String username, String password) {
        return username.equals(storedUsername) && password.equals(storedPassword);
    }
}