<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--このJSPでは､JSTLを使用するので､taglibﾃﾞｨﾚｸﾃｨﾌﾞを記述--%>

<%@include file="header.html" %>
<%@include file="menu.jsp" %>

<p>検索キーワードを入力してください｡</p>
<form action="Product.action" method="post">
    <input type="text" name="keyword">
    <input type="submit" value="検索">
</form>
<hr>
<%-- 検索ｷｰﾜｰﾄﾞを入力するためのﾌｫｰﾑ｡｢検索｣ﾎﾞﾀﾝを選択後
                            Product.actionにﾘｸｴｽﾄが送信される --%>

<table style="border-collapse:separate;border-spacing:10px;">
<%-- tableﾀｸﾞに含まれる行や列を --%>
    <c:forEach var="product" items="${list}">
    <%-- 繰り返す回数は､ProductActionｸﾗｽによりｾｯｼｮﾝ属性に保存された
        ﾘｽﾄに含まれるProductｵﾌﾞｼﾞｪｸﾄの数 --%>
        <tr>
            <td>商品${product.id}</td>
            <td><img src="image/${product.id}.jpg" height="64"></td>
<%--商品番号は､Productｵﾌﾞｼﾞｪｸﾄのidﾌﾟﾛﾊﾟﾃｨから取得できるため各Product
 ｵﾌﾞｼﾞｪｸﾄが変数productに代入されている場合､imgﾀｸﾞは､EL式を使って記述可--%>
            <td>${product.name}</td>
            <td>${product.price}円</td>
            <td><a href="CartAdd.action?id=${product.id}">カートに追加</a></td>
<%--ｶｰﾄに商品を追加する為のﾘﾝｸ｡ﾘﾝｸ選択後､CartAdd.actionにﾘｸｴｽﾄ送信
    ﾘﾝｸ先のURLにﾘｸｴｽﾄﾊﾟﾗﾒｰﾀを付加して商品番号を渡す--%>
        </tr>
    </c:forEach>
</table>

<%@include file="footer.html" %>