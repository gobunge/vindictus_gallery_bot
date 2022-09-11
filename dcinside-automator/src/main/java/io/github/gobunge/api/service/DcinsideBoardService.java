package io.github.gobunge.api.service;

import static io.github.gobunge.api.enumerate.Gallery.DCINSIDE_VINDICTUS;

import be.zvz.kotlininside.KotlinInside;
import be.zvz.kotlininside.api.article.ArticleWrite;
import be.zvz.kotlininside.api.type.Article;
import be.zvz.kotlininside.api.type.content.Content;
import be.zvz.kotlininside.api.type.content.HtmlContent;
import be.zvz.kotlininside.api.type.content.MarkdownContent;
import be.zvz.kotlininside.api.type.content.StringContent;
import be.zvz.kotlininside.session.Session;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DcinsideBoardService {
    private final KotlinInside kotlinInside;

    public DcinsideBoardService(KotlinInside kotlinInside) {
        this.kotlinInside = kotlinInside;
    }

    public void write()
        throws InterruptedException {
        List<Content> contentList = List.of(
            new StringContent("테스트"),
            new MarkdownContent("**테스트**"),
            new HtmlContent("<strike>테스트</strike>")
        );

        Article article = new Article("테스트", contentList);

        Session session = kotlinInside.session;

        ArticleWrite articleWrite = new ArticleWrite(DCINSIDE_VINDICTUS.code(), article, session);

        Thread.sleep(5_000);

        var writeResult = articleWrite.write();

        log.info(writeResult.toString());
    }

    public void write(String subject, List<? extends Content> contents, Session session)
        throws InterruptedException {
        List<Content> contentList = List.of(
            new StringContent("테스트"),
            new MarkdownContent("**테스트**"),
            new HtmlContent("<strike>테스트</strike>")
        );

        Article article = new Article("테스트", contentList);

        Session session1 = kotlinInside.session;

        ArticleWrite articleWrite = new ArticleWrite(DCINSIDE_VINDICTUS.code(), article, session);

        Thread.sleep(5_000);

        var writeResult = articleWrite.write();

        log.info(writeResult.toString());
    }
}
