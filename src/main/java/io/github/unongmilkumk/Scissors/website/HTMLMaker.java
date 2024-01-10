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

    public static void main(String[] args) {
        HTMLMaker hm = new HTMLMaker().doctypeHTML().html();
        hm.head().title("HTMLMAKER").closeHead();
        hm.body().h1("HELLO WORLD").p("This is a paragraph.")
                .a("https://www.example.com", "Visit Example.com")
                .img("image.jpg", "An example image").div().span("This is a span").closeDiv().closeBody().closeHtml();
        System.out.println(hm.getHTML());
    }
}
