package lx.gymproject.springboot.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import lx.gymproject.springboot.vo.GymMachineVO;

@Component
public class GymMachineDAO {
	@Autowired
	SqlSession session;
	
	
	public GymMachineVO getMachine() throws Exception {
		System.out.println("실행됨");
		return session.selectOne("getMachine");
	}
	
	public List<GymMachineVO> getMachineList(){
		return session.selectList("getMachineList");
	}
	
	
}
