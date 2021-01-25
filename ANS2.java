

class Employee{
    
    private String firstName;
    private String lastName;
    private float monthlySalary;
    public int count=0;
    
    Employee(String fn,String ln,float ms){
        this.firstName = fn;
        this.lastName = ln;
        this.monthlySalary = ms;
        count++;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
       this.lastName = lastName; 
    }
    public void setMonthySalary(float monthlySalary){
        this.monthlySalary = monthlySalary;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public float getMonthlySalary(){
        return this.monthlySalary;
    }
    
    public String MaxSalary(Employee e1,Employee e2){
        if(e1.monthlySalary>e2.monthlySalary){
            return e1.getFirstName();
        }
        else{
            return e2.getFirstName();
        }
    }
    
}




public class ANS2 {


    public static void main(String[] args) {
       
        Employee e1 = new Employee("Shreya", "Modi", 1300);
        Employee e2 = new Employee("Shivanshu","Gupta",1500);
        System.out.println("\nFOR EMPLOYEE NUMBER ONE : "+e1.count +"\nThe first name of the employee : "+e1.getFirstName() + ""
                + "\nThe last name of the employee : "+e1.getLastName() + "\nThe monthy salary is : "+e1.getMonthlySalary());
        System.out.println("\nFOR EMPLOYEE NUMBER ONE : "+e2.count +"\nThe first name of the employee : "+e2.getFirstName() + ""
                + "\nThe last name of the employee : "+e2.getLastName() + "\nThe monthy salary is : "+e2.getMonthlySalary());
        float value  = (float)1.1;
        e1.setMonthySalary(value*e1.getMonthlySalary());
        System.out.println("\nThe raised salary for e1 is : "+ e1.getMonthlySalary() );
        e2.setMonthySalary(value*e2.getMonthlySalary());
        System.out.println("\nThe raised salary for e2 is : "+ e2.getMonthlySalary() );
        System.out.println("\n The greater salary is of : "+ e1.MaxSalary(e1, e2));
        
    }
    
}
