package com.yhsong.caresoft_interface;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAAComplianceUser{

    // Inside class: 
	private ArrayList<String> patientNotes;
	
    // TO DO: Constructor that takes an ID
	public Physician(Integer id) {
		super(id);
		
	}
    
    // TO DO: Implement HIPAACompliantUser!
    @Override
    public boolean assignPin(int pin) {
    	// TODO Auto-generated method stub
    	if (String.valueOf(pin).length() == 4) {
    		this.pin = pin;
    		return true;
    	}
    	else {
    		return false;			
    	}
    }
    

	@Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
    	// TODO Auto-generated method stub
    	if (this.id == confirmedAuthID) {
    		return true;
    	}
    	else {
    		return false;			
    	}
    }

	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
    // TO DO: Setters & Getters

	
}
