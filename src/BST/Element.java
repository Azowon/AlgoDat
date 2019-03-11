/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BST;


 class Element {
    Element left, right;
    int value;
    static Element root;

    
    
    
    
    Element(int value)
    {
        this.value = value;
        if(root == null)
        root = this;
    }
    
  
    
    boolean hasNextLeft()
    {
        return left != null;
    }
    boolean hasNextRight()
    {
        return right != null;
    }
    
    void insert(int value)
    {
        if (value == this.value)
        {
            System.out.println("Dieses Wert gibt es schon");
            
        }
        else{
            
         
            if(value < this.value)
            {
                if(hasNextLeft())
                    left.insert(value);
                else
                    left = new Element(value);
            }
            else
            {
                if(hasNextRight())
                    right.insert(value);
                else
                    right = new Element(value);
            } 
              rotateTree(root);
               
            }
           
    }
    
    void remove(int value) 
    {
        
    }
     
     private Element find(int value, boolean prev)
     {
        if(value == this.value)
        {
            return this;
        }
        else if(value < this.value)
        {
            if (left.value == value && prev)
                return this;
            
            return left.find(value,prev);
        }
        else if(value > this.value)
        {
            if (right.value == value && prev)
                return this;
            
            return right.find(value,prev);
        }
        return null;
     }
     
      int getHeighest()
     {
         if(this.hasNextRight())
             return right.getHeighest();
         else
             return value;
     }
         int getLowest()
     {
         if(this.hasNextLeft())
             return left.getLowest();
         else
             return value;
     }
         
         int getChildCount()
         {
             int counter = 1;
             if(hasNextLeft())
                counter += left.getChildCount();
             if(hasNextRight())
                 counter+= right.getChildCount();
            return counter; 
         }
         
         private Element rotateLeft() 
         {      
             Element temp = this.right;
             this.right =this.right.left;
             temp.left = this;
             
             return temp;
         }
         
         private Element rotateRight()
         {      
             Element temp = this.left;
             this.left = temp.right;
             temp.right = this;
             return temp;
         }
         
         private Element rotateOneElement() 
         {
             Element temp = this;
             
             if (right == null) 
             {                 
                 if(left.getChildCount() > 1)
                    temp = rotateRight();
                 else
                     return temp;
             }
             else if(left == null)
             {
                 if(right.getChildCount() > 1)
                    temp = rotateLeft();
                 else
                     return temp;
             }   
             else if(right.getChildCount()+1 < left.getChildCount()) //ich denke hier kann das right != null weg. darunter auch.
                temp = rotateRight();
             else if(left.getChildCount()+1 < right.getChildCount())
                temp = rotateLeft();
          
                return temp;
         }
         
         private void rotateTree(Element prev)
         {
             if(hasNextLeft() && (left.hasNextLeft() || left.hasNextRight()))
                 left.rotateTree(this); 
             
             if(hasNextRight()  && (right.hasNextLeft() || right.hasNextRight()))
                 right.rotateTree(this); 
                          
             if(prev == this)
                 root = rotateOneElement();
             
             else if(prev.right == this)
                 prev.right = rotateOneElement();
             
             else if (prev.left == this)
                 prev.left = rotateOneElement();
         }
}
