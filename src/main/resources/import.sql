INSERT INTO tb_user(name, cpf, password, address, phone, sign_Up_Date, email) VALUES ('John',    '45844165895', '$2a$12$ib2eYbVRSfR.sw4F09c67u1pxvR1rxzP2NzBed8qFcvGx8faWadpK', 'Baker Street',     '13982658485', '27-10-1999', 'john@email.com');
INSERT INTO tb_user(name, cpf, password, address, phone, sign_Up_Date, email) VALUES ('Maria',   '45844165896', '$2a$12$ib2eYbVRSfR.sw4F09c67u1pxvR1rxzP2NzBed8qFcvGx8faWadpK', 'Hope Street',      '11265478596', '27-10-1993', 'maria@email.com');
INSERT INTO tb_user(name, cpf, password, address, phone, sign_Up_Date, email) VALUES ('Hope',    '45844165897', '$2a$12$ib2eYbVRSfR.sw4F09c67u1pxvR1rxzP2NzBed8qFcvGx8faWadpK', 'Victory Street',   '45678912352', '27-06-1993', 'hope@email.com');
INSERT INTO tb_user(name, cpf, password, address, phone, sign_Up_Date, email) VALUES ('Victory', '45844165898', '$2a$12$ib2eYbVRSfR.sw4F09c67u1pxvR1rxzP2NzBed8qFcvGx8faWadpK', 'Brilliant Street', '14785236985', '27-09-1993', 'victory@email.com');

INSERT INTO tb_role (authority) VALUES ('ROLE_USER');
INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (4, 3);

INSERT INTO tb_post(title, description, date, thread_Open, user_id) VALUES ('Have some food here!', 'Rice, beans and chocolates!', TIMESTAMP WITH TIME ZONE '2020-07-15T10:00:00Z', TRUE, 1);
INSERT INTO tb_post(title, description, date, thread_Open, user_id) VALUES ('Some lore ipsum here!', 'yeah yeah yeah', TIMESTAMP WITH TIME ZONE '2020-07-15T10:00:00Z', TRUE, 2);

INSERT INTO tb_comment(description, date, post_id, user_id) VALUES ('hey, i need it - Hope', TIMESTAMP WITH TIME ZONE '2020-07-15T10:00:00Z', 1, 2);
INSERT INTO tb_comment(description, date, post_id, user_id) VALUES ('hey, i need it', TIMESTAMP WITH TIME ZONE '2020-07-15T10:00:00Z', 1, 2);