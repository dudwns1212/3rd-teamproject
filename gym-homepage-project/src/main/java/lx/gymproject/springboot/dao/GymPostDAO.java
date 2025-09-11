package lx.gymproject.springboot.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lx.gymproject.springboot.vo.GymPostVO;
import lx.gymproject.springboot.vo.UserVO;

@Component
public class GymPostDAO {

	@Autowired
	SqlSession session;
	
	public int insertDB(GymPostVO po) throws Exception {
		return session.insert("insertDB", po);
	}
	
	public List<GymPostVO> getDBList() throws Exception {
		return session.selectList("getDBList");
	}
	
	public GymPostVO getDB(int poId) throws Exception {
		return session.selectOne("getDB", poId);
	}
	
	public int updateDB(GymPostVO vo) throws Exception {
		return session.update("updateDB", vo);
	}
	
	public boolean deleteDB(int poId) throws Exception {
		return false;
	}
	
}
