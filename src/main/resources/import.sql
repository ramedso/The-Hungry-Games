INSERT INTO tb_post(title, description, date, is_open) VALUES ('Food', 'food 4 all', TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', TRUE);

INSERT INTO tb_comment(description, date, post_id) VALUES ('I want it', TIMESTAMP WITH TIME ZONE '2020-07-15T10:00:00Z', 1);