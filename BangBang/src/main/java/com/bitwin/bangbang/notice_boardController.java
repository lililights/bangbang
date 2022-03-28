package com.bitwin.bangbang;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

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

import com.bitwin.domain.notice_boardVO;
import com.bitwin.domain.Criteria;
import com.bitwin.domain.PageDTO;
import com.bitwin.service.notice_boardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/admin/notice_board/*")
public class notice_boardController {
	
	
	private notice_boardService service;
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		
		log.info("list: " + cri);
		
		
		model.addAttribute("list", service.getList(cri));
//		model.addAttribute("pageMaker", new PageDTO(cri, 200));
		
		int total = service.getTotal(cri);
		
		log.info("total: " + total);
		
		model.addAttribute("pageMaker", new PageDTO(cri, total));

		
	}
	
	

	
	
	
	
	
	@PostMapping("/register")
	public String register(notice_boardVO board, RedirectAttributes rttr) {
		
		log.info("register: " + board);
		
		service.register(board);
		
		rttr.addFlashAttribute("result", board.getNidx());
		
		return "redirect:/admin/notice_board/list";
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("nidx") int nidx, @ModelAttribute("cri") Criteria cri, Model model) {
		
		log.info("/get or modify");
		model.addAttribute("board", service.get(nidx));
		
	}
	
	@PostMapping("/modify")
	public String modify(notice_boardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		
		log.info("modify: " + board);
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "modify");
			
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("start", cri.getStart());
		
		return "redirect:/admin/notice_board/list";
	}
	
	
	@PostMapping("/remove")
	public String remove(@RequestParam("nidx") int nidx, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		
		log.info("remove..." + nidx);
		
		if(service.remove(nidx)) {
			
			rttr.addFlashAttribute("result", "delete");
			
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("start", cri.getStart());
		
		return "redirect:/admin/notice_board/list";
	}
	
	@GetMapping("/register")
	public void register() {
		
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
    	String fileUrl = "/bangbang/admin/notice_board/ckImgSubmit?uid=" + uid + "&fileName=" + fileName; // �옉�꽦�솕硫�
    	System.out.println(fileUrl);
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
	
	
	
	
	
	
	
}
