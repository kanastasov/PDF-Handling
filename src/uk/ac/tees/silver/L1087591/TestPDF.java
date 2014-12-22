package uk.ac.tees.silver.L1087591;

/** 
  <p>   This package contains the solution to the creation of pdf files dynamically for Invoices. </p>
  <p>   TestPDF is responsible for the creation of the pdf files with the main maethod.  </p>
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

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestPDF 
{
    
    /** Path to the resulting PDF file. */
    public static final String RESULT
        = "src\\uk\\ac\\tees\\silver\\L1087591/hello.pdf";
    
    /**
     * Creates a PDF file: hello.pdf
     * @param    args    no arguments needed
     */
    public static void main(String[] args)
    	throws DocumentException, IOException 
    {
        
        System.out.println("Producing American invoice");
        final int invoiceAmount = 500;
        final Customer c = new Customer("Oracle", invoiceAmount);
        c.setInvoicingAlgorithm(new AmericanInvoice());
        String actualOutput = c.getInvoice();
        
        System.out.println("Producing European invoice");
        final int invoiceAmount3 = 17023;
        final Customer c3 = new Customer("Siemens", invoiceAmount);
        c3.setInvoicingAlgorithm(new EuropeanInvoice());
        String actualOutput3 = c3.getInvoice();
        
        System.out.println("Producing Japanese invoice");
        final int invoiceAmount2 = 7200;
        final Customer c2 = new Customer("Honda", invoiceAmount);
        c2.setInvoicingAlgorithm(new JapaneseInvoice());
        String actualOutput2 = c2.getInvoice();
        
        
        
    }
    
}