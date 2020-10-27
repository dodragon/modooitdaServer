<%@page import="com.baobab.m.vo.CPInfoVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon"
   href="https://www.baobab858.com/resources/webImages/favicon.ico">
<title>바오밥 QR 생성</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
function deleteResult(pTeg) {
   pTeg.remove();
}

function search(){
      var value = $("#searchBar").val();
      $.ajax({
         url: "<c:url value='/jsp/searchQRCode.api'/>",
         method: 'post',
         type: 'json',
         data: JSON.stringify(value),
         contentType: 'application/json; charset=utf-8',
         success: function(data){
            console.log(data);
            makeList(data);
         },
         error: function(jqXHR, textStatus, errorThrown){
            alert('에러!!');
            console.log(textStatus + " : " + errorThrown);
         }
      });

}

function makeList(str){
	document.getElementById('searchResult').innerHTML = '';
      var arr = str.replace('[', '').replace(']', '').split('}, ');
      
      console.log('1:'+arr);
      
      for(var i=0;i<arr.length;i++){
         var arr2 = arr[i].replace('{', '').replace('}', '').split(', ');
         console.log('2 :'+arr2);
         
         var cpSeq = arr2[0].split('=')[1];
         var cpName = arr2[1].split('=')[1];
         var cpAddr = arr2[2].split('=')[1];
         
         var html = '<div class="results">' + '<div class="info">' + '<h3>' + cpName + '|' + cpSeq + '</h3>' + '<p>' + cpAddr + '</p>' + 
         '</div>' + '<div class="eaCheck">' + '<input type="number" placeholder="수량" value="0">' + 
         '<button class="submitBtn">확인</button>' + '</div>' + '</div>';
                
         document.getElementById('searchResult').innerHTML += html;
      }
      
      $('.submitBtn').on('click', function(){
   	   var ea = $(this).siblings('input').val();
   	   ea *= 1;
   	   
   	   if(isNaN(ea) == true || ea == '' || ea == '0' || ea > '9'){
   	       alert('수량을 다시 확인하세요.');
   	       $(this).siblings('input').val('0');
   	    }
   	    else{
   	       var cpNameSeq = $(this).parent().siblings('.info').children('h3').text();
   	       var result = cpNameSeq + '|' + ea + '개'
   	       document.getElementById('checkResult').innerHTML += '<p class="resultStr" onclick="deleteResult(this)">' + result + '</p>';
   	   }
   	});
}



	function goNext(){
		var pTegs = document.getElementsByClassName('resultStr');
		var text = '';
		
		for(var i = 0; i < pTegs.length; i++){
			if(i < pTegs.length - 1){
				text += pTegs[i].innerText + ',';
			}else{
				text += pTegs[i].innerText;
			}
		}
		
		console.log('text '+text);
		document.getElementById('str').value = text;
		
		document.getElementById('nextForm').submit();
		
	}
</script>
<style type="text/css">
body {
   text-align: center;
}

header {
   width: 100%;
   height: 30px;
   margin-bottom: 30px;
}

#fromDiv {
   width: 30%;
   text-align: center;
   display: inline-block;
}

#searchBar {
   width: 91.4%;
   border: 3px solid #ff6a29;
   padding: 2px;
   text-align: center;
   outline: none;
   float: left;
}

button {
   height: 25px;
   text-align: center;
   outline: none;
   border: 0px;
   background-color: #ff6a29;
   color: white;
   float: left;
}

#searchResult {
   width: 100%;
   height: 600px;
   overflow-x: hidden;
   overflow-y: scroll;
   border: 3px solid #ff6a29;
   border-right: 0px;
}

.results {
   width: 100%;
   height: 100px;
   display: block;
   text-align: center;
   border-bottom: 1px solid grey;
}

.info {
   width: 60%;
   height: 100%;
   float: left;
}

.eaCheck {
   width: 39%;
   height: 100%;
   float: left;
   display: inline-block;
   text-align: center;
}

.eaCheck>input {
   margin-top: 5%;
   width: 60%;
   border: 3px solid #ff6a29;
   padding: 2px;
   text-align: center;
   outline: none;
   float: left;
}

.eaCheck>button {
   float: left;
   margin-top: 5%;
}

#checkResult {
   width: 100%;
   height: 200px;
   margin-top: 30px;
   overflow-x: hidden;
   overflow-y: scroll;
   border: 3px solid #ff6a29;
   border-right: 0px;
}

#checkResult p {
   float: left;
   display: block;
   background-color: #ff6a29;
   color: white;
   padding: 5px;
   font-size: 18px;
   margin-right: 10px;
   margin-left: 10px;
}

#nextDiv {
   margin-top: 30px;
   width: 100%;
}

#nextDiv>button {
   width: 15%;
   font-size: 18px;
   margin-left: 42.5%;
   display: inline-block;
   float: top;
}

.result {
   cursor: pointer;
}
</style>
</head>
<body>
   <div>
      <header>
      <div id="fromDiv">
         <input type="text" name="searchWord" id="searchBar">
         <button id="searchBtn" onclick='search()'>검색</button>
      </div>
      </header>

      <section id="searchResult">
      
      </section>
      <article id="checkResult"></article>
      <div id="nextDiv">
      <form id="nextForm" action="https://www.baobab858.com/jsp/goNext.api" method="post">
      <input id="str" type="hidden" name="str">
         <button id="next" onclick="goNext()">다음</button>
      </form>
      </div>
   </div>
</body>
</html>