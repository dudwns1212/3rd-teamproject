package lx.gymproject.springboot.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lx.gymproject.springboot.vo.GymPostCommentVO;

@Component
public class GymPostCommentDAO {

	@Autowired
	SqlSession sqlSession;

	public List<GymPostCommentVO> getCommentsByPostId(int poId) {
		return sqlSession.selectList("getCommentsByPostId", poId);
	}

	public int insertComment(GymPostCommentVO vo) {
		return sqlSession.insert("insertComment", vo);
	}

}
