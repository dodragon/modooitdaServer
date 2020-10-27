function page_user() {
	var form = document.createElement('form');
	var param = new Array();
	var input = new Array();

	form.action = 'http://192.168.0.5/baobab/jsp/admin/user.api';
	form.method = 'post';

	param.push([ 'div_code', '%%' ]);
	param.push([ 'push', '%%' ]);
	param.push([ 'date', '' ]);
	param.push([ 'user_email', '' ]);

	for (var i = 0; i < param.length; i++) {
		input[i] = document.createElement('input');
		input[i].setAttribute('type', 'hidden');
		input[i].setAttribute('name', param[i][0]);
		input[i].setAttribute('value', param[i][1]);
		form.appendChild(input[i]);
	}
	document.body.appendChild(form);
	form.submit();
}

function page_cp() {
	var form = document.createElement('form');
	var param = new Array();
	var input = new Array();

	form.action = 'http://192.168.0.5/baobab/jsp/admin/cp.api';
	form.method = 'post';

	param.push([ 'searchWord', '' ]);
	param.push([ 'kind', '%%' ]);

	for (var i = 0; i < param.length; i++) {
		input[i] = document.createElement('input');
		input[i].setAttribute('type', 'hidden');
		input[i].setAttribute('name', param[i][0]);
		input[i].setAttribute('value', param[i][1]);
		form.appendChild(input[i]);
	}
	document.body.appendChild(form);
	form.submit();
}

function page_notice() {
	var form = document.createElement('form');
	var param = new Array();
	var input = new Array();

	form.action = 'http://192.168.0.5/baobab/jsp/admin/noticeList.api';
	form.method = 'post';

	param.push([ 'read_div', '' ]);
	param.push([ 'searchWord', '' ]);

	for (var i = 0; i < param.length; i++) {
		input[i] = document.createElement('input');
		input[i].setAttribute('type', 'hidden');
		input[i].setAttribute('name', param[i][0]);
		input[i].setAttribute('value', param[i][1]);
		form.appendChild(input[i]);
	}
	document.body.appendChild(form);
	form.submit();
}

function page_push() {
	var form = document.createElement('form');
	var param = new Array();
	var input = new Array();

	form.action = 'http://192.168.0.5/baobab/jsp/admin/pushList.api';
	form.method = 'post';

	param.push([ 'push_div', '' ]);
	param.push([ 'searchWord', '' ]);

	for (var i = 0; i < param.length; i++) {
		input[i] = document.createElement('input');
		input[i].setAttribute('type', 'hidden');
		input[i].setAttribute('name', param[i][0]);
		input[i].setAttribute('value', param[i][1]);
		form.appendChild(input[i]);
	}
	document.body.appendChild(form);
	form.submit();
}

function page_cpPush() {
	var form = document.createElement('form');
	var param = new Array();
	var input = new Array();

	form.action = 'http://192.168.0.5/baobab/jsp/admin/cpPushList.api';
	form.method = 'post';

	param.push([ 'searchWord', '' ]);

	for (var i = 0; i < param.length; i++) {
		input[i] = document.createElement('input');
		input[i].setAttribute('type', 'hidden');
		input[i].setAttribute('name', param[i][0]);
		input[i].setAttribute('value', param[i][1]);
		form.appendChild(input[i]);
	}
	document.body.appendChild(form);
	form.submit();
}

function page_review() {
	var form = document.createElement('form');
	var param = new Array();
	var input = new Array();

	form.action = 'http://192.168.0.5/baobab/jsp/admin/reviewList.api';
	form.method = 'post';

	param.push([ 'cp_div', '' ]);
	param.push([ 'searchWord', '' ]);

	for (var i = 0; i < param.length; i++) {
		input[i] = document.createElement('input');
		input[i].setAttribute('type', 'hidden');
		input[i].setAttribute('name', param[i][0]);
		input[i].setAttribute('value', param[i][1]);
		form.appendChild(input[i]);
	}
	document.body.appendChild(form);
	form.submit();
}

function page_search() {
	var form = document.createElement('form');
	var param = new Array();
	var input = new Array();

	form.action = 'http://192.168.0.5/baobab/jsp/admin/searchWord.api';
	form.method = 'post';

	document.body.appendChild(form);
	form.submit();
}

function version() {
	window.open('http://192.168.0.5/baobab/jsp/admin/version.api', '버전',
					'width=500px, height=600px, toolbars=no, scrollbars=no, top=150px, left=600px');
}

function addrConversion(){
	window.open('http://192.168.0.5/baobab/jsp/admin/addrConversion.api', '경위도변환',
			'width=500px, height=600px, toolbars=no, scrollbars=no, top=150px, left=600px');
}

function checkServer(){
	window.open('http://192.168.0.5/baobab/jsp/admin/checkServer.api', '점검',
			'width=500px, height=600px, toolbars=no, scrollbars=no, top=150px, left=600px');
}