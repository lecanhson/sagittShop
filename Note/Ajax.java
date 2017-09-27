Ajax :


xhttp.send(); Gửi request tới server sử dụng GET
xhttp.send(string): Gửi request tới server sử dụng POST

XMLHttpRequest : của Ajax 


<script>

	function loadDoc(){
		var xhttp = new XMLHttpRequest();
		xhttp.onreadyStatechange = function(){
			if (xhttp.readyState == 4 && xhttp.status == 200) {
				document.getElementById("demo").innerHTML = xhttp.responseText;
			}
		};
		xhttp.open("GET", "demo_get.asp",true);
		xhttp.send();
	}

</script>


UPDATE NhanVien Set Chieucao=(Select Chieucao FROM NhanVien WHERE Name=ChiAnh) FROM NhanVien WHERE Name=Dung   