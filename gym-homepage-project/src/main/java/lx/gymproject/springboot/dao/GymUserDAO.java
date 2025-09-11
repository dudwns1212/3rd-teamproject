package lx.gymproject.springboot.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lx.gymproject.springboot.vo.GymUserVO;

@Component
public class GymUserDAO {

	@Autowired
	SqlSession session;
	
	public GymUserVO doLoginById(String userEmail) {
		return session.selectOne("doLoginById",userEmail);
	}
	
	public int doRegisterByUserVO(GymUserVO vo) {
		System.out.println("실행됨" + vo);
		return session.insert("doRegisterByUserVO",vo);
	}
	
	
}
