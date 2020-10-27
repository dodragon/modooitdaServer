<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<script type = "text/javascript" src = "http://code.jquery.com/jquery-latest.min.js"></script> 
<script type = "text/javascript" src = "https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.5.3/jspdf.min.js"></script>
<script type = "text/javascript" src = "https://html2canvas.hertzen.com/dist/html2canvas.min.js"></script>
<script src="https://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript" src="../resources/js/jquery.qrcode.js"></script>
<script type="text/javascript" src="../resources/js/qrcode.js"></script>
<div id="pdf_wrap">


<p>QRQRQRQRQR</p>
<div id="gcDiv"></div>
</div>
<button id="create_pdf">
      pdf 생성
</button>


<script>
    jQuery("#gcDiv").qrcode({   
        render : "table",     
        width : 300,            
        height : 300,           
        text   : "https://www.baobab858.com/"     
    });
</script>

</body>
</html>
