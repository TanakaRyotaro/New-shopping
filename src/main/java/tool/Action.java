package tool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action {
//Actionｸﾗｽの宣言 抽象ﾒｿｯﾄﾞのexecuteを含むので、抽象ｸﾗｽになる｡
    public abstract String execute (
//executeﾒｿｯﾄﾞを引数として､戻り値は文字列(String型)にして､ﾌｫﾜｰﾄﾞ先のURLを返す
        HttpServletRequest request, HttpServletResponse response
    ) throws Exception;
}