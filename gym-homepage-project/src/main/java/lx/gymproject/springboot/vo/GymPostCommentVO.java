package lx.gymproject.springboot.vo;

public class GymPostCommentVO {
	
	public int cmId;
    public int poId;
    public int userId;
    public String authorName;
    public String cmContent;
    public String cmTime;
	
    public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
    public int getCmId() {
		return cmId;
	}
	public void setCmId(int cmId) {
		this.cmId = cmId;
	}
	public int getPoId() {
		return poId;
	}
	public void setPoId(int poId) {
		this.poId = poId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getCmContent() {
		return cmContent;
	}
	public void setCmContent(String cmContent) {
		this.cmContent = cmContent;
	}
	public String getCmTime() {
		return cmTime;
	}
	public void setCmTime(String cmTime) {
		this.cmTime = cmTime;
	}
	@Override
	public String toString() {
		return "PostCommentVO [cmId=" + cmId + ", poId=" + poId + ", authorName=" + authorName + ", cmContent="
				+ cmContent + ", cmTime=" + cmTime + "]";
	}
    
}

