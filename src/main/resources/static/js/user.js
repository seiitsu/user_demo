//将表单提交的参数，转换成为JSON数组,然并卵
/*function serializeObject() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name]) {
			if (!o[this.name].push) {
				o[this.name] = [ o[this.name] ];
			}
			o[this.name].push(this.value || '');

		} else {
			o[this.name] = this.value || '';
		}

	});
	return o;
}*/

//检查登录用户
function checkLogin() {
	var username = $("#username").val();
	var password = $("#password").val();
	var param = {
		"username" : username,
		"password" : password
	}

	$.ajax({
		url : "/checkLogin",
		type : "POST",
		contentType : "application/json",
		dataType : "json",
		data : JSON.stringify(param),
		async : true,
		success : function(data) {
			if (data) {
				alert("恭喜你 " +username+" 登录成功");
				location.href = "/user/showAllUser";
			} else {
				alert("用户名或密码错误!");
			}

		}

	});

}

//检查注册用户
function checkRegist() {
	var username = $("#username").val();
	var password = $("#password").val();
	var email = $("#email").val();
	var param = {
		"username" : username,
		"password" : password,
		"email" : email
	}

	$.ajax({
		url : "/checkRegist",
		type : "POST",
		contentType : "application/json",
		dataType : "json",
		data : JSON.stringify(param),
		async : true,
		success : function(data) {
			if (data) {
				alert("恭喜你 " + username + " 注册成功");
				top.location.href = "/login";
			} else {
				alert("用户名存在:注册失败!");
			}
		}
	});
}

//检查添加用户
function checkAddUser() {
	var username = $("#username").val();
	var password = $("#password").val();
	var email = $("#email").val();
	var param = {
		"username" : username,
		"password" : password,
		"email" : email
	}

	$.ajax({
		url : "/checkAddUser",
		type : "POST",
		contentType : "application/json",
		dataType : "json",
		data : JSON.stringify(param),
		async : true,
		success : function(data) {
			if (data) {
				alert("添加 " + username + " 用户成功!");
			} else {
				alert("用户名存在:添加失败!");
			}
		}
	});
}

//查找用户
function findUser() {
	var username = $("#username").val();
	location.href = "/user/findUser/" + username;
}

//删除用户
function deleteUser(id) {
	var r = window.confirm("您确定要删除此数据吗?");
	if (r) {
		$.ajax({
			url : "/user/deleteUser/" + id,
			type : "DELETE",
			contentType : "application/json",
			dataType : "json",
			success : function(data) {
				alert("删除成功");
				location.href="/user/showAllUser";
			}
		});

	}
}

//跳转到修改页面
function toUpdateUserForm(id) {
	location.href = "/user/toUpdateUserForm/" + id;
}

//修改用户
function updateUser() {
	var id = $("#id").val();
	var username = $("#username").val();
	var password = $("#password").val();
	var email = $("#email").val();
	var param = {
		"id" : id,
		"username" : username,
		"password" : password,
		"email" : email
	}

	$.ajax({
		url : "/user/updateUser",
		type : "POST",
		contentType : "application/json",
		dataType : "json",
		data : JSON.stringify(param),
		success : function(data) {
			alert("修改成功!");
		}
	});

}

//跳转到多少页
function toPage(firstPage,lastPage){
	var pageNum = $("#pageNum").val();
	(pageNum<=0)?firstPage:pageNum;
	(pageNum>lastPage)?lastPage:pageNum;
	location.href="/user/showAllUser?pageNum="+pageNum;
}


