/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Jef
 */
public class TokenReader {
    public TokenReader(){
        
    }
    
    public static String getToken() throws FileNotFoundException{
        File file = new File("Token.dct");
        Scanner reader = new Scanner(file);
        return reader.nextLine();
    }
}
