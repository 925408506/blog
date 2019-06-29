<!DOCTYPE html>


<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <title>Title</title>
</head>
<body>
<form action="${url}" method="post">
    <table width="100%">
        <tr>

            <td><input name="id" type="text" value="${band.id}" hidden></td>
        </tr>
        <tr>
            <td>名称</td>
            <td><input name="name"type="text" value="${band.name}"></td>
        </tr>
        <tr>
            <td>说明</td>
            <td><textarea name="remark" cols="50" rows="10" >${band.remark}</textarea></td>
        </tr>
        <tr>
            <td>状态</td>
            <td>
                <select name="status">
                    <option value="0">禁用</option>
                    <option value="9">启用</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>操作</td>
            <td>
                <button>保存</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
