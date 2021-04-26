/**
 * 
 */
$(document).ready(function(){
	$('#updateBtn').click(function(){
		if($('#inputTitle').val() == ""){
			alert("제목을 입력해주세요.");
			return false;
		}else if($('#inputId').val() == ""){
			alert('작성자를 입력해주세요');
			return false;
		}
	})
});