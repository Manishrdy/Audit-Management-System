package com.cognizant.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditDetails {
	
	private String auditType;
	
	public String getAuditType() {
		return auditType;
	}

	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}

	public Date getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

//	public AuditDetails(String auditType, Date auditDate) {
//		super();
//		this.auditType = auditType;
//		this.auditDate = auditDate;
//	}

	private Date auditDate;
	
	

}
