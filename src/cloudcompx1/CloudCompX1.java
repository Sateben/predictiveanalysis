/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudcompx1;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File; 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException; 
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CloudCompX1 {

    static double mean_x = 0;
    static double mean_y = 0;
    static double slope1 = 0;
    static double y_intercept = 0;
    
    public static void main(String[] args) {
        // TODO code application logic here
    
      BufferedReader Buff_reader1 = null; 
      BufferedReader Buff_reader2 = null; 

      File file = new File("/Users/krrishdholakia/Desktop/CPUvsTime.txt");
      
        try {
            Buff_reader1 = new BufferedReader(new FileReader(file));
            Buff_reader2 = new BufferedReader(new FileReader(file));

            String line = null; 
            int count1 = 0;
            
            ArrayList<String> listLines = new ArrayList<String>();

            System.out.println("Test1");
            
            while(Buff_reader1.readLine()!=null)
            {count1++;}
            
            System.out.println(""+count1);

            int[] CPU_usage = new int[count1];
            int[] time_taken = new int[count1];  
            
                        System.out.println("Test2");

            while((line = Buff_reader2.readLine())!=null)
            { 
                listLines.add(line);
                System.out.println(line);
            }
            
            for(int count = 0; count < count1; count++)
            {
                String[] splitter = listLines.get(count).split(" ");
               
                CPU_usage[count] = Integer.parseInt(splitter[0]);
                time_taken[count] = Integer.parseInt(splitter[1]);
                
                System.out.println(CPU_usage[count] + " " + time_taken[count]);
            }
            
             slope1 = slope(CPU_usage,time_taken);
            
            System.out.println(slope1);
            
            y_intercept = y_intercept(slope1);
            
                        System.out.println(y_intercept);
                        


            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CloudCompX1.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
              Logger.getLogger(CloudCompX1.class.getName()).log(Level.SEVERE, null, ex);
          }
      
    
        
    }
    
    
    public static double slope (int[] CPU_usage, int[] time_taken)
    {
        
        double sum_x = 0;
        double sum_y = 0;
        double number_of_elements = CPU_usage.length;
        double xy = 0;
        double x_square = 0;
       
        
        for(int count = 0; count < CPU_usage.length; count++)
        {
            sum_x = CPU_usage[count] + sum_x;
            sum_y = time_taken[count] + sum_y;
            
            xy = CPU_usage[count]*time_taken[count]+xy;
            
            x_square = CPU_usage[count]*CPU_usage[count]+x_square;
        }
        
        System.out.println(number_of_elements);
        
        mean_x = sum_x/number_of_elements;
                System.out.println(mean_x);

        mean_y = sum_y/number_of_elements;
                        System.out.println(mean_y);

        double mean_xy = xy/number_of_elements;
                                System.out.println(mean_xy);

        double mean_x_square = x_square/number_of_elements;
                                        System.out.println(mean_x_square);
                                        
        double mean_x_mean_y = mean_x*mean_y;                              
        System.out.println(mean_x_mean_y);
        
        double mean_square_x = mean_x*mean_x;
        System.out.println(mean_square_x);
        double slope1 = ((mean_x_mean_y)-mean_xy);
                System.out.println(slope1);

        double slope2 = ((mean_square_x)-(mean_x_square));
                        System.out.println(slope2);

        double slope3 = (slope1)/slope2;
                                System.out.println(slope3);

        
        return slope3;

    }
    
    
    public static double y_intercept (double slope)
    {
        double b = mean_y - ((mean_x)*slope);
        
        return b;
    }
    
}
