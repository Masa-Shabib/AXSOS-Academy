package com.caresoft.users;

import java.util.ArrayList;
import java.util.Date;

import com.caresoft.clinicapp.HIPAACompliantAdmin;
import com.caresoft.clinicapp.HIPAACompliantUser;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	
	private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    
    // TO DO: Implement a constructor that takes an ID and a role
    public AdminUser(Integer id,String role) {
		super(id);
		// TODO Auto-generated constructor stub
		this.role=role;
		this.securityIncidents=new ArrayList<String>(); 
	}
    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!
    @Override
	public ArrayList<String> reportSecurityIncidents() {
		// TODO Auto-generated method stub
    	ArrayList<String> reports= getSecurityIncidents(); 
		return reports;
	}
    
	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		String pin1 = Integer.toString(pin);
    	if (pin1.length()==6) {
    		return true;
    	}
    	else {
    		return false;
    	}
	}
	
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		if (this.id.equals(confirmedAuthID)) {
			return true;
		}
		else {
			authIncident();
    		return false;
    	}
	}
    
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
    // TO DO: Setters & Getters
	public Integer getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}
	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
	
    
    
}
