package com.yhsong.caresoft_interface;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAAComplianceUser, HIPAAComplianceAdmin{
	
	private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    
    public AdminUser(Integer employeeID, String role) {
    	super(employeeID);
    	this.role = role;
    	this.employeeID = employeeID;
    	this.securityIncidents = new ArrayList<String>();
    }
    
    // TO DO: Implement a constructor that takes an ID and a role
    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!
    @Override
    public boolean assignPin(int pin) {
    	// TODO Auto-generated method stub
    	if(String.valueOf(pin).length() >= 6) {
    		this.pin = pin;
    		return true;
    	}
    	return false;
    }
    
    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
    	// TODO Auto-generated method stub
    	if(confirmedAuthID == this.employeeID) {
    		return true;
    	}
    	authIncident();
    	return false;
    }
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    
    @Override
	public ArrayList<String> reportSecurityIncidents() {
		// TODO Auto-generated method stub
    	System.out.println(securityIncidents);
		return securityIncidents;
	}
	public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
}
