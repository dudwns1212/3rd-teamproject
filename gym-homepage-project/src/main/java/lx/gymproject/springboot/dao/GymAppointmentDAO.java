package lx.gymproject.springboot.dao;

import java.util.HashMap;
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
	
	 // 페이징된 리스트
    public List<GymAppointmentVO> getDBListPaging(int offset, int limit) throws Exception {
        HashMap<String, Integer> params = new HashMap<>();
        params.put("offset", offset);
        params.put("limit", limit);
        return session.selectList("getAppListPaging", params);
    }

    // 총 개수
    public int getDBCount() throws Exception {
        return session.selectOne("getAppCount");
    }
	
}
