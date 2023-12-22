package kr.co.dong.mindbook;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


















@Controller
public class MdController {
	private static final Logger logger = LoggerFactory.getLogger(MdController.class);
	
	@Inject
	private MdService service;
	//로그인폼
	@GetMapping(value ="login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		logger.info("로그인폼으로 이동 =====>");
		mav.setViewName("login");
		return mav;
	}
	//로그인!
	@RequestMapping(value="login", method= RequestMethod.POST)
	public String login(@RequestParam Map<String,Object> map,
			HttpServletRequest request, HttpServletResponse response,HttpSession session) throws Exception {
		request.setCharacterEncoding("utf-8");
		logger.info("요청정보 받아서 보내기");
		
		Map user = service.login(map);
		
		if(user == null) { //로그인 실패
			logger.info("로그인 안됨");
			return "redirect:login";
		}else {  // 로그인 성공
			//세션부여
			session.setAttribute("user", user);
			return "redirect:/";
		}		
	}
	
	//로그아웃
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session, RedirectAttributes rttr) {
		session.invalidate();
		rttr.addFlashAttribute("msg", "로그아웃되었습니다");
		return "redirect:/";
	}	
	// 캘린더
//	@GetMapping(value="calendar")
//	public ModelAndView calendar() {
//		ModelAndView mav = new ModelAndView();
//		logger.info("로그인폼으로 이동 =====>");
//		mav.setViewName("calendar3");
//		return mav;
//	}
	
	 @GetMapping("/calendar")
	 //session으로 사용자 정보를 불러오는 코드가 없음 (uid값을 못받아옴)
	    public ModelAndView getCalendarList(ModelAndView mv, HttpSession session) {
	        String viewpage = "calendar2";
	        try {
	            // 세션에서 "user" 속성을 가져옴
	            Map<String, Object> user = (Map<String, Object>) session.getAttribute("user");
	            if (user != null) {
	                // "user" 속성에서 "uid" 값을 추출
	                Object uidObject = user.get("uid");
	                if (uidObject != null) {
	                    // "uid" 값을 정수로 변환
	                    int uid = Integer.parseInt(String.valueOf(uidObject));
	                    // uid를 사용하여 캘린더 데이터를 가져옴
	                    List<MdDTO> calendar = service.getCalendar(uid);
	                    // ModelAndView에 calendarList 속성 설정
	                    mv.addObject("calendarList", calendar);
	                } else {
	                    // "uid"가 null인 경우 처리
	                }
	            } 
	        } catch (Exception e) {
	            // 기타 예외 처리
	            e.printStackTrace();
	        }
	        // ModelAndView에 뷰 이름 설정
	        mv.setViewName(viewpage);
	        return mv;
	    }
	
	
	
    
	
	// 회원가입 폼
	@GetMapping("signup")
	public ModelAndView signUp() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("signup");
		return mv;
	}
	
	
	// 회원가입
