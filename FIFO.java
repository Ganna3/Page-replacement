
package projectos2;


import java.util.LinkedList; 
import java.util.Queue;
import java.util.Scanner;



public class FIFO {
    private Queue<Integer> indexes= new LinkedList<>();
        private LinkedList<Integer> replace ;
       
        
         private int pf = 0;
       private  int n;
       private int pages[];
        private int NumOfFrames=0;
         private boolean HIT[];
          private int outputView[][];
         
     void fifo() 
    {    
        System.out.println("====FIFO====");
        
         Scanner in=new Scanner(System.in);
        
             System.out.println("How many frames do you want:");
             NumOfFrames=in.nextInt();
             
        
             System.out.println("How many pages are you going to enter:");
             n=in.nextInt();
             
             replace=new LinkedList<>();
             pages=new int[n];
              HIT = new boolean[n];
         outputView = new int[n][NumOfFrames];
            
             for (int i=0; i<n; i++) 
                { 
                    for (int j=0; j<NumOfFrames; j++) 
                     {
                         outputView[i][j] =-1;
                     }
                }
         
             
             System.out.println("Enter your pages sequentially");
              for (int i=0; i<n; i++) 
                { 
                   pages[i]=in.nextInt();
                }
              
             
        for (int i=0; i<n; i++) 
        { 
           
            if (indexes.size() < NumOfFrames) 
            { 
                if(indexes.contains(pages[i]))
                {
                    HIT[i]=true;
                
                }
                else 
                {  
                    
                    replace.add(pages[i]);
                    pf++;
                    indexes.add(pages[i]); 
                } 
             
            } 
            else
            { 
                if(indexes.contains(pages[i]))
                {
                    HIT[i]=true;
                
                }
                else 
                {  
                   
                    int x=replace.indexOf(indexes.peek());
                    replace.set(x,pages[i]);
                    indexes.poll(); 
                    indexes.add(pages[i]); 
                    pf++; 
                } 
          
            }
             for(int v= 0; v < replace.size(); v++)
            {
                outputView[i][v] = replace.get(v);
            }
                    
        } 
      
       
        
        // *view data* //

        for(int u = 0; u < n; u++)
        {
            System.out.print(pages[u] + ": frames content: ");
            for(int v = 0; v < NumOfFrames; v++)
            {
                if (outputView[u][v] == -1)
                {
                    System.out.print("   ");
                    System.out.print("-");
                }
                else
                {
                     System.out.print("   ");
                    System.out.print(outputView[u][v]);
                    
                   
                }
            }
            System.out.print(": ");
            if (HIT[u]) {
                System.out.print(" #/HIT/#");
            }
            else
            {
                System.out.print(" #/MISS/#");
            }
         
            System.out.println();
        }
        System.out.println("Total number of Page faults: " + pf);
    } 
     
      
}

