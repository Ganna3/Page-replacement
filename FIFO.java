package project.os2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList; 
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


public class FIFO {
    private Queue<Integer> indexes= new LinkedList<>();
    private LinkedList<Integer> replace ;
    private boolean emp[];
    private int pf=0;
    private  int n;
    private int pages[];
    private int NumOfFrames;
    private boolean HIT[];
    private int outputView[][];
    private String File;
    public void User()throws IOException
    { 
        Scanner in1=new Scanner(System.in);
        System.out.print("Enter the number of Frames \n");
        NumOfFrames=in1.nextInt();
        System.out.print("Enter the number of Page refrences you are going to enter \n");
        n=in1.nextInt();
        System.out.print("Enter the page refrences :\n");
        pages=new int[n];
        for(int i=0;i<n;i++)
        {
            System.out.print("Page["+i+"]: ");
            pages[i]=in1.nextInt();
        }
    }
    public void FileUser() throws FileNotFoundException, IOException
        {
           System.out.print("Enter the name of the file: \n");
           Scanner in=new Scanner(System.in);
           File=in.nextLine();
           File F = new File(File);
          if(F.exists())
          {
            BufferedReader R = new BufferedReader(new FileReader(File));
            NumOfFrames = Integer.parseInt(R.readLine());
            System.out.print("Number of Frames: "+NumOfFrames+"\n");
            n=Integer.parseInt(R.readLine());
            System.out.print("Number of Page refrences: "+n+"\n");
            String Line = R.readLine();
            System.out.print(Line+"\n");
            pages=new int[n];
            Line = R.readLine();
            StringTokenizer t= new StringTokenizer(Line,",");
            for (int i = 0; i < n; i++)
            {
             pages[i]=Integer.parseInt(t.nextToken());
             System.out.print(pages[i]+" ");
            }
            System.out.print("\n");
          }
        }
     void FIFO() 
    {    
        System.out.println("----FIFO----");
        
        Scanner in=new Scanner(System.in);
        replace=new LinkedList<>();
        HIT = new boolean[n];
        outputView = new int[n][NumOfFrames];
        for (int i=0; i<n; i++) 
        { 
         for (int j=0; j<NumOfFrames; j++) 
          {
            outputView[i][j] =-1;
          }
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
      
       
        
        // view data //

        for(int u = 0; u < n; u++)
        {
            System.out.print(pages[u] + ": Frames content: ");
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