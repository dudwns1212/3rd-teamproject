package lx.gymproject.springboot.controller;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import lx.gymproject.springboot.dao.GymAppointmentDAO;
import lx.gymproject.springboot.vo.GymAppointmentVO;


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
    public String dashboard(Model model, @RequestParam(defaultValue = "1") int page) {
        try {
            int pageSize = 10;
            int offset = (page - 1) * pageSize;

            List<GymAppointmentVO> appointmentList = appDao.getDBListPaging(offset, pageSize);
            int totalAppointments = appDao.getDBCount();

            int totalPages = (int) Math.ceil((double) totalAppointments / pageSize);

            model.addAttribute("appointments", appointmentList);
            model.addAttribute("totalAppointments", totalAppointments);
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPages", totalPages);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "reservation/dashboard";
    }
	
}
