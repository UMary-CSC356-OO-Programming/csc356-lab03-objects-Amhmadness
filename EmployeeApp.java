import java.util.Scanner;

class Employee
{
	/* Task 3B: Add instance variables */
	public String firstName;
	public String lastName;
	public int employeeId;
	public double salary;
   
	/* Task 3C: Add three constructors */
	public Employee()
	{

	}
	public Employee(String last, String first)
	{
		this.lastName = last;
		this.firstName = first;
	}
	public Employee(String last, String first, int id, double wage)
	{
		this.lastName = last;
		this.firstName = first;
		this.employeeId = id;
		this.salary = wage;
	}
   
	/* Task 3D: Add set (mutator) and get (accessor) meethods */
	public String getLastName()
	{
		return this.lastName;
	}
	public String getFirstName()
	{
		return this.firstName;
	}
	public int getEmployeeId()
	{
		return this.employeeId;
	}
	public double getSalary()
	{
		return this.salary;
	}
	public void setLastName(String newEntry)
	{
		this.lastName = newEntry;
	}
	public void setFirstName(String newEntry)
	{
		this.firstName = newEntry;
	}
	public void setEmployeeId(int newEntry)
	{
		this.employeeId = newEntry;
	}
	public void setSalary(double newEntry)
	{
		this.salary = newEntry;
	}
   
	/* Task 3F: Add toString method */
	public String toString()
	{
		String output = this.lastName + ", " + this.firstName + "\n	ID Number: " + this.employeeId + "\n	Salary: $" + this.salary;
		return output;
	}

   
	/* Task 3G: Add equals method */
   public Boolean equals(String name)
   {
		if(this.lastName.equalsIgnoreCase(name))
		{
			return true;
		}
		else
		{
			return false;
		}
   }
}


public class EmployeeApp 
{
	public static final int MAX_EMPLOYEES = 5;
   
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner( System.in );
		Employee[]  employees = new Employee[MAX_EMPLOYEES];
		Employee    currentEmployee;
		String      inputString;
		int         inputInt;
		double      inputDouble;
		char        choice;
		int         empCount=0;
      
		employees[empCount++] = new Employee( "Mitchum", "Robert", 120402, 34000.0 );
		employees[empCount++] = new Employee( "Ryan", "Cornelius" );
		employees[empCount++] = new Employee( "Asimov", "Isaac" );

		do 
		{
			System.out.println( "\n   Enter Selection\n   ===============" );
			System.out.println( "A> Add new Employee" );
			System.out.println( "E> Edit Employee" );
			System.out.println( "L> List Employees" );
			System.out.println( "Q> Quit" );
			System.out.print(  "   Select: " );
			inputString = keyboard.nextLine();
			choice = inputString.toUpperCase().charAt( 0 );
			System.out.println();

			switch( choice )
			{
				case 'A':
					if ( empCount < MAX_EMPLOYEES-1 )
					{
						// Create object for new Employee
						employees[empCount] = new Employee();
                
						// Task 3E: Prompt for user information and set the object 
						// parameters via the mutator methods
						System.out.println("What is the Employee's last name? ");
						inputString = keyboard.nextLine();
						employees[empCount].setLastName(inputString);
						System.out.println("What is the Employee's first name? ");
						inputString = keyboard.nextLine();
						employees[empCount].setFirstName(inputString);
						System.out.println("What is the Employee's Id? ");
						inputInt = keyboard.nextInt();
						employees[empCount].setEmployeeId(inputInt);
						System.out.println("What is the Employee's salary? ");
						inputDouble = keyboard.nextDouble();
						employees[empCount].setSalary(inputDouble);
   
						empCount++;
					}
					keyboard.nextLine();
				break;
               
				case 'E':
					System.out.printf( "Enter Last Name of Employee to Edit: " );
					inputString = keyboard.nextLine();
					for ( int lp=0; lp<MAX_EMPLOYEES; lp++ )
					{
						// Verify that the employee entry has been allocated before Editing
						if ( employees[lp] != null )
						{
							if ( employees[lp].equals(inputString))
							{
								System.out.print( "Enter Employee ID    : " );
								inputInt = keyboard.nextInt();
								employees[lp].setEmployeeId( inputInt );
                  
								System.out.print( "Enter Employee Salary: " );
								inputDouble = keyboard.nextDouble();
								employees[lp].setSalary( inputDouble );
   
								keyboard.nextLine();
							}
							
						}
					}
				break;
              
				case 'L':
					for ( int lp=0; lp<MAX_EMPLOYEES; lp++ )
					{
						if(employees[lp] == null)
						{
							System.out.println(employees[lp]);
						}
						else
						{
							System.out.println( employees[lp].toString() );
						}
						
					}
				break;
			}
			keyboard.reset();
		} while( choice != 'Q' );
	}  
}
