package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.dto.PersonnelDto;
import web.service.PersonnelService;

import java.util.ArrayList;

@RestController
@RequestMapping("/personnel")
public class PersonnelController {

    @Autowired
    PersonnelService personnelService;
    // 1. 인사 등록
    @PostMapping("/add")
    public boolean addPersonnel(PersonnelDto dto){
        return personnelService.addPersonnel(dto);
    }

    // 2. 인사 출력
    @GetMapping("/read")
    public ArrayList<PersonnelDto> readPersonnel(){
        return personnelService.readPersonnel();
    }

    // 3. 인사 수정 (사원명, 연락처, 직급)
    @PutMapping("/update")
    public boolean editPersonnel(PersonnelDto dto){
        return personnelService.editPersonnel(dto);
    }

    // 4. 인사 삭제
    @DeleteMapping("/delete")
    public boolean deletePersonnel(@RequestBody PersonnelDto dto){
        return personnelService.deletePersonnel(dto);
    }

}
