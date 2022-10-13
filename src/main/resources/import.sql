INSERT INTO tb_user(name, address, phone, birth_Date, is_Legal_Person) VALUES ('John', 'Baker Street', '12346789', '27-10-1999', FALSE);
INSERT INTO tb_user(name, address, phone, birth_Date, is_Legal_Person) VALUES ('Hope', 'Hope Street', '987654321', '27-10-1993', TRUE);

INSERT INTO tb_document(user_id, doc_Number) VALUES (1, '123456789');
INSERT INTO tb_document(user_id, doc_Number) VALUES (2, '45678912356655');

INSERT INTO tb_email(user_id, email_Address) VALUES (1, 'john@email.com');
INSERT INTO tb_email(user_id, email_Address) VALUES (2, 'hope@email.com');

INSERT INTO tb_post(title, description, date, thread_Open, user_id) VALUES ('Have some food here!', 'Rice, beans and chocolates!', TIMESTAMP WITH TIME ZONE '2020-07-15T10:00:00Z', TRUE, 1);

INSERT INTO tb_comment(description, date, post_id, user_id) VALUES ('hey, i need it - Hope', TIMESTAMP WITH TIME ZONE '2020-07-15T10:00:00Z', 1, 2);