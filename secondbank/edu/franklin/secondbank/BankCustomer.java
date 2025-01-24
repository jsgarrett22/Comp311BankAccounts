/**
 * 
 */
package edu.franklin.secondbank;

/**
 * @author fleigd
 *
 */
public class BankCustomer implements Customer 
{
	   private String firstName;
	    private String lastName;
	    private String id;

	    /**
	     * Return the first name of the employee.
	     * @return the first name.
	     */
	    public String getFirstName()
	    {
	        /*
	         * Students to fill code in here.
	         */
	        return firstName;
	        
	        //return null;
	    }
	    
	    /**
	     * Change the first name of the employee to the given parameter.
	     * @param first the new first name.
	     */
	    public void setFirstName(String first)
	    {
	        /*
	         * Students to fill code in here.
	         */ 
	        firstName = first;
	    }
	    
	    /**
	     * Return the last name of the employee.
	     * @return the last name.
	     */
	    public String getLastName()
	    {
	        /*
	         * Students to fill code in here.
	         */
	        return lastName;
	        //return null;
	    }

	    /**
	     * Change the last name of the employee to the given parameter.
	     * @param last the new last name.
	     */
	    public void setLastName(String last)
	    {
	        /*
	         * Students to fill code in here.
	         */
	        lastName = last;
	    }        
	    
	    /**
	     * Return the ID of the Employee.
	     * @return the ID.
	     */
	    public String getId()
	    {
	        /*
	         * Students to fill code in here.
	         */
	        return id;
	        //return null;
	    }        
	    
	    /**
	     * Change the ID of the employee to the given parameter.
	     * @param newId the new ID.
	     */
	    public void setId(String newId)
	    {
	        /*
	         * Students to fill code in here.
	         */
	        id = newId;
	    }      

}
