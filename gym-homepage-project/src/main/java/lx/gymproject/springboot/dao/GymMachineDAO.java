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
	

	public GymMachineVO getMachine(int machineId) throws Exception {
		System.out.println("getMachine실행됨");
		return session.selectOne("getMachine",machineId);
	}
	
	public List<GymMachineVO> getMachineList(){
		
		System.out.println("getMachineList실행됨");

		return session.selectList("getMachineList");
	}
	
	public int updateMachine(GymMachineVO machineId) throws Exception {
		System.out.println("updateMachine실행됨");
		return session.update("updateMachine", machineId);
	}
	
	
	
	  public int insertMachine(GymMachineVO machine) throws Exception{
		  		System.out.println("insertMachine실행됨"); return
			  session.insert("insertMachine", machine); 
	  }
	  
	  public int deleteMachine(int machineId) throws Exception{
	  		System.out.println("deleteMachine실행됨"); 
	  		return session.insert("deleteMachine", machineId); 
	  }
	  		
}
