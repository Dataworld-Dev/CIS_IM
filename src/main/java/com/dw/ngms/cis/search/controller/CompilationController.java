package com.dw.ngms.cis.search.controller;

import com.dw.ngms.cis.search.entity.Compilation;
import com.dw.ngms.cis.search.service.CompilationService;
import com.dw.ngms.cis.search.utilities.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by swaroop on 2019/04/19.
 */
@RestController
@RequestMapping("/cisorigin.search/api/v1")
@CrossOrigin(origins = "*")
public class CompilationController extends MessageController {

    @Autowired
    private CompilationService compilationService;


    @GetMapping("/searchByCompilationNumberProvinceCode")
    public ResponseEntity<?> searchByCompilationProvinceCode(HttpServletRequest request,
                                                             @RequestParam String compilationNumber,
                                                             @RequestParam String provinceCode
    ) {
        try {
            List<Compilation> compilationList = this.compilationService.searchByCompilationNumberProvinceCode(compilationNumber, provinceCode);
            return (org.springframework.util.CollectionUtils.isEmpty(compilationList)) ? ResponseEntity.status(HttpStatus.OK).body(compilationList)
                    : ResponseEntity.status(HttpStatus.OK).body(compilationList);
        } catch (Exception exception) {
            return generateFailureResponse(request, exception);
        }
    }//searchByCompilationNumberProvinceCode


    @RequestMapping(value = "/downloadCompilation", method = RequestMethod.POST)
    public ResponseEntity<InputStreamResource> downloadDocumentation(HttpServletRequest request,
                                                                     @RequestParam String[] myParams
    ) throws IOException {

        ArrayList<String> arr = new ArrayList<>();
        for (String compilationId : myParams) {
            Compilation comp = this.compilationService.findByCompilationId(compilationId);
            arr.add(comp.getFtpSiteUrl());
        }


        List<String> files = new ArrayList<String>();
        for (String str1 : arr) {
            System.out.println(str1);
            files.add(str1);
            zipFiles(files);
        }
        File file = new File(Constants.downloadDirectoryPath + "DownloadFiles.zip");

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename= MultipleFiles.zip")
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .contentLength(file.length()) //
                .body(resource);
    }


   /* public void zipFiles(List<String> files) {

        FileOutputStream fos = null;
        ZipOutputStream zipOut = null;
        FileInputStream fis = null;
        try {
            fos = new FileOutputStream(Constants.downloadDirectoryPath + "DownloadFiles.zip");
            zipOut = new ZipOutputStream(new BufferedOutputStream(fos));
            for (String filePath : files) {
                File input = new File(filePath);


                InputStream inputStream = new URL("http://dwapps.co.za/DRDLRRM/CSGTIF/104S2F04.TIF").openStream();
                Files.copy(inputStream, Paths.get("/Users/swaroop/Documents/test-upload/104S2F04.TIF"), StandardCopyOption.REPLACE_EXISTING);


               *//* URL url = new URL(filePath);
                URLConnection connection = url.openConnection();
                InputStream is = connection.getInputStream();
*//*

                fis = new FileInputStream(input);
                ZipEntry ze = new ZipEntry(input.getName());
                zipOut.putNextEntry(ze);
                byte[] tmp = new byte[4 * 1024];
                int size = 0;
                while ((size = fis.read(tmp)) != -1) {
                    zipOut.write(tmp, 0, size);
                }
                zipOut.flush();
                fis.close();
            }
            zipOut.close();
            System.out.println("Done... Zipped the files...");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) fos.close();
            } catch (Exception ex) {

            }
        }
    }*/


    public void zipFiles(List<String> files) throws IOException {

        FileOutputStream fos = null;
        ZipOutputStream zipOut = null;
        FileInputStream fis = null;

        fos = new FileOutputStream(Constants.downloadDirectoryPath + "DownloadFiles.zip");
        zipOut = new ZipOutputStream(new BufferedOutputStream(fos));
        for (String filePath : files) {
            BufferedInputStream inputStream = new BufferedInputStream(new URL(filePath).openStream());
            int index = filePath.lastIndexOf("/");
            String fileName = filePath.substring(index + 1);
            FileOutputStream fileOS = new FileOutputStream("/Users/swaroop/Documents/test-upload/" + fileName);
            byte data[] = new byte[1024];
            int byteContent;
            while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
                fileOS.write(data, 0, byteContent);
            }

            String filePathTest = "/Users/swaroop/Documents/test-upload/" + fileName;
            File input = new File(filePathTest);

            fis = new FileInputStream(input);
            ZipEntry ze = new ZipEntry(input.getName());
            zipOut.putNextEntry(ze);
            byte[] tmp = new byte[4 * 1024];
            int size = 0;
            while ((size = fis.read(tmp)) != -1) {
                zipOut.write(tmp, 0, size);
            }
            zipOut.flush();
            fis.close();
        }

        zipOut.close();
        /*try (BufferedInputStream inputStream = new BufferedInputStream(new URL("http://dwapps.co.za/DRDLRRM/CSGTIF/104S2F04.TIF").openStream());
             FileOutputStream fileOS = new FileOutputStream("/Users/swaroop/Documents/test-upload/file_name.txt")) {
            byte data[] = new byte[1024];
            int byteContent;
            while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
                fileOS.write(data, 0, byteContent);
            }
        } catch (IOException e) {
            // handles IO exceptions
        }*/

    }

}
