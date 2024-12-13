CREATE TABLE comments
(
    id     BIGINT NOT NULL PRIMARY KEY,
    text   VARCHAR(255),
    author VARCHAR(255)
);
INSERT INTO comments (id, text, author)
VALUES (1, 'Hello World!', 'Eddy Herrera');
INSERT INTO comments (id, text, author)
VALUES (2, 'My second commentEntity!', 'Eddy Herrera');
INSERT INTO comments (id, text, author)
VALUES (3, 'Research in CS', 'Eddy Herrera');
INSERT INTO comments (id, text, author)
VALUES (4, 'I really enjoyed reading this article.', 'Eddy Herrera');
INSERT INTO comments (id, text, author)
VALUES (5, 'Interesting topic, I really believe you nailed this one!', 'Eddy Herrera');