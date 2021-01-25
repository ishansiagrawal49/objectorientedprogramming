import java.io.*;
import java.util.Scanner;

 class Rectangle{
    
    private float length=1;
    private float width=1;
    
    Rectangle(float length,float width){
        this.length = length;
        this.width = width;
    }
    
   public float Perimeter(){
        return 2*(this.length + this.width);
    }
    
    public float Area(){
        return this.length*this.width;
    
    }
    
    public void setLength(float length){
        this.length = length;
    }
    
    public void setWidth(float width){
        this.width = width;
    }
    
    public float getLength(){
        return this.length;
    }
    
    public float getWidth(){
        return this.width;
    }
    
    
}






public class Ex2Ans1 {

   
    public static void main(String[] args) {
        // TODO code application logic here
        float a = 2;
        float b = 5;
        Rectangle r1 = new Rectangle(a,b);
        r1.setLength(b*2);
        System.out.println(" the new length is : " +r1.getLength());
        System.out.println(" The preimeter is : " +r1.Perimeter());
        System.out.println(" The area is : " + r1.Area());
        
        
    }
    
}
