package uk.ac.tees.silver.L1087591;
/** 
  <p>   This package contains the solution to the creation of pdf files dynamically for Invoices. </p>
  <p>   Customer has a relationship with the interface InvoicingAlgorithms.  </p>
  <p>   This program is in development. Some of the main things to be added are files reading & multithreading.</p>
  
 <p>Invoices-SOLUTION is free software: you can redistribute it and/or
 modify it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or (at your
 option) any later version.</p>
 	
 <p>This program is distributed in the hope that it will be useful, but
 WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 details.</p>
 
 <p>You should have received a copy of the GNU General Public License along
 with this program. If not, see http://www.gnu.org/licenses/.</p>
 
 <p>Copyright Kiril Anastasov L1087591@live.tees.ac.uk   November-2014 </p>
 */
import java.text.DecimalFormat;

public class Customer 
{
    
    /**
     * @param name represent the name of the Customer
     */
    private String name;

    /**
     * @param amount represent the amount of money
     */
    private double amount;
    
    /**
     * @param i represents object of InvoicingAlgorithm
     */
    private InvoicingAlgorithm i;
    
    /**Customer() is a cunstructor that initializes the name and amount variables.
     * @param name initializes the name of the company
     * @param amount initializes the money in the company
     */
    Customer(String name, double amount)
    {
        this.name = name;
        this.amount = amount;
        
    }

    /**InoicingAlgorithm is a getter method
     * @return i which is a InvoicingAlgorithm object 
     */
    public InvoicingAlgorithm getI() {
        return i;
    }

     /**InoicingAlgorithm is a mutator method.
     * @param i sets the sInvoicingAlgorithm object 
     */
    public void setInvoicingAlgorithm(InvoicingAlgorithm i)
    {
        this.i = i;
    }
    
    /**getInvoice() procces the general data 
     * and call the object of the interface with the passing values.
     * @return name, amount
     */
    public String getInvoice()
    {
        final DecimalFormat df = new DecimalFormat("#.00");
        final String total = "--------------------------------------TO:   "
              + name + "FROM: Easyflap (UK) AMOUNT"  + ":$" 
                + df.format(amount) 
              + "--------------------------------------";
        System.out.println(total);
        i.getInvoice(name, amount);
        return i.getInvoice(name, amount);
    }
}
