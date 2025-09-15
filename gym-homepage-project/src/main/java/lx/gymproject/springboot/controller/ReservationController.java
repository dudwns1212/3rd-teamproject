package lx.gymproject.springboot.controller;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import lx.gymproject.springboot.dao.GymAppointmentDAO;
import lx.gymproject.springboot.vo.GymAppointmentVO;
import lx.gymproject.springboot.vo.GymUserVO;


@Controller
public class ReservationController {
	
	@Autowired
	SqlSession session;
	
	@Autowired
	GymAppointmentDAO appDao;
	
	@GetMapping("/reservation.do")
	public String reservation() throws Exception {
		
		return "reservation/reservation";
	}
	
	@GetMapping("appointmentHome.do")
	public String appointmentHome() {
		return "reservation/appointmentHome";
	}
	
	@PostMapping("/revervationInsert.do")
	public String insert(GymAppointmentVO vo) throws Exception {
		appDao.insertDB1(vo);
		return "redirect:reservationDashboard.do";
	}

	@GetMapping("reservationDashboard.do")
    public String dashboard(Model model, HttpSession session, @RequestParam(defaultValue = "1") int page) {
		try {
            int pageSize = 10;
            int offset = (page-1) * pageSize;
            
            List<GymAppointmentVO> appointmentList = appDao.getDBListPaging(offset, pageSize);
            int totalAppointments = appDao.getDBCountAll();
            int Appointment = appDao.getDBCount();

            int totalPages = (int) Math.ceil((double) totalAppointments / pageSize);

            // 로그인한 사용자 정보
            GymUserVO loginUser = (GymUserVO) session.getAttribute("loginUser");

            // 관리자 여부 확인
            boolean isManager = false;
            if (loginUser != null && "1@1.com".equals(loginUser.getUserEmail())) {
                isManager = true;
            }

            model.addAttribute("appointments", appointmentList);
            model.addAttribute("totalAppointments", totalAppointments);
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPages", totalPages);
            model.addAttribute("isManager", isManager);
            model.addAttribute("Appointment", Appointment);

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("currentPage", 1);
            model.addAttribute("totalPages", 1);
        }

        return "reservation/dashboard";
    }
	
	@PostMapping("/completeReservation")
    public String completeReservation(@RequestParam(value = "id") String id) throws Exception {
			System.out.println(id);
            int a = appDao.updateStatus(id, "완료");
            System.out.println(a);
            

        // 예약 대시보드로 리다이렉트
        return "redirect:reservationDashboard.do";
    }
	
}
