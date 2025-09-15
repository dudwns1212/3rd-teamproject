package lx.gymproject.springboot.vo;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

public class GymMachineVO {
	public int machineId;
	public String machineName;
	public LocalDate machinePurchaseDate;
	public double machinePrice;
	public String  machineServiceContact;
	public String  machineImg;
	public String machineVideo;
	
	public MultipartFile file;
	
	 public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	// Getter & Setter
    public int getMachineId() {
        return machineId;
    }
    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    public String getMachineName() {
        return machineName;
    }
    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public LocalDate getMachinePurchaseDate() {
        return machinePurchaseDate;
    }
    public void setMachinePurchaseDate(LocalDate machinePurchaseDate) {
        this.machinePurchaseDate = machinePurchaseDate;
    }

    public double getMachinePrice() {
        return machinePrice;
    }
    public void setMachinePrice(double machinePrice) {
        this.machinePrice = machinePrice;
    }

    public String getMachineServiceContact() {
        return machineServiceContact;
    }
    public void setMachineServiceContact(String machineServiceContact) {
        this.machineServiceContact = machineServiceContact;
    }

    public String getMachineImg() {
        return machineImg;
    }
    public void setMachineImg(String machineImg) {
        this.machineImg = machineImg;
    }

    public String getMachineVideo() {
        return machineVideo;
    }
    public void setMachineVideo(String machineVideo) {
        this.machineVideo = machineVideo;
    }
    
    @Override
	public String toString() {
		return "GymMachineVO [machineId=" + machineId + ", machineName=" + machineName + ", machinePurchaseDate=" + machinePurchaseDate
				+ ", machinePrice=" + machinePrice + ", machineServiceContact=" + machineServiceContact + ", machineImg=" + machineImg + ", machineVideo=" + machineVideo + "]";
	}

}

