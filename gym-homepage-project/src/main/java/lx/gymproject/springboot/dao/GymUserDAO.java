package lx.gymproject.springboot.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lx.gymproject.springboot.vo.GymUserVO;

@Component
public class GymUserDAO {
	
	@Autowired
	SqlSession session;
	
	public GymUserVO doLoginByUserId(String userEmail) {
		return session.selectOne("doLoginById",userEmail);
	}
	
	public int doRegisterByUserVO(GymUserVO vo) {
		return session.insert("doRegisterByUserVO",vo);

	}
	
	public int updateUserInfo(GymUserVO vo) {
		System.out.println("업데이트 실행" + vo);
		return session.update("updateUserVO", vo);
	}
		
}
