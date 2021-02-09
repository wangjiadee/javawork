package com.ralph.Exer;

public class News {
    private String title;
    private String article;

    public News() {
    }

    public News(String title, String article) {
        this.title = title;
        this.article = article;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (!title.equals(news.title)) return false;
        return article.equals(news.article);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + article.hashCode();
        return result;
    }
}
