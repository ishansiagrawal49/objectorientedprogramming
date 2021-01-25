import java.io.*;
import java.util.Scanner;

/**
 *
 * @author SHREYA MODI
 */
import java.util.Scanner;
public class Ans {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
        
//        System.out.println("Enter The Number Of Matrix Rows");
//         
//        int matrixRow = scan.nextInt();
//         
//        System.out.println("Enter The Number Of Matrix Columns");
//         
//        int matrixCol = scan.nextInt();
//         
//        //defining 2D array to hold matrix data
//        int[][] matrix = new int[matrixRow][matrixCol];
//        // Enter Matrix Data
//        enterMatrixData(scan, matrix, matrixRow, matrixCol);
//        
//        // Print Matrix Data
//        printMatrix(matrix, matrixRow, matrixCol);

     int[][] matrix = { { 1, 3,7,8}, { 6,5,3,2 },{9,7,8,1},{0,7,0,6} }; 
     int matrixRow = 4;
     int matrixCol = 4;
     int k=0;
     System.out.println("Enter K : ");
     k = scan.nextInt();
     int i=0;
     int t = k-1;
     while(i<matrixRow){
         
         int j=0;
         while(j<matrixCol){
             if(i+t<=matrixRow && j+t<=matrixCol){
                 for(int x=i;x<=i+t;x++){
                     for(int y=j;y<=j+t;y++){
                         System.out.print(matrix[x][y]+" ");
                     }
                     System.out.println();
                 }
             }
             System.out.println("\n\n\n");
             j=j+k;
         }
         i=i+k;
     }
     


  }
  public static void enterMatrixData(Scanner scan, int[][] matrix, int matrixRow, int matrixCol){
     System.out.println("Enter Matrix Data");
          
          for (int i = 0; i < matrixRow; i++)
          {
              for (int j = 0; j < matrixCol; j++)
              {
                  matrix[i][j] = scan.nextInt();
              }
          }
  }
  
  public static void printMatrix(int[][] matrix, int matrixRow, int matrixCol){
    System.out.println("Your Matrix is : ");
        
        for (int i = 0; i < matrixRow; i++)
        {
            for (int j = 0; j < matrixCol; j++)
            {
                System.out.print(matrix[i][j]+"\t");
            }
             
            System.out.println();
        }
  }
}
