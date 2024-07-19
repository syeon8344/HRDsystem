package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.dao.DirectoryDao;
import web.model.dto.DirectoryDto;

import java.util.ArrayList;

@Service
public class DirectoryService {
    @Autowired
    DirectoryDao directoryDao;


    // 1. 부서등록
    @GetMapping("/add")
    public boolean dadd(DirectoryDto directoryDto){
        return directoryDao.dadd(directoryDto);
    }   // add end


    // 2. 전체출력
    public ArrayList<DirectoryDto> dPrint(){
        return directoryDao.dPrint();
    }


    // 3. 부서수정
    public boolean dUpdate(int dno , String dname , String dcontact){
        DirectoryDto dto = new DirectoryDto();
        dto.setDno(dno);
        dto.setDname(dname);
        dto.setDcontact(dcontact);
        return directoryDao.dUpdate(dto);
    }

    // 4. 부서삭제
    public boolean dDelete(int dno){

        return directoryDao.dDelete(dno);
    }


}// DirectoryService end
