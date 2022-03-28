package com.bitwin.bangbang;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.UUID;

import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bitwin.domain.paqVO;
import com.bitwin.bangbang.member.domain.LoginInfo;
import com.bitwin.domain.Criteria;
import com.bitwin.domain.PageDTO;
import com.bitwin.service.paqService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("member/paq/*")
@AllArgsConstructor
public class member_paqController {
	
	private paqService service;
	

	
	@GetMapping("/member-list")
	public void memberList(Criteria cri, Model model , HttpSession  session) {
		
		log.info("list: " + cri);
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		cri.setUidx(loginInfo.getUidx());
		model.addAttribute("list", service.memberGetList(cri));
//		model.addAttribute("pageMaker", new PageDTO(cri, 200));
		
		int total = service.memberGetTotal(cri);
		
		log.info("total: " + total);
		
		model.addAttribute("pageMaker", new PageDTO(cri, total));

		
	}
	
	
	  @GetMapping({"/get", "/reply-register"})
		public void get(@RequestParam("pqidx") int pqidx, @ModelAttribute("cri") Criteria cri, Model model) {
			
			log.info("/get or replyRegister");
			model.addAttribute("paq", service.get(pqidx));
			
		}
	
	  
		@GetMapping("/member-register")
		public void memberRegister() {
			
		}
	
	@PostMapping("/member-register")
	public String register(paqVO paq, RedirectAttributes rttr , HttpSession  session) {
		
		log.info("register: " + paq);
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		paq.setUidx(loginInfo.getUidx());
		service.register(paq);
		
		rttr.addFlashAttribute("result", paq.getPqidx());
		
		return "redirect:/member/paq/member-list";
	}
	
	@GetMapping({"/member-get"})
	public void memberGet(@RequestParam("pqidx") int pqidx, @ModelAttribute("cri") Criteria cri, Model model) {
		
		
		log.info("/adminGet or modify");
		model.addAttribute("paq", service.get(pqidx));
		
	}
	
	
	
	
	
	  
	  
	
	

		
	
	
	
	
	
	
	 // �씠誘몄� �뾽濡쒕뱶
    @RequestMapping(value="/imageUpload", method = RequestMethod.POST)
    public void imageUpload(HttpServletRequest request,
    		HttpServletResponse response, MultipartHttpServletRequest multiFile
    		, @RequestParam MultipartFile upload) throws Exception{
    	// �옖�뜡 臾몄옄 �깮�꽦
    	UUID uid = UUID.randomUUID();
    	
    	OutputStream out = null;
    	PrintWriter printWriter = null;
    	
    	//�씤肄붾뵫
    	response.setCharacterEncoding("utf-8");
    	response.setContentType("text/html;charset=utf-8");
    	try{
    		//�뙆�씪 �씠由� 媛��졇�삤湲�
    		String fileName = upload.getOriginalFilename();
    		byte[] bytes = upload.getBytes();
    		
    		//�씠誘몄� 寃쎈줈 �깮�꽦
    		String path = "C:\\Users\\gusm9\\Pictures\\Saved Pictures" + "ckImage/";	// �씠誘몄� 寃쎈줈 �꽕�젙(�뤃�뜑 �옄�룞 �깮�꽦)
    		String ckUploadPath = path + uid + "_" + fileName;
    		File folder = new File(path);
    		System.out.println("path:"+path);	// �씠誘몄� ���옣寃쎈줈 console�뿉 �솗�씤
    		//�빐�떦 �뵒�젆�넗由� �솗�씤
    		if(!folder.exists()){
    			try{
    				folder.mkdirs(); // �뤃�뜑 �깮�꽦
    		}catch(Exception e){
    			e.getStackTrace();
    		}
    	}
    	
    	out = new FileOutputStream(new File(ckUploadPath));
    	out.write(bytes);
    	out.flush(); // outputStram�뿉 ���옣�맂 �뜲�씠�꽣瑜� �쟾�넚�븯怨� 珥덇린�솕
    	
    	String callback = request.getParameter("CKEditorFuncNum");
    	printWriter = response.getWriter();
    	String fileUrl = "/bangbang/member/paq/ckImgSubmit?uid=" + uid + "&fileName=" + fileName; // �옉�꽦�솕硫�
    	
    	// �뾽濡쒕뱶�떆 硫붿떆吏� 異쒕젰
    	printWriter.println("{\"filename\" : \""+fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}");
    	printWriter.flush();
    	
    	}catch(IOException e){
    		e.printStackTrace();
    	} finally {
    		try {
    		if(out != null) { out.close(); }
    		if(printWriter != null) { printWriter.close(); }
    	} catch(IOException e) { e.printStackTrace(); }
    	}
    	return;
    }
	
	
	
