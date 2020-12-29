/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.os2;

import java.util.Scanner;
import java.io.*;
import java.util.*;
/**
 *
 * @author bassant
 */
public class ProjectOS2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int ch1;
        int ch2;
        int L=1;
        Scanner in=new Scanner(System.in);
        while(L==1)
        {
            System.out.print("If you want to use FIFO Page replacement press 1, If you want to use LRU Page replacement press 2, \n");
            System.out.print("If you want to use Optimal Page replacement press 3 \n");
            ch1=in.nextInt();
            if(ch1==1||ch1==2||ch1==3)
            {
                System.out.print("Press 1 if you want to enter the values or press 2 if you want read the values from a file \n");
                ch2=in.nextInt();
                if(ch2==1||ch2==2)
                {
                    if(ch1==1)
                    {
                        FIFO f=new FIFO();
                        if(ch2==1)
                        {
                            f.User();
                            f.FIFO();
                        }
                        else if(ch2==2)
                        {
                            f.FileUser();
                            f.FIFO();
                        }
                    }
                    else if(ch1==2)
                    {
                        LRU f=new LRU();
                        if(ch2==1)
                        {
                            f.User();
                            f.LRU();
                        }
                        else if(ch2==2)
                        {
                            f.FileUser();
                            f.LRU();
                        }
                    }
                    else if(ch1==3)
                    {
                        optimal f=new optimal();
                        if(ch2==1)
                        {
                            f.User();
                            f.OPT();
                        }
                        else if(ch2==2)
                        {
                            f.FileUser();
                            f.OPT();
                        }
                    }
                }
                else
                {
                    System.out.print("Enter either 1 or 2 \n");
                }
            }
            else
                {
                    System.out.print("Enter either 1 or 2 or 3 \n");
                }
            System.out.print("If you want to try again enter 1 else press 2 \n");
            L=in.nextInt();
        }
} 
    }
    

