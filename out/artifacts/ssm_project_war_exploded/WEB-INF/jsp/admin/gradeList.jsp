
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/commons/common.jsp"%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <%--  定义js函数，实现根据不同的页号进行分页 --%>
    <script>
        function changePageNum(pageNum){
            //请求后台Servlet
            location.href="admin.action?method=queryGradeByPage&name=${name}&gorder=${gorder}&pageNum="+pageNum;
        }
    </script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head">
        <strong class="icon-reorder">学生成绩管理页面</strong>
    </div>

  <form action="admin/queryGradeByPage" method="post">
        名称：<input type="text" name="name" value="${name}">&nbsp;&nbsp;
        第: <input type="text" name="number" value="${number}">&nbsp;次成绩 &nbsp;&nbsp;
        <input type="submit" value="查询">
    </form>
    <table class="table table-hover text-center">
        <tr>

            <th>学生ID</th>
            <th>姓名</th>
            <th>第几次</th>
           <%-- <th>java程序设计</th>
            <th>数据结构</th>
            <th>高等代数</th>--%>
            <c:forEach var="course" items="${requestScope.courses}">
                <th>${course.coursename}</th>
            </c:forEach>
            <th>总分</th>
            <th>操作</th>
        </tr>

        <c:forEach var="admin" items="${adminPageInfo.list}">
            <tr>
                <td>${admin.userid}</td>
                <td>${admin.username}</td>
                <td>${admin.grade.number}</td>
                <td>${admin.grade.gradeOne}</td>
                <td>${admin.grade.gradeTwo}</td>
                <td>${admin.grade.gradeThree}</td>
                <td>${admin.grade.sum}</td>
                <td> <a href="javascript:void(0)" onclick="queryGrade(${admin.grade.gid},${adminPageInfo.pageNum})" style="color: #ff9900">修改成绩</a> |
                    <a href="javascript:void(0)" onclick="uploadGrade(${admin.userid},'${admin.username}',${adminPageInfo.pageNum})" style="color: #0F91CB">上传成绩</a> |
                    <a href="javascript:void(0)" onclick="deleteGrade(${admin.userid},${admin.grade.gid},${adminPageInfo.pageNum})" style="color: #ee3333">删除成绩</a>
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

                            <a href="admin/queryGradeByPage?name=${requestScope.name}&number=${number}&pageNum=1">首页</a> <a
                                href="admin/queryGradeByPage?name=${requestScope.name}&number=${number}&pageNum=${requestScope.adminPageInfo.prePage}">上一页</a>
                        </c:otherwise>
                    </c:choose>
                    <!-- 当前页显示在span里面,其它页点击后跳转页面 -->
                    <c:forEach var="num" items="${requestScope.adminPageInfo.navigatepageNums}">
                        <c:choose>
                            <c:when test="${requestScope.adminPageInfo.pageNum==num}">
                                <span class="current">${num}</span>
                            </c:when>
                            <c:otherwise>
                                <a href="admin/queryGradeByPage?name=${requestScope.name}&number=${number}&pageNum=${num}" >${num}</a>
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>
                    <c:choose>
                        <c:when test="${!requestScope.adminPageInfo.hasNextPage}">
                            <a class="nocls">下一页</a> <a class="nocls">尾页</a>
                        </c:when>
                        <c:otherwise>
                            <a href="admin/queryGradeByPage?name=${requestScope.name}&number=${number}&pageNum=${requestScope.adminPageInfo.nextPage}">下一页</a>
                            <a href="admin/queryGradeByPage?name=${requestScope.name}&number=${number}&pageNum=${requestScope.adminPageInfo.pages}">尾页</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </td>
        </tr>

        <%--<tr>
                <td colspan="80"><div class="pagelist">
                        <!-- 当前页是第1页时，首页，上一页直接显示，
                 <a class="nocls">首页</a>   <a class="nocls">上一页</a>
                   不是第1页时，点击后跳转页面,onclick指定函数 -->
                        <a href="javascript:void(0)" onclick="alert('首页');">首页</a> <a
                            href="javascript:void(0)" onclick="alert('上一页');">上一页</a>
                        <!-- 当前页显示在span里面,其它页点击后跳转页面 -->
                        <a href="javascript:void(0)" onclick="alert(1);">1</a> <span
                            class="current">2</span>
                        <!-- 当前页是尾页时，尾页，下一页直接显示，
                 <a class="nocls">下一页</a>   <a class="nocls">尾页</a>
                   不是尾页时，点击后跳转页面,onclick指定函数 -->
                        <a class="nocls">下一页</a> <a class="nocls">尾页</a>
                    </div></td>
            </tr>--%>
    </table>
</div>
<script>
    //去到修改页面的函数,因为可能会出现没有分数的现象，所以加入userid
    function  queryGrade(gid,pageNum) {
        //请求CustomerServlet,用location.href发送get请求
        location.href="admin/toUpdateGrade?gid="+gid+"&pageNum="+pageNum;
    }

    //去上传
    function  uploadGrade(userid,username,pageNum) {
        //请求CustomerServlet,用location.href发送get请求
        location.href="admin/toUploadGrade?userId="+userid+"&username="+username+"&pageNum="+pageNum;
    }

    //去删除
    function  deleteGrade(userid,gid,pageNum) {
        //请求CustomerServlet,用location.href发送get请求
        location.href="admin/deleteGrade?gid="+gid+"&pageNum="+pageNum+"&userId="+userid;
    }

</script>
</body>
</html>
