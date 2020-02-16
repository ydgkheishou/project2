<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/commons/common.jsp"%>



<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <%--在jsp页面上，用如下的EL可以动态获取web应用的根路径:${pageContext.request.contextPath}--%>
    <title>用户界面</title>
    <script type="text/javascript">
        $(function(){
            //执行删除操作
            $(".btn_delete").click(function(){
                var r = window.confirm("确定要删除此用户吗？");
                    if(r) {
                        // 1、 获取当前点击按钮所对应的用户ID
                        var $tr = $(this).parent().parent();

                        // 获取当前点击资费信息的id
                        var id = +$tr.find("td:first").html();

                        // 2、 发送请求，执行修改操作
                        var url = "admin/deleteRoleById";
                        var data = {
                            userId: id,
                            time : new Date()
                        };
                        $.post(url,data,function (result) {
                            if (result) {
                                $(".operate_success span").html("删除成功！");
                                $(".operate_success").show();
                                $tr.remove();
                            }

                        });
                    }
            });

                //执行初始化操作
                $(".btn_reStart").click(function(){
                    var r = window.confirm("确定初始化此用户的密码吗？");
                    if(r) {
                        // 1、 获取当前点击按钮所对应的用户ID
                        var $tr = $(this).parent().parent();

                        // 获取当前点击资费信息的id
                        var id = +$tr.find("td:first").html();

                        // 2、 发送请求，执行初始化操作
                        var url = "admin/rePassWorld";
                        var data = {
                            userId:id,
                            time : new Date()
                        };
                        $.post(url,data,function (result) {
                            if (result) {
                                $(".operate_success span").html("初始化成功！");
                                $(".operate_success").show();

                            }
                        });
                        location.href="admin/toAccountList?role=${requestScope.roleId}&name=${requestScope.name}&pageNum=${requestScope.adminPageInfo.pageNum}";

                    }
                });


            });
    </script>
        <style type="text/css">
            .sellink{
                color:orangered;
            }
            section{
                font-size: 14px;
            }
        </style>
</head>
<body>
<!--启用操作的操作提示-->

    <div id="operate_result_info" class="operate_success" align="center" hidden>
        <img src="images/close.png" onclick="this.parentNode.style.display='none';" />
        <span>删除成功！</span>
    </div>



<div class="container" >
    <div class="panel admin-panel margin-top">
        <div class="panel-head" id="add">
            <strong><h3><span class="icon ion-person-add margin-small"></span>用户管理</h3></strong>
        </div>
        <div class="body-content">
            <h4 align="center">
                <form action="admin/toAccountList" method="post">
                    名称：<input type="text" name="name" value="${requestScope.name}">
                    <select name="role" id="roleId">
                        <option value="1" <c:if test="${roleId=='1'}">selected</c:if>>学生</option>
                        <option value="2" <c:if test="${roleId=='2'}">selected</c:if>>教师</option>
                    </select>
                    <input type="submit" value="查询">
                </form>
            </h4>
           <%-- <table align="center" border="1" cellpadding="20" cellspacing="0" width="100%" height="90%">--%>
            <table class="table table-hover text-center" >
                <tr>
                    <th>用户ID</th>
                    <th>用户名称</th>
                    <th>用户密码</th>
                    <th>操作</th>
                </tr>
                <c:forEach var="admin" items="${requestScope.adminPageInfo.list}">
                    <tr align="center">

                        <td>${admin.userid}</td>
                        <td>${admin.username}</td>
                        <td>${admin.userpwd}</td>
                        <td>
                            <%--a href="javascript:void(0)" onclick="queryAdmin(${requestScope.name},${requestScope.adminPageInfo.pageNum},${requestScope.roleId},${admin.userid})" style="color: #ff9900">修改密码</a>--%>
                            <input type="button" value="修改密码" class="btn_modify" style="color: #ff9900" onclick="location.href='admin/toUpdate?userId=${admin.userid}&pageNum=${requestScope.adminPageInfo.pageNum}';"/> |
                            <%--<a href="javascript:void(0)" onclick="initPassword(${admin.userid},${pb.pageNum},${roleid})" style="color: #0F91CB">初始化密码</a>--%>
                            <input type="button" value="初始化密码" class="btn_reStart" style="color: #0F91CB"> |
