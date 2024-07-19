package web.model.dao;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.dto.DirectoryDto;

import java.sql.PreparedStatement;
import java.util.ArrayList;

@Component
public class DirectoryDao extends Dao {



    // 1. 부서등록
    @GetMapping("/add")
    public boolean dadd(DirectoryDto directoryDto){
        try {
            String sql = "insert into directory(dname,dcontact) values (? , ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,directoryDto.getDname() );
            ps.setString(2,directoryDto.getDcontact());

            int count = ps.executeUpdate();
            if (count == 1 )return true;
        }catch (Exception e){System.out.println(e);
        }
     return false;
    }   // add end


    // 2. 전체출력
    public ArrayList<DirectoryDto> dPrint(){
        ArrayList<DirectoryDto> list = new ArrayList<>();
        try {
            String sql = "select * from directory";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                DirectoryDto dto = new DirectoryDto();
                    dto.setDno(rs.getInt(1));
                    dto.setDname(rs.getString(2));
                    dto.setDname(rs.getString(3));
                    list.add(dto);
            }
        }catch (Exception e) { System.out.println(e);
        }
        return list;
    }


    // 3. 부서수정
    public boolean dUpdate(DirectoryDto directoryDto){
        try {
            String sql = "update directory set dname = ? , dcontact = ? where dno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString( 1 ,directoryDto.getDname());
            ps.setString(2 , directoryDto.getDcontact());
            ps.setInt(3 , directoryDto.getDno());
            int count = ps.executeUpdate();
            if ( count == 1 )return true;
        }catch (Exception e){System.out.println(e);
        }
        return false;
    }

    // 4. 부서삭제
    public boolean dDelete(int dno){
        try {
            String sql = "delete from directory where dno = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, dno);
            return ps.executeUpdate() == 1;

        }catch (Exception e){ System.out.println(e);
        }
        return false;
    }


} // DirectoryDao end
