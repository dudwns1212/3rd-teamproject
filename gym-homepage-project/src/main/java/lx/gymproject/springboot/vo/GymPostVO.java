package lx.gymproject.springboot.vo;

import org.springframework.web.multipart.MultipartFile;

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
	
	public MultipartFile file;
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}


	public String authorName;	
	
	public String getPoContent() {
		return poContent;
	}
	public void setPoContent(String poContent) {
		this.poContent = poContent;
	}
	public int getPoView() {
		return poView;
	}
	public void setPoView(int poView) {
		this.poView = poView;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
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
		return "GymPostVO [poId=" + poId + ", poName=" + poName + ", poContent=" + poContent + ", poUserId=" + poUserId
				+ ", poTag=" + poTag + ", poImg=" + poImg + ", poLike=" + poLike + ", poView=" + poView + ", poDislike="
				+ poDislike + ", poBoardCode=" + poBoardCode + ", file=" + file + ", authorName=" + authorName + "]";
	}

}
