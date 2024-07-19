package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.PersonnelDao;
import web.model.dto.PersonnelDto;

import java.util.ArrayList;

@Service
public class PersonnelService {

    @Autowired
    PersonnelDao personnelDao;

    // 1. 인사 등록
    public boolean addPersonnel(PersonnelDto dto){
        if (dto.getPname().isEmpty() || dto.getPcontact().isEmpty() || dto.getPrank().isEmpty() || dto.getDno() == 0){
            return false;
        } else {
            return personnelDao.addPersonnel(dto);
        }
    }

    // 2. 인사 출력
    public ArrayList<PersonnelDto> readPersonnel(){
        return personnelDao.readPersonnel();
    }

    // 3. 인사 수정 (사원명, 연락처, 직급)
    public boolean editPersonnel(PersonnelDto dto){
        if (dto.getPno() == 0 || dto.getPname().isEmpty() || dto.getPcontact().isEmpty() || dto.getPrank().isEmpty()){
            return false;
        } else {
            return personnelDao.editPersonnel(dto);
        }
    }

    // 4. 인사 삭제
    public boolean deletePersonnel(PersonnelDto dto){
        return personnelDao.deletePersonnel(dto);
    }

}
