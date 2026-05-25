package com.mycompany.prog5121poepart2;
 
import java.util.Random;

public class Message {
    
    //POE RULE: Check if cell number is Valid.
    public boolean checkRecipientCell(String cellNumber){
        //Must be 12 chars long AND start with +27
        return cellNumber.length()==12&&cellNumber.startsWith("+27");
    }
    
    //POE RULE: generate random 10-digit MesageID
    public String createMessageID(){
        Random rand = new Random();
        long number = 100000000L+(long)(rand.nextDouble()*9000000000L);
        return String.valueOf(number);
    }
    
    //POE RULE: Create Message Hash
    public String createMessageHash(String messageID,int messageNum,String message){
        String idStart = messageID.substring(0,2);
        String[]words = message.trim().split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length-1];
        
        firstWord = firstWord.replaceAll("[^a-zA-Z0-9]","");
        lastWord = lastWord.replaceAll("[^a-zA-Z0-9]","");
        return idStart+":"+messageNum+":"+firstWord.toUpperCase()+lastWord.toUpperCase();
    }
}
