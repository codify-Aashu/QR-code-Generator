package com.qrcodegenerator.controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qrcodegenerator.service.QrCodeGeneratorService;



@RestController
@RequestMapping("/qr")
public class QrCodeController {

    @Autowired
    private QrCodeGeneratorService qrCodeGeneratorService;

    @GetMapping(value = "/qrcode/{content}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] generateQrCode(@PathVariable String content) throws IOException {
        int width = 200; 
        int height = 200; 
        return qrCodeGeneratorService.generateQrCodeImage(content, width, height);
    }
}
