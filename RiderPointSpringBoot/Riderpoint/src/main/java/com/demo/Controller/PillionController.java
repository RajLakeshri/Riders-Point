package com.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Model.Pillion_Status;
import com.demo.Model.Rider_Status;
import com.demo.Model.RpDetails;
import com.demo.Service.PillionService;

@CrossOrigin("*")
@RestController
@RequestMapping("/pillion")
public class PillionController {
	@Autowired
	private PillionService pservice;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<RpDetails>> displayAll(){
		return ResponseEntity.ok(pservice.getAll());
		
	}
	
	@PostMapping("/addStatus")
	public ResponseEntity<String> addStatus(@RequestBody Pillion_Status pstatus){
		Pillion_Status p=pservice.addStatus(pstatus);
		if(p!=null)
		{
			return ResponseEntity.ok("Data Added");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	
	
	
	
	
	
	
	
	

}
