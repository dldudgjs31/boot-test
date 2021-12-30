package penta.core.board;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.swing.filechooser.FileSystemView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BbsController {
	@Autowired
	BbsDAO bbsDAO;

	@RequestMapping(value = "/dbtest", method = RequestMethod.GET)
	public String userlistPage(Model model) {
		model.addAttribute("users",bbsDAO.list());
		return "dbtest";
	}
	
	@Value("${jboss.server.log.dir}")
	String jboss;
	
	@PostMapping("/upload")
	public String upload(
			@RequestParam MultipartFile[] uploadfile,
			Model model) throws IllegalStateException, IOException {
		
		File jbossfile = new File(jboss+"/upload");
		if(!jbossfile.exists()) {
			jbossfile.mkdir();
		}
		List<FileDto> list = new ArrayList<>();
		for (MultipartFile file : uploadfile) {
			if(!file.isEmpty()) {
				FileDto dto= new FileDto(UUID.randomUUID().toString(), file.getOriginalFilename(),file.getContentType());
				System.out.println("###############"+ dto.getUuid()+"3333333333333");
				list.add(dto);
				File newFileName = new File(dto.getUuid() + "_"+ dto.getFileName());
				file.transferTo(newFileName);
			}
		}
		log.debug("error part= ", list.get(0).getFileName() );
		model.addAttribute("files",list);
		log.debug("########################"+model.getAttribute("files").toString());
		return "result";
	}
	
	@PostMapping("/upload2")
	public String uploadSingle(@RequestParam("files") MultipartFile file) throws Exception{
	    String rootPath = FileSystemView.getFileSystemView().getHomeDirectory().toString();
	    String basePath = rootPath + "/" + "single";
	    String filePath = basePath + "/" + file.getOriginalFilename();
	    File dest = new File(filePath);
	    file.transferTo(dest); // 파일 업로드 작업 수행
	    return "result";	
	}
	
	@Value("${spring.servlet.multipart.location}")
	String filePath;
	
	@GetMapping("/download")
	public ResponseEntity<Resource> download(@ModelAttribute FileDto dto)throws Exception{
		log.debug("###################################################");
		Path path= Paths.get(filePath +"/" + dto.getUuid() + "_" + dto.getFileName());
		log.debug("###################################################"+path);
		String contentType = Files.probeContentType(path);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDisposition(ContentDisposition.builder("attachment").filename(dto.getFileName(),StandardCharsets.UTF_8).build());
		headers.add(HttpHeaders.CONTENT_TYPE, contentType);
		Resource resource = new InputStreamResource(Files.newInputStream(path));
		return new ResponseEntity<>(resource,headers,HttpStatus.OK);
	}
	
}
