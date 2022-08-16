<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<form action="insert" method="post">
    <p>　名　前　<input type="text" name="login"></p>
    <p>パスワード<input type="text" name="password"></p>
    <input type="submit" value="登録">
</form>

<%@include file="../footer.html" %>