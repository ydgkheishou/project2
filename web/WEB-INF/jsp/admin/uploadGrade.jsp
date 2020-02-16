<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/commons/common.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <title>上传学生成绩页面</title>
</head>
<body>

<div class="container">
    <div class="panel admin-panel margin-top">
        <div class="panel-head" id="add">
            <strong><h3><span class="icon ion-person-add margin-small"></span>学生成绩上传</h3></strong>
        </div>
        <div class="body-content">
            <form method="post" class="form-x"
                  action="${pageContext.request.contextPath}/admin/gradeInsert">
                <div class="form-group">
                    <input hidden value="${pageNum}" name="pageNum">
                    <input hidden value="${userid}" name="userId"/>
                    <div class="label">
                        <label>学生姓名：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input w80" name="username" value="${username}" readonly
                               data-validate="required:请填写学生姓名! "/>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>第几次成绩：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input w80" name="number"
                               data-validate="required:请填写是第几次成绩!"/>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>java程序设计成绩：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input w80" name="gradeOne"
                               data-validate="required:语文成绩不能为空!"/>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>数据结构成绩：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input w80" name="gradeTwo"
                               data-validate="required:数学成绩不能为空!"/>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>高等代数成绩：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input w80" name="gradeThree"
                               data-validate="required:英语成绩不能为空!"/>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label></label>
                    </div>
                    <div class="field">
                        <button class="button bg-main icon-check-square-o" type="submit">
                            上传成绩
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

