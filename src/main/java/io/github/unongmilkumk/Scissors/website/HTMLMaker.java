package io.github.unongmilkumk.Scissors.website;

public class HTMLMaker {
    private StringBuilder html;
    private int indentationLevel;

    public HTMLMaker() {
        this.html = new StringBuilder();
        this.indentationLevel = 0;
    }

    private void appendIndentation() {
        html.append("    ".repeat(Math.max(0, indentationLevel)));
    }

    public HTMLMaker doctypeHTML() {
        html.append("<!DOCTYPE html>\n");
        return this;
    }

    public HTMLMaker html() {
        appendIndentation();
        html.append("<html>\n");
        indentationLevel++;
        return this;
    }

    public HTMLMaker head() {
        appendIndentation();
        html.append("<head>\n");
        indentationLevel++;
        return this;
    }

    public HTMLMaker title(String titleText) {
        appendIndentation();
        html.append("<title>").append(titleText).append("</title>\n");
        return this;
    }

    public HTMLMaker closeHead() {
        indentationLevel--;
        appendIndentation();
        html.append("</head>\n");
        return this;
    }

    public HTMLMaker body() {
        appendIndentation();
        html.append("<body>\n");
        indentationLevel++;
        return this;
    }

    public HTMLMaker h1(String text) {
        appendIndentation();
        html.append("<h1>").append(text).append("</h1>\n");
        return this;
    }

    public HTMLMaker p(String text) {
        appendIndentation();
        html.append("<p>").append(text).append("</p>\n");
        return this;
    }

    public HTMLMaker a(String href, String text) {
        appendIndentation();
        html.append("<a href=\"").append(href).append("\">").append(text).append("</a>\n");
        return this;
    }

    public HTMLMaker img(String src, String alt) {
        appendIndentation();
        html.append("<img src=\"").append(src).append("\" alt=\"").append(alt).append("\">\n");
        return this;
    }

    public HTMLMaker div() {
        appendIndentation();
        html.append("<div>\n");
        indentationLevel++;
        return this;
    }

    public HTMLMaker closeDiv() {
        indentationLevel--;
        appendIndentation();
        html.append("</div>\n");
        return this;
    }

    public HTMLMaker span(String text) {
        appendIndentation();
        html.append("<span>").append(text).append("</span>\n");
        return this;
    }

    public HTMLMaker closeBody() {
        indentationLevel--;
        appendIndentation();
        html.append("</body>\n");
        return this;
    }

    public HTMLMaker closeHtml() {
        indentationLevel--;
        appendIndentation();
        html.append("</html>\n");
        return this;
    }

    public String getHTML() {
        return html.toString();
    }

    public HTMLMaker h2(String text) {
        appendIndentation();
        html.append("<h2>").append(text).append("</h2>\n");
        return this;
    }

    public HTMLMaker li(String text) {
        appendIndentation();
        html.append("<li>").append(text).append("</li>\n");
        return this;
    }

    public HTMLMaker table() {
        appendIndentation();
        html.append("<table>\n");
        indentationLevel++;
        return this;
    }

    public HTMLMaker tr() {
        appendIndentation();
        html.append("<tr>\n");
        indentationLevel++;
        return this;
    }

    public HTMLMaker td(String text) {
        appendIndentation();
        html.append("<td>").append(text).append("</td>\n");
        return this;
    }

    public HTMLMaker closeTr() {
        indentationLevel--;
        appendIndentation();
        html.append("</tr>\n");
        return this;
    }

    public HTMLMaker closeTable() {
        indentationLevel--;
        appendIndentation();
        html.append("</table>\n");
        return this;
    }

    public HTMLMaker br() {
        appendIndentation();
        html.append("<br>\n");
        return this;
    }

    public HTMLMaker strong(String text) {
        appendIndentation();
        html.append("<strong>").append(text).append("</strong>\n");
        return this;
    }

