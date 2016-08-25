CREATE TABLE NEWS (
  id INTEGER NOT NULL ,
  title VARCHAR2(150) NOT NULL ,
  brief VARCHAR2(550) NOT NULL ,
  content VARCHAR2(2500) NOT NULL ,
  news_date DATE NOT NULL ,
  CONSTRAINT news_pk PRIMARY KEY (id)
);

create sequence news_id_seq start with 1 increment by 1;

create or replace trigger news_management_insert
before insert on NEWS_MANAGEMENT
for each row
  begin
    select news_id_seq.nextval into :new.id from dual;
  end;

INSERT INTO NEWS_MANAGEMENT (title, brief, content, news_date)
VALUES ('Title','Brief','content',TO_DATE('2016-08-22 22:40:30', 'YYYY-MM-DD HH24:MI:SS'));

SELECT * FROM NEWS;