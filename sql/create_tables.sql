SET SERVEROUTPUT ON;

-- DROP TABLES IF EXIST AND SUPPRESS ERRORS.
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE tbl_user_advertisement CASCADE CONSTRAINTS';
    EXECUTE IMMEDIATE 'DROP TABLE tbl_advertisement CASCADE CONSTRAINTS';
    EXECUTE IMMEDIATE 'DROP TABLE tbl_advertisement_category CASCADE CONSTRAINTS';
    EXECUTE IMMEDIATE 'DROP TABLE tbl_login CASCADE CONSTRAINTS';
    EXECUTE IMMEDIATE 'DROP TABLE tbl_user CASCADE CONSTRAINTS';
EXCEPTION
    WHEN OTHERS THEN NULL;
END;
/

-- CREATE ALL TABLES
CREATE TABLE tbl_user (
    id INTEGER, 
    name VARCHAR2(100), 
    phone VARCHAR2(11), 
    email VARCHAR2(100), 
    address VARCHAR2(50), 
    CONSTRAINT PK_tbl_user PRIMARY KEY (id));

CREATE TABLE tbl_login (
    id INTEGER, 
    user_id INTEGER, 
    username VARCHAR2(50), 
    password VARCHAR2(100), 
    CONSTRAINT PK_tbl_login PRIMARY KEY (id), 
    CONSTRAINT FK_tbl_login_user 
        FOREIGN KEY (user_id) 
        REFERENCES tbl_user(id));

CREATE TABLE tbl_advertisement_category (
    id INTEGER, 
    category VARCHAR2(50),
    CONSTRAINT PK_tbl_ad_category PRIMARY KEY (id));

CREATE TABLE tbl_advertisement (
    id INTEGER, 
    title VARCHAR2(100), 
    content VARCHAR2(200), 
    ad_category_id INTEGER, 
    create_date DATE, 
    CONSTRAINT PK_tbl_advertisement 
        PRIMARY KEY (id), 
    CONSTRAINT FK_tbl_advertisement_ad_type 
        FOREIGN KEY (ad_category_id) 
        REFERENCES tbl_advertisement_category(id));

CREATE TABLE tbl_user_advertisement (
    id INTEGER, 
    user_id INTEGER, 
    ad_id INTEGER, 
    CONSTRAINT FK_user_ad_user 
        FOREIGN KEY (user_id)
        REFERENCES tbl_user (id), 
    CONSTRAINT FK_user_ad_advertisement 
        FOREIGN KEY (ad_id) 
        REFERENCES tbl_advertisement(id));