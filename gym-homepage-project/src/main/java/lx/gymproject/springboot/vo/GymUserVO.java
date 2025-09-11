package lx.gymproject.springboot.vo;

public class GymUserVO {
	
	public int userId;
	public String gymPeriod;
	public boolean useLocker;
	public boolean useTranning;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getGymPeriod() {
		return gymPeriod;
	}
	public void setGymPeriod(String gymPeriod) {
		this.gymPeriod = gymPeriod;
	}
	public boolean isUseLocker() {
		return useLocker;
	}
	public void setUseLocker(boolean useLocker) {
		this.useLocker = useLocker;
	}
	public boolean isUseTranning() {
		return useTranning;
	}
	public void setUseTranning(boolean useTranning) {
		this.useTranning = useTranning;
	}
	@Override
	public String toString() {
		return "GymUserVO [userId=" + userId + ", gymPeriod=" + gymPeriod + ", useLocker=" + useLocker
				+ ", useTranning=" + useTranning + "]";
	}
}
