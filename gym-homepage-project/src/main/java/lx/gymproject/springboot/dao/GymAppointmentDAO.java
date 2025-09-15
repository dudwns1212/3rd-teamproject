package lx.gymproject.springboot.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return session.selectList("getDBListPaging", params);
    }

    // 접수 중인 개수 조회
    public int getDBCount() throws Exception {
        return session.selectOne("getDBCount");
    }
    // 총 접수 개수
    public int getDBCountAll() throws Exception {
    	return session.selectOne("getDBCountAll");
    }
	
    
    public GymAppointmentVO getAppointmentById(String id) throws Exception {
        return session.selectOne("getAppById", id);
    }
    
	public int updateStatus(String id, String status1) throws Exception {
	    HashMap<String, String> param = new HashMap<>();
	    System.out.println("update 실행: id=" + id + ", status1=" + status1);
	    System.out.println("실행");
	    param.put("id", id);
	    param.put("status1", status1);
	    return session.update("updateAppStatus", param);
	}
    
    
}