INSERT INTO users(id, join_date, name, password, ssn) VALUES(90001, now(), 'User1', 'test1111', '111111-1111111');
INSERT INTO users(id, join_date, name, password, ssn) VALUES(90002, now(), 'User2', 'test2222', '222222-2222222');
INSERT INTO users(id, join_date, name, password, ssn) VALUES(90003, now(), 'User3', 'test3333', '333333-3333333');

INSERT INTO post(description, user_id) VALUES ('My first post', 90001);
INSERT INTO post(description, user_id) VALUES ('My second post', 90001);