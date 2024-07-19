
// 부서등록
function dAdd(){
    let name = document.querySelector("#name").value
    let contact = document.querySelector('#contact').value

    let info = {name : name , contact , contact};

    $.ajax( {
        async : false ,         
        method : 'post' ,      
        url : "/directory/add", 
        data : info ,           
        success : ( result )=>{ console.log( result ); 
            
            if( result ){alert('부서등록 성공');
                location.href="/directory/index";
            }else{  alert('부서등록 실패');  }
        } // success end
    } ); // ajax end
}

dPrint();
// 전체 출력
function dPrint(){
    $.ajax({
        async : false ,         
        method : 'get' ,      
        url : "/directory/dprint",            
        success : (result)=>{
            let printBox = document.querySelector('#printBox')
            html = '';
            for (dto of result){
                html += `   <tr>
                                <th scope="row">${dto.dno}</th>
                                <td>${dto.dname}</td>
                                <td>${dto.dcontact}</td>
                            </tr>
                           `
            }
            printBox.innerHTML = html;
        }
    });
}


// 부서수정
function dUpdate(){

    $.ajax({       
            async : false ,         
            method : 'put' ,      
            url : "/directory/dupdate",
            success : 
    })








}







// 부서삭제