    // �꽌踰꾨줈 �쟾�넚�맂 �씠誘몄� 肉뚮젮二쇨린
    @RequestMapping(value="/ckImgSubmit")
    public void ckSubmit(@RequestParam(value="uid") String uid
    		, @RequestParam(value="fileName") String fileName
    		, HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
    	
    	//�꽌踰꾩뿉 ���옣�맂 �씠誘몄� 寃쎈줈
    	String path = "C:\\Users\\gusm9\\Pictures\\Saved Pictures" + "ckImage/";	// ���옣�맂 �씠誘몄� 寃쎈줈
    	System.out.println("path:"+path);
    	String sDirPath = path + uid + "_" + fileName;
    	
    	File imgFile = new File(sDirPath);
    	
    	//�궗吏� �씠誘몄� 李얠� 紐삵븯�뒗 寃쎌슦 �삁�쇅泥섎━濡� 鍮� �씠誘몄� �뙆�씪�쓣 �꽕�젙�븳�떎.
    	if(imgFile.isFile()){
    		byte[] buf = new byte[1024];
    		int readByte = 0;
    		int length = 0;
    		byte[] imgBuf = null;
    		
    		FileInputStream fileInputStream = null;
    		ByteArrayOutputStream outputStream = null;
    		ServletOutputStream out = null;
    		
    		try{
    			fileInputStream = new FileInputStream(imgFile);
    			outputStream = new ByteArrayOutputStream();
    			out = response.getOutputStream();
    			
    			while((readByte = fileInputStream.read(buf)) != -1){
    				outputStream.write(buf, 0, readByte); 
    			}
    			
    			imgBuf = outputStream.toByteArray();
    			length = imgBuf.length;
    			out.write(imgBuf, 0, length);
    			out.flush();
    			
    		}catch(IOException e){
    			e.printStackTrace();
    		}finally {
    			outputStream.close();
    			fileInputStream.close();
    			out.close();
    			}
    		}
    }
    
    
    
	@Autowired
	private JavaMailSender mailSender;
    
	//mailSend 肄붾뱶
	@RequestMapping(value = "/mailSend", method = RequestMethod.POST)
	public String mailSend(HttpServletRequest request,@RequestParam("pqidx") int pqidx, @ModelAttribute("cri") Criteria cri, @RequestParam("uidx") int uidx, RedirectAttributes rttr) {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
		    MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		    String emailReceiver = service.getEmail(uidx);
		    messageHelper.setFrom("wnrak0116@gmail.com"); // 蹂대궡�뒗�궗�엺 �씠硫붿씪 �뿬湲곗꽑 google 硫붿씪�꽌踰� �궗�슜�븯�뒗 �븘�씠�뵒瑜� �옉�꽦�븯硫대맖
		    messageHelper.setTo(emailReceiver); // 諛쏅뒗�궗�엺 �씠硫붿씪
		    messageHelper.setSubject("�븞�뀞�븯�꽭�슂. 諛⑸갑�닠�옒 怨좉컼�꽱�꽣�엯�땲�떎."); // 硫붿씪�젣紐�
		    messageHelper.setText("怨좉컼�떂猿섏꽌 臾몄쓽�빐二쇱떊 1:1 臾몄쓽 �떟蹂��씠 �벑濡앸릺�뿀�쑝�땲, "
		    					+ "�솃�럹�씠吏��뿉 �젒�냽�븯�뀛�꽌 �솗�씤�빐二쇱떆湲� 諛붾엻�땲�떎."
		    					+ "媛먯궗�빀�땲�떎."); // 硫붿씪 �궡�슜
		    
		    mailSender.send(mimeMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		 rttr.addFlashAttribute("result", "success");
		 rttr.addAttribute("pqidx", pqidx); 
		 rttr.addAttribute("pageNum", cri.getPageNum()); 
		 rttr.addAttribute("amount", cri.getAmount()); 
		 rttr.addAttribute("start", cri.getStart());
		 
		
		return "redirect:/member/paq/reply-register";
	}
	
	
	
}
