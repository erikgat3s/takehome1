/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.b.takehome1.takehome1;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ERIK
 */
@Controller
public class controller {
    @RequestMapping("/biodata")
    public String getData(@RequestParam(value="inputnama") String getNama,
                          @RequestParam(value="inputtanggal") String getTanggal,
                          @RequestParam(value="inputfoto") MultipartFile getImage,
                          Model model)
    throws IOException{
            byte[] img = getImage.getBytes();
            String base64Image = Base64.encodeBase64String(img);
            String imglink ="data:image/png;base64".concat(base64Image);
                          
            model.addAttribute("kirimannama", getNama);
            model.addAttribute("kirimantanggal", getTanggal);
            model.addAttribute("kirimanfoto", imglink);
            return "main";
    }
}
