package lx.gymproject.springboot.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lx.gymproject.springboot.vo.GymPostCommentVO;

@Component
public class GymPostCommentDAO {

	@Autowired
	SqlSession session;

	public List<GymPostCommentVO> getCommentsByPostId(int poId) {
		return session.selectList("getCommentsByPostId", poId);
	}

	public int insertComment(GymPostCommentVO vo) {
		return session.insert("insertComment", vo);
	}
	
	public int deletePostCommentByCmId(int cmId) {
		return session.delete("deletePostCommentByCmId", cmId);
	}

}
