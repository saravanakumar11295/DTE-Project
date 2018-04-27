package com.niit.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class Suppiler {
	@Id
    @GeneratedValue
		private int suppilerId;
		
		private String suppilerName;
		private String suppilerMobileNo;
		
		public int getSuppilerId() 
		{
			return suppilerId;
		}
		
		public void setSuppilerId(int suppilerId)
		{
			this.suppilerId = suppilerId;
		}
		
		public String getSuppilerName() 
		{
			return suppilerName;
		}
		
		public void setSuppilerName(String suppilerName)
		{
			this.suppilerName = suppilerName;
		}
		public String getSuppilerMobileNo()
		{
			return suppilerMobileNo;
		}
		public void setSuppilerMobileNo(String suppilerMobileNo) 
		{
			this.suppilerMobileNo = suppilerMobileNo;
		}

}

