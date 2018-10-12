package app.rest;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Serzh Nosov created on 12.10.2018
 */
@RestController
public class DownloadResource {

    @RequestMapping("/")
    public void hello(HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.write("<a href='download1'>download1</a><br />");
        writer.write("<a href='download2'>download2</a>");
    }

    @RequestMapping("/download1")
    public void download1(HttpServletResponse response) throws IOException {

        //иногда данный хедер должен быть обязательно перед тем как происходит запись в response
        //иначе бывает вывод на экран, вместо скачивания файла
        response.setHeader("Content-Disposition", "attachment; filename=download1.txt");

        String[] letters = new String[]{"a", "b", "c"};
        String text = String.join(", ", letters);
        response.getWriter().write(text);
    }

    @RequestMapping("/download2")
    ResponseEntity<Resource> download2() {

        String[] letters = new String[]{"d", "e", "f"};
        String text = String.join(", ", letters);
        ByteArrayResource resource = new ByteArrayResource(text.getBytes());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment;filename=download2.txt")
                .contentType(MediaType.TEXT_PLAIN).contentLength(resource.contentLength())
                .body(resource);
    }
}
