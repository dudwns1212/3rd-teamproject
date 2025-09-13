package lx.gymproject.springboot.vo;

public class GymAppointmentVO {
	
	public String id;
	public String userName;
	public String email;
	public String phone; 
	public String address;
	public String appointmentId;
	public String serviceType;
	public String appointmentDate;
	public String appointmentDuration;
	public String status1;
	
	
	public String getStatus1() {
		return status1;
	}
	public void setStatus1(String status1) {
		this.status1 = status1;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getAppointmentDuration() {
		return appointmentDuration;
	}
	public void setAppointmentDuration(String appointmentDuration) {
		this.appointmentDuration = appointmentDuration;
	}
	
	@Override
	public String toString() {
		return "GymAppointmentVO [id=" + id + ", userName=" + userName + ", email=" + email + ", phone=" + phone
				+ ", address=" + address + ", appointmentId=" + appointmentId + ", serviceType=" + serviceType
				+ ", appointmentDate=" + appointmentDate + ", appointmentDuration=" + appointmentDuration + ", status1="
				+ status1 + "]";
	}
	
	
	
}
