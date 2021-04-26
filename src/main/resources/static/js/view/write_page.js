/**
 * 
 */
$(document).ready(function(){
	$('#writeBtn').click(function(){
		if($('#inputTitle').val() == ""){
			alert("제목을 입력해주세요.");
			return false;
		}else if($('#inputID').val() == ""){
			alert('작성자를 입력해주세요');
			return false;
		}
	})
});
