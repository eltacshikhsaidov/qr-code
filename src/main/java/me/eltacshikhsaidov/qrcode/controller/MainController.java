package me.eltacshikhsaidov.qrcode.controller;

import com.google.zxing.WriterException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import me.eltacshikhsaidov.qrcode.service.QRCodeGenerator;

import java.io.IOException;
import java.util.Base64;

@Controller
public class MainController {

    @GetMapping("/")
    public String getQRCode(Model model,
                            @RequestParam(name = "url", 
                            required = true,
                            defaultValue = "https://example.com")
                            String url){
        // String medium="https://rahul26021999.medium.com/";

        byte[] image = new byte[0];
        try {

            // Generate and Return Qr Code in Byte Array
            image = QRCodeGenerator.getQRCodeImage(url,250,250);

        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
        // Convert Byte Array into Base64 Encode String
        String qrcode = Base64.getEncoder().encodeToString(image);

        model.addAttribute("url",url);
        model.addAttribute("qrcode",qrcode);

        return "qrcode";
    }
}
