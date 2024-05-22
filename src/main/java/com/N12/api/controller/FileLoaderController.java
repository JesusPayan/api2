package com.N12.api.controller;
import com.N12.api.service.FileLoaderService;
import com.N12.api.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/api")
public class FileLoaderController {
    @Autowired
    FileLoaderService fls;

    Utils utils = new Utils();

    @PostMapping("/uploadfile")
    public void fileupload(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("Entra la controlado para cargar el archivo");

        fls.findXML(utils.getOrders(file));

    }
}
