package com.harsh.app.service;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@Service
public class QRCodeGenerator {
	public byte[] getQrCode(String text) throws WriterException, IOException {
		
		QRCodeWriter qrCodeWriter=new QRCodeWriter();
		BitMatrix bitMatrix=qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 1024, 1024);
		ByteArrayOutputStream output=new ByteArrayOutputStream();
		MatrixToImageConfig config=new MatrixToImageConfig(0,1);
		MatrixToImageWriter.writeToStream(bitMatrix, "PNG", output, config);
		
		return output.toByteArray();
	}
}