//	@PostMapping(value = "signup")
//	public ModelAndView signup2(MdDTO dto) {
//		ModelAndView mav = new ModelAndView();
//		int upResult=service.signup(dto);
//		mav.addObject("upResult",upResult);
//		mav.setViewName("result");
//		logger.info("666666666666666666");
//		return mav;
//	}
	
	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String postRegister(MdDTO dto) throws Exception {
		logger.info("post!");
		int result = service.idcheck(dto);
		try {
			if(result == 1) {
				return "signup";
			}else if(result == 0) {
				service.idcheck(dto);
			}
		
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return "redirect:/";
	}
	
//	@RequestMapping(value="list",method= RequestMethod.GET)
//	public ModelAndView list() {
//		logger.info("====list=====");
//		ModelAndView mav = new ModelAndView();
//		List<MdDTO> list = service.list();
//		mav.addObject("list", list);
//		mav.setViewName("list");
//		return mav;
//	}
//	@ResponseBody
//	@RequestMapping(value="/idChk", method = RequestMethod.POST)
//	public int idChk(MdDTO vo) throws Exception {
//		int result = service.idcheck(vo);
//		return result;
//	}

	
	@RequestMapping(value="insert", method= RequestMethod.GET)
	public String insertform() {
		logger.info("글쓰기 이동");
		return "insert";
	}
	
	@PostMapping("calendarInsert")
    public ModelAndView insert(HttpSession session,
            @RequestParam("CALENDAR_TITLE")String CALENDAR_TITLE,
            @RequestParam("CALENDAR_MEMO")String CALENDAR_MEMO,
            @RequestParam("CALENDAR_START") @DateTimeFormat(pattern = "yyyy-MM-dd") Date CALENDAR_START) {
        System.out.println("insert 실행");

        ModelAndView mav = new ModelAndView();
         try {
                // 세션에서 "user" 속성을 가져옴
                Map<String, Object> user = (Map<String, Object>) session.getAttribute("user");
                if (user != null) {
                    // "user" 속성에서 "uid" 값을 추출
                    Object uidObject = user.get("uid");
                    MdDTO dto = new MdDTO();
                    dto.setCALENDAR_TITLE(CALENDAR_TITLE);
                    dto.setCALENDAR_MEMO(CALENDAR_MEMO);
                    dto.setCALENDAR_START(CALENDAR_START);
                    dto.setUser_uid(String.valueOf(uidObject));
                    System.out.println(dto);
                    service.insert(dto);
                    List<MdDTO> list = service.getCalendar(Integer.parseInt(String.valueOf(uidObject)));
                    System.out.println(Integer.parseInt(String.valueOf(uidObject)));
                    mav.addObject("calendarList", list);
                    mav.setViewName("calendar2");


                } 
            } catch (Exception e) {
                // 기타 예외 처리
                e.printStackTrace();
            }
                return mav;
    }
	
	
// 글삭제 
	@GetMapping(value = "delete")
	public ModelAndView delete(HttpSession session ,int CALENDAR_NO,MdDTO dto)throws Exception  {
		ModelAndView mav = new ModelAndView();
			service.delete(CALENDAR_NO);
			mav.addObject("list", service.getCalendar(CALENDAR_NO));
			mav.setViewName("redirect:/calendar2");
			return mav;
	}
	
	

//		
//	//글 수정(폼)
//	@GetMapping(value = "update")
//	public ModelAndView update(@RequestParam("cal_no") int cal_no) {
//		ModelAndView mav = new ModelAndView();
//		MdDTO mdDTO = service.detail(cal_no);
//		mav.addObject("mdDTO", mdDTO);
//		mav.setViewName("update");
//		return mav;
//	}
//	
//	//글수정
//	@RequestMapping(value = "update", method = RequestMethod.POST)
//	public String update(MdDTO mdDTO, RedirectAttributes attr,HttpServletRequest request) throws Exception {
//		request.setCharacterEncoding("utf-8");
//		int r = service.update(mdDTO);
//		// 수정에 성공하면 목록보기로 이동
//		if (r > 0) {
//			attr.addFlashAttribute("msg", "수정에 성공 하였습니다.");
//			return "redirect:list";
//		}
//		// 수정에 실패하면 수정보기 화면으로 이동
//		return "redirect:update?Cal_no=" + mdDTO.getCal_no();
//	}
//	
//	
//	
//	
//	// 읽기
//	@RequestMapping(value = "detail", method = RequestMethod.GET)
//	public ModelAndView detail(@RequestParam("cal_no")int cal_no) {
//		ModelAndView mav = new ModelAndView();
//		
//		MdDTO mdDTO= service.detail(cal_no);
//		logger.info("읽기 이동" + service.detail(cal_no));
//		mav.addObject("mdDTO", mdDTO);
//		mav.setViewName("detail");
//		return mav;
//	}
//	
//	
//	//삭제
//
//	
//	@RequestMapping(value="delete",method = RequestMethod.GET)
//	public String delete(@RequestParam("cal_no") int cal_no, RedirectAttributes rttr) {
//		int r = service.delete(cal_no);
//		
//		if(r > 0) {
//			rttr.addFlashAttribute("msg","글삭제에 성공하였습니다.");
//			return "redirect:list";
//		}
//		return "redirect:detail?cal_no=" + cal_no;
//	}
	
	
	}

	

