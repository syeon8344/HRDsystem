package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.dto.DirectoryDto;
import web.service.DirectoryService;

import java.util.ArrayList;

@RestController
@RequestMapping("/directory")
public class DirectoryController {

    @Autowired
    DirectoryService directoryService;


    // 1. 부서등록
    @PostMapping("/add")
    public boolean dadd(DirectoryDto directoryDto){
        return directoryService.dadd(directoryDto);
    } // add end

    // 2. 전체출력
    @GetMapping("/dprint")
    public ArrayList<DirectoryDto> dPrint(){
        return directoryService.dPrint();
    }

    // 3. 부서수정
    @PutMapping("/dupdate")
    public boolean dUpdate(int dno , String dname , String dcontact){
        return directoryService.dUpdate(dno , dname , dcontact);

    }

    // 4. 부서삭제
    @DeleteMapping("/ddelete")
    public boolean dDelete(int dno){
        return directoryService.dDelete(dno);

    }


} // DirectoryController end
