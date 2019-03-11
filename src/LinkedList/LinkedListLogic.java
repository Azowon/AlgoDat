/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author 00010130
 */
public class LinkedListLogic {
    
    ListElement listElement;
    
    
    public boolean listEmpty()
    {
        return listElement == null;
    }
    
    public void add(int wert)
    {
        if (listEmpty())
        {
            listElement = new ListElement();
            listElement.wert = wert;
        }
            
        else
        {
           ListElement temp = findMax(listElement);
           temp.next = new ListElement();
           temp.next.wert = wert;
           
        }
    }
    
    public ListElement findMax(ListElement element)
    {
        if (element.hasNext())
            return findMax(element.next);
        else
            return element;
    }
    
    public ListElement find(int index)
    {
        if(listEmpty())
        {System.out.println("Die Liste ist leer!"); return null;}
        else
        {
            return find2(index, listElement, 0);
        }
    }
    public ListElement find2(int index, ListElement element, int zähler)
    {
        if(zähler == index)
            return element;
        else if (!element.hasNext())
            return null;
        else
            return find2(index, element.next, ++zähler);
    }
    
    public int get(int index)
    {
        return find(index).wert;
    }
    
    public void remove(int index)
    {
        ListElement temp = find(--index);
        if(temp.next.hasNext())
             temp.next = temp.next.next;
    
        else
            temp.next = null;
    }
    
    public void insert(int index, int wert)
    {
        find(index).wert = wert;
        
    }
    
    public void clear()
    {
        listElement = null;
    }
    
    public int size()
    { 
       
        if(listEmpty())
            return 0;
        else
        {
            int zähler = 1;
            ListElement temp = listElement;
            while(temp.hasNext())
            {
                temp = temp.next;
                zähler++;
            }
            return zähler;
            
        }
    }
    
    public String toString()
    {
        if(listEmpty())
            return "[]";
        String zurück ="[";
        ListElement temp = listElement;
        while(temp.hasNext())
        {
            zurück += temp.wert + ", ";
            temp = temp.next;
        }
        zurück+= temp.wert;
        
        return zurück+"]";
    }
    
    public boolean equals(LinkedListLogic object)
    {
        boolean zurück = object.toString().equals(this.toString());
        return zurück;
    }
    
    public static void main(String[] args)
    {
        LinkedListLogic Liste = new LinkedListLogic();
        Liste.add(0);
        Liste.add(1);
        Liste.add(2);
        Liste.add(3);
        Liste.add(4);
        
        LinkedListLogic Liste2 = new LinkedListLogic();
        Liste2.add(0);
        Liste2.add(1);
        Liste2.add(2);
        Liste2.add(3);
        Liste2.add(4);

         
        //Liste.insert(3, 22);
        //System.out.println(Liste.get(3));
        System.out.println(Liste.size());
        System.out.println(Liste.toString());
        
        LinkedList<String> test = new LinkedList();
        test.add("Hallo");
        test.add("zwei");
        test.add("drei");
        
        ArrayList<String> testi= new ArrayList();
        testi.add("Hallo");
        testi.add("zwei");
        testi.add("drei");
        testi.clear();
        System.out.println(testi.toString());
        
     
    }
   
   
}


