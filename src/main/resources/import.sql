INSERT INTO tb_user(name, password, address, phone, sign_Up_Date) VALUES ('John', '$2a$12$ib2eYbVRSfR.sw4F09c67u1pxvR1rxzP2NzBed8qFcvGx8faWadpK', 'Baker Street', '13982658485', '27-10-1999');
INSERT INTO tb_user(name, password, address, phone, sign_Up_Date) VALUES ('Maria', '$2a$12$ib2eYbVRSfR.sw4F09c67u1pxvR1rxzP2NzBed8qFcvGx8faWadpK', 'Hope Street', '11265478596', '27-10-1993');

INSERT INTO tb_document(user_id, doc_Number, legal_Person) VALUES (1, '870.050.750-48', FALSE);
INSERT INTO tb_document(user_id, doc_Number, legal_Person) VALUES (2, '23.075.868/0001-56', TRUE);

INSERT INTO tb_email(user_id, email_Address) VALUES (1, 'john@email.com');
INSERT INTO tb_email(user_id, email_Address) VALUES (2, 'maria@email.com');

INSERT INTO tb_post(title, description, date, thread_Open, user_id) VALUES ('Have some food here!', 'Rice, beans and chocolates!', TIMESTAMP WITH TIME ZONE '2020-07-15T10:00:00Z', TRUE, 1);

INSERT INTO tb_comment(description, date, post_id, user_id) VALUES ('hey, i need it - Hope', TIMESTAMP WITH TIME ZONE '2020-07-15T10:00:00Z', 1, 2);