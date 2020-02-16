<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@include file="/commons/common.jsp"%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title></title>

    <script>
        //检验用户输入的原始密码是否正确的函数
        function checkOldPwd() {
            //获取输入的原始密码
            var inputPwd = $("#pass").val();
            //比较输入的密码和session中的密码是否相同
            if (inputPwd !="") {
                if (inputPwd !=${admin.userpwd}) {
                    //显示错误提示信息
                    $("#msg").html("原始密码错误，请重新输入原始密码！").css("color", "red");
                    return false;
                } else {
                    //输入正确的时候，清空span里面的内容
                    $("#msg").html("");
                    return true;
                }

            }else{
                $("#msg").html("");
                return  true;
            }
        }
        //点击提交按钮的时候，触发提交事件，从而调用checkAll函数
        function checkAll() {
            var flag=checkOldPwd();
            return flag ;

        }
    </script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong><span class="icon-key"></span> 修改会员密码</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" onsubmit="return checkAll()" action="${pageContext.request.contextPath}/updateMe">
            <!-- 把用户的id存到隐藏域中-->
            <input type="hidden" name="userId" value="${admin.userid}">
            <div class="form-group">
                <div class="">
                    <label for="sitename">当前帐号：${admin.username}</label>
                </div>
                <div class="field">
                    <label style="line-height:33px;">

                    </label>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label for="sitename">原始密码：</label>
                </div>
                <div class="field">
                    <input type="password" class="input w50" id="pass" name="pass" size="50" placeholder="请输入原始密码"
                           data-validate="required:请输入原始密码" onblur="checkOldPwd()"/> <span id="msg"></span>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label for="sitename">新密码：</label>
                </div>
                <div class="field">
                    <input type="password" class="input w50" name="newpass" size="50" placeholder="请输入新密码"
                           data-validate="required:请输入新密码,length#>=5:新密码不能小于5位"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label for="sitename">确认新密码：</label>
                </div>
                <div class="field">
                    <input type="password" class="input w50" name="rnewpass" size="50" placeholder="请再次输入新密码"
                           data-validate="required:请再次输入新密码,repeat#newpass:两次输入的密码不一致"/>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <!-- 可以在这里给出修改成功或失败的提示 -->
                    <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
