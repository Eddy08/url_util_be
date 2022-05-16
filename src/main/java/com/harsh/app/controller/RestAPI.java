package com.harsh.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.WriterException;

import com.harsh.app.service.QRCodeGenerator;
@RestController
@RequestMapping("/")
public class RestAPI {
	@Autowired
	private QRCodeGenerator qrcode; 
	
	@PostMapping("/qrCode")
	public ResponseEntity<byte[]> getQrCode(@RequestBody String text) throws WriterException, IOException{
			return new ResponseEntity<>(qrcode.getQrCode(text),HttpStatus.OK);
		
	}
}
