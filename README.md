/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.itson.a;

/**
 *
 * @author labo
 */
public class A {

    public static void main(String[] args) {

        
        String s = "aaanbaa";
        char[] a;
        char x;

        for (int i = 0; i < s.length(); i++)
        {
            if(i <= 2){
                System.out.println(s.charAt(i));
            }else{
                
                if (s.charAt(i) == s.charAt(i-1)){
            
                if(s.charAt(i-1) == s.charAt(i-2))
                {
                    
                    x = s.charAt(i-2);
                    System.out.println("aja");

                    
                }
            }    
                
                System.out.println(s.charAt(i));
            }
            
        }
    }
}
