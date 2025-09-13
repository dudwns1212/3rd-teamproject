package lx.gymproject.springboot.vo;

public class GymPostVO {
	
	public int poId;
	public String poName;
	public String poContent;
	public int poUserId;
	public String poTag;
	public String poImg;
	public int poLike;
	public int poView;
	public int poDislike;
	public int poBoardCode;
	
	
	public int getPoId() {
		return poId;
	}
	public void setPoId(int poId) {
		this.poId = poId;
	}
	public String getPoName() {
		return poName;
	}
	public void setPoName(String poName) {
		this.poName = poName;
	}
	public String getPsContent() {
		return poContent;
	}
	public void setPsContent(String poContent) {
		this.poContent = poContent;
	}
	public int getPoUserId() {
		return poUserId;
	}
	public void setPoUserId(int poUserId) {
		this.poUserId = poUserId;
	}
	public String getPoTag() {
		System.out.println(poTag);
		return poTag;
	}
	public void setPoTag(String poTag) {
		this.poTag = poTag;
	}
	public String getPoImg() {
		return poImg;
	}
	public void setPoImg(String poImg) {
		this.poImg = poImg;
	}
	public int getPoLike() {
		return poLike;
	}
	public void setPoLike(int poLike) {
		this.poLike = poLike;
	}
	public int getPoview() {
		return poView;
	}
	public void setPoview(int poview) {
		this.poView = poview;
	}
	public int getPoDislike() {
		return poDislike;
	}
	public void setPoDislike(int poDislike) {
		this.poDislike = poDislike;
	}
	public int getPoBoardCode() {
		return poBoardCode;
	}
	public void setPoBoardCode(int poBoardCode) {
		this.poBoardCode = poBoardCode;
	}
	
	
	@Override
	public String toString() {
		return "GymPostVO [poId=" + poId + ", poName=" + poName + ", psContent=" + poContent + ", poUserId=" + poUserId
				+ ", poTag=" + poTag + ", poImg=" + poImg + ", poLike=" + poLike + ", poview=" + poView + ", poDislike="
				+ poDislike + ", poBoardCode=" + poBoardCode + "]";
	}

}
