package web.model.dao;

import org.springframework.stereotype.Component;
import web.model.dto.PersonnelDto;

import java.util.ArrayList;

@Component
public class PersonnelDao extends Dao{

    // 1. 인사 등록 (사원명, 연락처, 직급, 부서번호)
    public boolean addPersonnel(PersonnelDto dto){
        try{
            String sql = "insert into personnel(pname, pcontact, prank, dno) values (?,?,?,?);";
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getPname());
            ps.setString(2, dto.getPcontact());
            ps.setString(3, dto.getPrank());
            ps.setInt(4, dto.getDno());
            int count = ps.executeUpdate();
            return count == 1;
        }catch (Exception e){
            System.out.println("addPersonnel() : " + e);
        }
        return false;
    }

    // 2. 인사 출력
    public ArrayList<PersonnelDto> readPersonnel(){
        try{
            ArrayList<PersonnelDto> list = new ArrayList<>();
            String sql = "select * from personnel inner join directory on personnel.dno = directory.dno;";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                PersonnelDto dto = PersonnelDto.builder()
                        .pno(rs.getInt(1))
                        .pname(rs.getString(2))
                        .pcontact(rs.getString(3))
                        .prank(rs.getString(4))
                        .dname(rs.getString(7))
                        .build();
                list.add(dto);
            }
            return list;
        }catch (Exception e){
            System.out.println("readPersonnel() : " + e);
        }
        return null;
    }

    // 3. 인사 수정 (사원명, 연락처, 직급)
    public boolean editPersonnel(PersonnelDto dto){
        try{
            String sql = "update personnel set pname = ?, pcontact = ?, prank = ? where pno = ?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getPname());
            ps.setString(2, dto.getPcontact());
            ps.setString(3, dto.getPrank());
            ps.setInt(4, dto.getPno());
            int count = ps.executeUpdate();
            return count == 1;
        }catch (Exception e){
            System.out.println("editPersonnel() : " + e);
        }
        return false;
    }

    // 4. 인사 삭제
    public boolean deletePersonnel(PersonnelDto dto){
        try{
            String sql = "delete from personnel where pno = ?;";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, dto.getPno());
            int count = ps.executeUpdate();
            return count == 1;
        }catch (Exception e){
            System.out.println("deletePersonnel() : " + e);
        }
        return false;
    }
}
