package chapter6;

import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// WebServletアノテーションはURLの定義する
// サーブレットのクラスの定義直前に記述する
@WebServlet(urlPatterns = { "/chapter6/select" })
public class Select extends HttpServlet {

  public void doPost (
    HttpServletRequest request, HttpServletResponse response
  ) throws ServletException, IOException {

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();

    request.setCharacterEncoding("UTF-8");

    // リクエストパラメータ各種取得
    String count = request.getParameter("count");
    String payment = request.getParameter("payment");
    String review = request.getParameter("review");
    String mail = request.getParameter("mail");
    // セレクトボックスのみ配列として取得する
    String[] genre = request.getParameterValues("genre");

    Page.header(out);

    // count の出力
    out.println("<p>" + count + "個の商品をカートに入れました。</p>");

    // payment の出力
    out.println("<p>お支払い方法を" + payment + "に設定しました</p>");

    // review の出力
    out.println("<p>ご感想ありがとうございます</p>");
    out.println("<p>「" + review + "」</p>");

    // チェックボックスはif文で対応する
    if (mail != null) {

      out.println("<p>メールをお送りします</p>");

    } else {

      out.println("<p>メールはお送りしません</p>");

    }

    // セレクトボックスはif文で対応する
    if (genre != null) {
      //for文で取得したパラメータの出力を回す
      for (String item : genre) {

        out.println("「" + item + "」");

      }

        out.println("に関するお買い得情報をお届けします");

    } else {

        out.println("お買い得情報はお送りしません");

    }


    Page.footer(out);

  }

}
