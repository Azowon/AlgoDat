/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sortieralgorithmen;

import java.util.LinkedList;


public class Sortieralgorithmen {
    
    
    static long systemZeitStart;
    static long systemZeitEnde;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Sortieralgorithmen().start();
    }
    
    void start()
    {
       int[] liste = CreateList(10);
       int[] liste2 = new int[liste.length];
       System.arraycopy(liste, 0, liste2, 0, liste.length);
       int[] liste3 = new int[liste.length];
       System.arraycopy(liste, 0, liste3, 0, liste.length);
       int[] liste4 = new int[liste.length];
       System.arraycopy(liste, 0, liste4, 0, liste.length);
       
    
        bubbleSort(liste);
       insertionsort(liste2);
       selectionSort(liste3);    
      mergeSort(liste4);
     
        startQuickSort(CreateIntegerList(100));
       
    }
    
    int[] CreateList(int anzahl)
    {
        
        int[] liste = new int[anzahl];
        for(int i = 0; i < anzahl; i++)
        {
            liste[i] =(int) (Math.random() * 100);
        }
        return liste;
    }
    
     Integer[] CreateIntegerList(int anzahl)
    {
        
        Integer[] liste = new Integer[anzahl];
        for(int i = 0; i < anzahl; i++)
        {
            liste[i] =(int) (Math.random() * 100);
        }
        return liste;
    }
    
    String arrayToString(int[] liste)
    {
        String back = "";
        for (int l : liste)
             back += " " + l + ",";
        
        return back;
    }
    
    void insertionsort(int[] liste) 
    {
        System.out.println("Insertion Sort: Die Unsortierte Liste ist: " + arrayToString(liste));
        systemZeitStart = System.nanoTime();
        OUTERLOOP: for (int i = 1; i<liste.length; i++)
        {
            for(int j = i; j > 0; j--)
            {
                if(liste[j] < liste[j-1])
                {
                    int temp = liste[j];
                    liste[j] = liste[j-1]; 
                    liste[j-1] = temp;
                }
                else
                    continue OUTERLOOP;
            }
        }
        systemZeitEnde = System.nanoTime();
        System.out.println("Die Sortierte Liste ist: "+arrayToString(liste));
        System.out.println("Die Benötigte Zeit war: " + (systemZeitEnde - systemZeitStart)/1000000 + "ms");
    }
    
    void bubbleSort(int[] liste)
    {
        System.out.println("Bubble Sort: Die Unsortierte Liste ist: " + arrayToString(liste));
        systemZeitStart = System.nanoTime();
        boolean isWorking;
        int length = liste.length -1;
        do{
            isWorking = false;
        
        
           for(int i=0; i<length; i++)
           {
               if(liste[i] > liste[i+1])
               {
                   int temp = liste[i];
                   liste[i] = liste[i+1];
                   liste[i+1] = temp;
                   isWorking = true;
               }
           }
           length--;
           } while(isWorking);
            
                
        
        systemZeitEnde = System.nanoTime();
        System.out.println("Die Sortierte Liste ist: "+arrayToString(liste));
        System.out.println("Die Benötigte Zeit war: " + (systemZeitEnde - systemZeitStart)/1000000 + "ms");
    }
    
    void selectionSort(int[] liste) 
    {
          System.out.println("Selection Sort: Die Unsortierte Liste ist: " + arrayToString(liste));
        systemZeitStart = System.nanoTime();
        
        int smallest, index;
        for(int i = 0; i < liste.length;i++)
        {
            smallest = liste[i];
            index = i;
            for(int j = i; j < liste.length; j++)
            {
                if(liste[j] < smallest)
                {
                    smallest = liste[j];
                    index = j;
                }
                
            }
            if(index != i);
            {
                int temp = liste[i];
                liste[i] = liste[index];
                liste[index] = temp;
            }
            
        }
        systemZeitEnde = System.nanoTime();
        System.out.println("Die Sortierte Liste ist: "+arrayToString(liste));
        System.out.println("Die Benötigte Zeit war: " + (systemZeitEnde - systemZeitStart)/1000000 + "ms");
    }
    
    
    
    void mergeSort(int[] liste)
    {
        System.out.println("Merge Sort: Die Unsortierte Liste ist: " + arrayToString(liste));
        systemZeitStart = System.nanoTime();
       
       
        liste = devine(liste);
        
        systemZeitEnde = System.nanoTime();
        System.out.println("Die Sortierte Liste ist: "+ arrayToString(liste));
        System.out.println("Die Benötigte Zeit war: " + (systemZeitEnde - systemZeitStart)/1000000 + "ms");
        
        
    }
    
    int[] devine(int[] liste)
    {
        if(liste.length == 1)
        {return liste;}
        else
        {
            
        
        
            int half = liste.length /2;
            int[] list1 = new int[half];
            int[] list2;
            
            System.arraycopy(liste, 0, list1, 0, half);
            if(liste.length % 2 == 0)
            {
                list2 = new int[half];
                System.arraycopy(liste, half, list2, 0, half);
            }
            else
            {
                list2 = new int[half+1];
                System.arraycopy(liste, half, list2, 0, half+1);
            }
                return merche(devine(list1), devine(list2));

           }
        
    }    
    
    int[] merche (int[] eins, int[] zwei)
    {
        int[] back = new int[eins.length + zwei.length];
        int i =0, j =0, u= 0;
        while(i < eins.length && j < zwei.length)
        {
            if(eins[i] < zwei[j])
            {
                back[u] = eins[i];
                i++; u++;
            }
            else
            {
                back[u] = zwei[j];
                j++; u++;
            }
        }
        if(i == eins.length)
        {
            while(j<zwei.length)
            {
                back[u] = zwei[j];
                u++; j++;
            }
        }
        else
        {
             while(i<eins.length)
            {
                back[u] = eins[i];
                u++; i++;
            }
        }
        return back;
    }
             
        void startQuickSort(Integer[] liste)
        {
       
        int[] ausgabe1 = new int[liste.length];
        
        for(int i= 0; i < liste.length; i++)
            ausgabe1[i] = liste[i];
        System.out.println("Quick Sort: Die Unsortierte Liste ist: " + arrayToString(ausgabe1));     
            systemZeitStart = System.nanoTime();
       
        
       
       liste = quickSort(liste);
            
        systemZeitEnde = System.nanoTime();
        
        int[] ausgabe = new int[liste.length];
        
        for(int i= 0; i < liste.length; i++)
            ausgabe[i] = liste[i];
            
        
        System.out.println("Die Sortierte Liste ist: "+ arrayToString(ausgabe));
        System.out.println("Die Benötigte Zeit war: " + (systemZeitEnde - systemZeitStart)/1000000 + "ms");
            
        }
    
        Integer[] quickSort(Integer[] liste)
        {
            
            if(liste.length == 1)
            {
                return liste;
            }
            
            int pivot = liste[0];
            LinkedList<Integer> list1 = new LinkedList(), list2 = new LinkedList();
            for(int i = 1; i < liste.length; i++)
            {
             if(liste[i] < pivot)
             {
                list1.add(liste[i]);
             }
             else
             {
                 list2.add(liste[i]);
             }
            }
            
            Integer[] alist1 = list1.toArray(new Integer[list1.size()]);
            Integer[] alist2 = list2.toArray(new Integer[list2.size()]);
            
            if(alist1.length > 0)
                alist1 = quickSort(alist1);
            if(alist2.length > 0)
                alist2 = quickSort(alist2);
            
            Integer[] sorted = new Integer[liste.length];
            
            if(alist1.length > 0)
                System.arraycopy(alist1, 0, sorted, 0, alist1.length);
            
            sorted[alist1.length] = pivot;
            
            if(alist2.length > 0)
                 System.arraycopy(alist2, 0, sorted, alist1.length+1, alist2.length);
      
            
            
            return sorted;
        }
        
        
        
    
    
    
}