    public HTMLMaker em(String text) {
        appendIndentation();
        html.append("<em>").append(text).append("</em>\n");
        return this;
    }

    public HTMLMaker ul() {
        appendIndentation();
        html.append("<ul>\n");
        indentationLevel++;
        return this;
    }

    public HTMLMaker ol() {
        appendIndentation();
        html.append("<ol>\n");
        indentationLevel++;
        return this;
    }

    public HTMLMaker dl() {
        appendIndentation();
        html.append("<dl>\n");
        indentationLevel++;
        return this;
    }

    public HTMLMaker dt(String text) {
        appendIndentation();
        html.append("<dt>").append(text).append("</dt>\n");
        return this;
    }

    public HTMLMaker dd(String text) {
        appendIndentation();
        html.append("<dd>").append(text).append("</dd>\n");
        return this;
    }

    public HTMLMaker closeUl() {
        indentationLevel--;
        appendIndentation();
        html.append("</ul>\n");
        return this;
    }

    public HTMLMaker closeOl() {
        indentationLevel--;
        appendIndentation();
        html.append("</ol>\n");
        return this;
    }

    public HTMLMaker closeDl() {
        indentationLevel--;
        appendIndentation();
        html.append("</dl>\n");
        return this;
    }

    public HTMLMaker form(String action, String method) {
        appendIndentation();
        html.append("<form action=\"").append(action).append("\" method=\"").append(method).append("\">\n");
        indentationLevel++;
        return this;
    }

    public HTMLMaker closeForm() {
        indentationLevel--;
        appendIndentation();
        html.append("</form>\n");
        return this;
    }

    public HTMLMaker input(String type, String name, String value) {
        appendIndentation();
        html.append("<input type=\"").append(type).append("\" name=\"").append(name)
                .append("\" value=\"").append(value).append("\">\n");
        return this;
    }

    public HTMLMaker select() {
        appendIndentation();
        html.append("<select>\n");
        indentationLevel++;
        return this;
    }

    public HTMLMaker option(String value, String text) {
        appendIndentation();
        html.append("<option value=\"").append(value).append("\">").append(text).append("</option>\n");
        return this;
    }

    public HTMLMaker closeSelect() {
        indentationLevel--;
        appendIndentation();
        html.append("</select>\n");
        return this;
    }

    public HTMLMaker button(String text) {
        appendIndentation();
        html.append("<button>").append(text).append("</button>\n");
        return this;
    }

    public HTMLMaker label(String forAttribute, String text) {
        appendIndentation();
        html.append("<label for=\"").append(forAttribute).append("\">").append(text).append("</label>\n");
        return this;
    }

    public static void main(String[] args) {
        HTMLMaker hm = new HTMLMaker().doctypeHTML().html();
        hm.head().title("HTMLMAKER").closeHead();
        hm.body().h1("HELLO WORLD").p("This is a paragraph.")
                .a("https://www.example.com", "Visit Example.com")
                .img("image.jpg", "An example image").div().span("This is a span").closeDiv()
                .h2("Subheading").ul().li("List item 1").li("List item 2").closeUl()
                .table().tr().td("Row 1, Column 1").td("Row 1, Column 2").closeTr()
                .tr().td("Row 2, Column 1").td("Row 2, Column 2").closeTr().closeTable()
                .strong("Strong text").em("Emphasized text")
                .ul().li("List item 1").li("List item 2").closeUl()
                .ol().li("Ordered item 1").li("Ordered item 2").closeOl()
                .dl().dt("Definition term 1").dd("Definition description 1")
                .dt("Definition term 2").dd("Definition description 2").closeDl()
                .form("/submit", "post").input("text", "username", "").br()
                .select().option("value1", "Option 1").option("value2", "Option 2").closeSelect()
                .button("Submit").label("username", "Username:").closeForm()
                .closeBody().closeHtml();

        System.out.println(hm.getHTML());
    }
}
