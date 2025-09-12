package lx.gymproject.springboot.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lx.gymproject.springboot.vo.GymAppointmentVO;


@Component
public class GymAppointmentDAO {

	@Autowired
	SqlSession session;
	
	public int insertDB1(GymAppointmentVO ap) throws Exception {
		return session.insert("insertApp", ap);
	}
	
	public List<GymAppointmentVO> getDBList() throws Exception {
		return session.selectList("getAppList");
	}
	
	
}
