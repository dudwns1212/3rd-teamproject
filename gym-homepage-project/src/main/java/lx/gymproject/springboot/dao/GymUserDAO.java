package lx.gymproject.springboot.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lx.gymproject.springboot.vo.UserVO;

@Component
public class GymUserDAO {

	@Autowired
	SqlSession session;
	
	public UserVO doLoginById(String userEmail) {
		return session.selectOne(userEmail);
	}
	
	
}
