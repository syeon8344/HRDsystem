console.log("personnel js")
readPersonnel()
function readPersonnel(){
    $.ajax({
        async : false,
        method : "GET",
        url : "/personnel/read",
        success : resp => {
            let html = ""
            for(dto of resp){
                html += `<tr>
                        <th scope="row">${dto.pno}</th>
                        <td>${dto.pname}</td>
                        <td>${dto.pcontact}</td>
                        <td>${dto.prank}</td>
                        <td>${dto.dname}</td>
                        <td>
                            <button type="button" class="btn btn-warning my-2" onclick="editPersonnel(${dto.pno})">수정</button>
                            <button type="button" class="btn btn-warning my-2" onclick="deletePersonnel(${dto.pno})">삭제</button>
                        </tr>`
            };
            document.querySelector("#tbody").innerHTML = html;
        }
    })
}
/*
<tr>
    <th scope="row">1</th>
    <td>Mark</td>
    <td>Otto</td>
    <td>@mdo</td>
    <td>부서1</td>
</tr>*/