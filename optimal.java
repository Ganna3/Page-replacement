package projectos2;

  
import java.util.LinkedList;
import java.util.Scanner;


public class optimal {
    
     private int pf = 0;
       private  int n;
       private int pages[];
       private int NumOfFrames=0;
       private boolean HIT[];
    
       private int outputView[][];
       private LinkedList<Integer> indexes;
       void OPT() 
        {  
            System.out.println("====OPTIMAL====");
        
         Scanner in=new Scanner(System.in);
        
             System.out.println("How many frames do you want:");
             NumOfFrames=in.nextInt();
             
        
             System.out.println("How many pages are you going to enter:");
             n=in.nextInt();
             
             indexes=new LinkedList<>();
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
           //System.out.print("Add Page : "+pages[i]+"\n");
            if (indexes.size() < NumOfFrames) 
            { 
                if(indexes.contains(pages[i]))
                {
                    HIT[i]=true;
                }
                else
                {
                  indexes.add(pages[i]);
                   pf++;
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
                    int max=-1;
                    //System.out.print("(Miss) \n");
                    int ex[]=new int[NumOfFrames];
                    int ex2[]=new int[NumOfFrames];
                        for(int z=i+1;z<n;z++)
                        {
                            for(int f=0;f<NumOfFrames;f++)
                            {
                                ex2[f]=indexes.get(f);
                                if(ex2[f]==pages[z])
                                {
                                    ex[f]=z;
                                 
                                }
                            }
                        }
                     
                         for(int x=0;x<NumOfFrames;x++)
                            {
                                if(ex[x]>max)
                                {
                                    max=ex[x];
                                }
                            } 
                         int f=indexes.indexOf(pages[max]);
                         indexes.set(f,pages[i]);
                  pf++;   
                 } 
          //  System.out.print("\n");
            }
            for(int v= 0; v < indexes.size(); v++)
            {
                outputView[i][v] = indexes.get(v);
            }    
        }
           
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
        
  /*  private  int noOfFrames = 0;
    private  int pageReferenceLenght;
    private int numberOfPageFaults = 0;
    private int PT1 = 0;
    private  boolean isFULL = false;
        
    private int FRAMS[];
    private int pageRefrenceString[];
    private boolean HIT[];
    private int outputView[][];
       
       
       
    public void OPT() {
       System.out.println("====OPTIMAL====");
       
    Scanner in = new Scanner(System.in);

    System.out.println("How many frames do you want:");
    noOfFrames = in.nextInt();

    System.out.println("How many pages are you going to enter:");
    pageReferenceLenght = in.nextInt();
    
    FRAMS = new int[noOfFrames];
    pageRefrenceString= new int[pageReferenceLenght];
    HIT = new boolean[pageReferenceLenght];
    outputView = new int[pageReferenceLenght][noOfFrames];
   
      
        for(int u = 0; u < noOfFrames; u++)
        {
            FRAMS[u] = -1;
        }

        System.out.println("Enter your pages sequentially:");
        for(int u = 0; u < pageReferenceLenght; u++)
        {
            pageRefrenceString[u] =in.nextInt();
        }
        System.out.println();
        
        
        
        for(int u = 0; u < pageReferenceLenght; u++)
        {
            int SEARCH = -1;
            
            for(int v = 0; v < noOfFrames; v++)
            {
                if(FRAMS[v] == pageRefrenceString[u])
                {
                    SEARCH = v;
                    HIT[u] = true;
                  
                    break;
                }
            }

            if(SEARCH == -1)
            {
                if(isFULL)
                {
                 
                    int pageIndex=-1;
                    boolean flag[];
                    flag=new boolean[noOfFrames];
                    for(int v = u + 1; v < pageReferenceLenght; v++)
                    {
                       
                        for(int s = 0; s < noOfFrames; s++)
                        {
                            if((pageRefrenceString[v] == FRAMS[s]) ) 
                                   
                            {
                                 pageIndex=s;
                                 flag[s]=true;
                               
                               break;
                            }
                          
                            
                        }
                    }
                   
                     PT1= 0;
                
                     int countF=0;
                     for(int i=0;i<noOfFrames;i++){
                         if (flag[i]==true)
                         {
                         countF++;
                         }
                     }
                     
                     // for(int i=0;i<noOfFrames;i++){
                      if(countF==noOfFrames){
                       FRAMS[pageIndex] = pageRefrenceString[u];
                numberOfPageFaults++; 
                      }
                      
                      //}
                       if (countF >0 && countF<noOfFrames){
                             FRAMS[pageIndex+1] = pageRefrenceString[u];
                numberOfPageFaults++; 
                       }
                      if (countF==0){
                             FRAMS[0] = pageRefrenceString[u];
                numberOfPageFaults++;
                      
                      }
                
                
                }
                
                           if(!isFULL)
                               {
                                   for (int i=0;i<noOfFrames;i++){
                                         if (FRAMS[i]== -1){
                                             PT1=i;
                                             break;
                                           }
                                   }
                                         
                                 FRAMS[PT1] = pageRefrenceString[u];
                numberOfPageFaults++;
                PT1++;
                                  if(PT1 == noOfFrames)
                                     {
                                     PT1= 0;
                                     isFULL = true;
                                     }
                                }    
                
                         }
     
               
               for(int v= 0; v < noOfFrames; v++)
            {
                outputView[u][v] = FRAMS[v];
            }
               
               
            }

           
        
        
        // *view data* //

        for(int u = 0; u < pageReferenceLenght; u++)
        {
            System.out.print(pageRefrenceString[u] + ": frames content: ");
            for(int v = 0; v < noOfFrames; v++)
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
            } else
            {
                System.out.print(" #/MISS/#");
            }
         
            System.out.println();
        }
        System.out.println("Total number of Page faults: " + numberOfPageFaults);
    }
       }*/


    

