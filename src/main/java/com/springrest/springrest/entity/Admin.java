package com.springrest.springrest.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;



@Entity
@Table(name = "Register_Admin")
public class Admin extends User {
	    @Column(name = "name",length = 50,nullable = false)
		private String adminName;
		
		
	    @Column(name="email",length = 100,unique = true,nullable = false)
		private String adminEmail;
		
	    @Column(name="phoneNo",length = 100,unique = true,nullable = false)
		private String adminPhoneNo;
	    
	    @Column(name="gender",nullable = false)
	    private String gender;
	    /**
		 * @param id
		 * @param userName
		 * @param password
		 * @param role
		 * @param adminName
		 * @param email
		 * @param adminPhoneNo
		 */

		public Admin() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Admin(int id, String userName, String password, String role) {
			super(id, userName, password, role);
			// TODO Auto-generated constructor stub
		}

		public Admin(int id, String userName, String password, String role, String adminName, String adminEmail,
				String adminPhoneNo, String gender) {
			super(id, userName, password, role);
			this.adminName = adminName;
			this.adminEmail = adminEmail;
			this.adminPhoneNo = adminPhoneNo;
			this.gender = gender;
		}

		public String getAdminName() {
			return adminName;
		}

		public void setAdminName(String adminName) {
			this.adminName = adminName;
		}

		public String getAdminEmail() {
			return adminEmail;
		}

		public void setAdminEmail(String adminEmail) {
			this.adminEmail = adminEmail;
		}

		public String getAdminPhoneNo() {
			return adminPhoneNo;
		}

		public void setAdminPhoneNo(String adminPhoneNo) {
			this.adminPhoneNo = adminPhoneNo;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		@Override
		public String toString() {
			return "Admin [adminName=" + adminName + ", adminEmail=" + adminEmail + ", adminPhoneNo=" + adminPhoneNo
					+ ", gender=" + gender + "]";
		}

		

		
		
}