<%--
                             javascript:void(0)：用在href属性上，表示取消超链接的任何跳转，只响应JS事件
--%>
                            <%--删除的另一种方式，已经实现
                            <a href="javascript:void(0)" onclick="deleteAdmin(${requestScope.adminPageInfo.pageNum},${requestScope.roleId},${admin.userid})"
                               style="color: #ee3333">删除用户</a>--%>
                            <input type="button" value="删除" style="color: #ee3333" class="btn_delete" />
                        </td>
                    </tr>
                </c:forEach>

                <tr>
                    <td colspan="80">
                        <div class="pagelist">
                            <!-- 当前页是第1页时，首页，上一页直接显示，
                     <a class="nocls">首页</a>   <a class="nocls">上一页</a>
                       不是第1页时，点击后跳转页面,onclick指定函数 -->
                            <c:choose>
                                <c:when test="${requestScope.adminPageInfo.pageNum eq 1}">
                                    <a class="nocls">首页</a> <a class="nocls">上一页</a>
                                </c:when>
                                <c:otherwise>

                                    <a href="admin/toAccountList?role=${requestScope.roleId}&name=${requestScope.name}&pageNum=1">首页</a> <a
                                        href="admin/toAccountList?role=${requestScope.roleId}&name=${requestScope.name}&pageNum=${requestScope.adminPageInfo.prePage}">上一页</a>
                                </c:otherwise>
                            </c:choose>
                            <!-- 当前页显示在span里面,其它页点击后跳转页面 -->
                            <c:forEach var="num" items="${requestScope.adminPageInfo.navigatepageNums}">
                                <c:choose>
                               <c:when test="${requestScope.adminPageInfo.pageNum==num}">
                                   <span class="current">${num}</span>
                               </c:when>
                                <c:otherwise>
                                    <a href="admin/toAccountList?role=${requestScope.roleId}&name=${requestScope.name}&pageNum=${num}" >${num}</a>
                                </c:otherwise>
                            </c:choose>

                            </c:forEach>
                            <c:choose>
                                <c:when test="${!requestScope.adminPageInfo.hasNextPage}">
                                    <a class="nocls">下一页</a> <a class="nocls">尾页</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="admin/toAccountList?role=${requestScope.roleId}&name=${requestScope.name}&pageNum=${requestScope.adminPageInfo.nextPage}">下一页</a>
                                    <a href="admin/toAccountList?role=${requestScope.roleId}&name=${requestScope.name}&pageNum=${requestScope.adminPageInfo.pages}">尾页</a>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </td>
                </tr>

            </table>
        </div>
    </div>
</div>
<script>
    //点击删除后调用的函数
    function deleteAdmin(pageNum,roleId,userid){
        var flag=confirm("确定要删除密码吗？")
        if(flag){
            //请求CustomerServlet页面，使用location.href发送get请求
            location.href="admin/deleteRoleById?pageNum="+pageNum+"&role="+roleId+"&userId="+userid;
        }
    }
    //点击初始化密码后调用的函数
    function initPassword(userid,pageNum,roleid){
        var flag=confirm("确定要初始化密码吗？")
        if(flag){
            //请求CustomerServlet页面，使用location.href发送get请求
            location.href="admin.action?method=initPassword&userid="+userid+"&pageNum="+pageNum+"&role="+roleid;
        }
    }
    //点击修改后调用的函数
    function  queryAdmin(id,pageNum,roleid) {
        //请求CustomerServlet,用location.href发送get请求
        location.href = "admin.action?method=toUpdate&id="+ id+"&pageNum="+pageNum+"&role="+roleid;
    }
    //选择下拉列表中的页号时，调用changePageNum()函数
    function changePageNum() {
        var pageNum = document.getElementById('selNum').value;
        location.href = "admin.action?method=queryByPage&name=${name}&role=${roleid}&pageNum=" + pageNum;
    }

</script>
</body>
</html>
