/**
 * 
 */
package edu.franklin.secondbank;

/**
 * @author fleigd
 *
 */
public interface Customer 
{
	/**
     * Return the first name of the employee.
     * @return the first name.
     */
    String getFirstName();
    
    /**
     * Change the first name of the employee to the given parameter.
     * @param firstName the new first name.
     */
    void setFirstName(String firstName);
    
    /**
     * Return the last name of the employee.
     * @return the last name.
     */
    String getLastName();

    /**
     * Change the last name of the employee to the given parameter.
     * @param lastName the new last name.
     */
    void setLastName(String lastName);
    
    /**
     * Return the ID of the Employee.
     * @return the ID.
     */
    String getId();
    
    /**
     * Change the ID of the employee to the given parameter.
     * @param id the new ID.
     */
    void setId(String id);
      

}
