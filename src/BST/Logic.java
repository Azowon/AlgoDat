/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BST;


public class Logic {
    
    Element root;
    
    public Logic(int value)
    {
        root = new Element(value);
    }
    
    public void insert(int value)
    {
       root.insert(value);
       root = Element.root;
    }
    
    public void remove(int value)
    {
        System.out.println("Noch nicht unterstützt");
    }
    
    public int getChildCount()
    {
       return root.getChildCount();
    }
    
    public int getHeighest()
    {
        return root.getHeighest();
    }
    
    public int getLowest()
    {
        return root.getLowest();
    }
     
    public static void main(String[] args)
    {
         Logic tree = new Logic(10);
         tree.insert(4);
         tree.insert(1);
         tree.insert(8);
         tree.insert(22);
         tree.insert(25);
         tree.insert(21);
         tree.insert(23);
         tree.insert(30);
         tree.insert(35);
         System.out.println("Ok wenn 10: " + tree.getChildCount());
         System.out.println("Ok wenn 35: " + tree.getHeighest());
         System.out.println("Ok wenn 1: " + tree.getLowest());
    }
    
}
