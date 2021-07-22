use projectservlet2021;


Create table role(
	id bigint NOT NULL primary Key auto_increment,
    name Varchar(255) Not Null,
    code Varchar(255) Not Null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby VARCHAR(255)	null,
    modifiedby VARCHAR(255) null
);

Create Table user(
	id bigint Not Null Primary Key auto_increment,
    name varchar(255) Not Null,
    password varchar(255) Not null,
    fullname varchar(255) Null,
    roleid bigint Not Null,
    status int Not Null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby VARCHAR(255)	null,
    modifiedby VARCHAR(255) null
);

Alter table user Add constraint fk_user_role FOREIGN KEY (roleid) References role(id);

Create Table news(
	id bigint Not Null Primary Key auto_increment,
    title varchar(255)  Null,
    thumbnail varchar(255) null,
    shortdescription text Null,
    content text Null,
    categoryid bigint Not null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby VARCHAR(255)	null,
    modifiedby VARCHAR(255) null
);


Create Table category(
	id bigint Not Null Primary Key auto_increment,
	name Varchar(255) not null,
    code Varchar (255) not null, 
    createddate timestamp null,
    modifieddate timestamp null,
    createdby VARCHAR(255)	null,
    modifiedby VARCHAR(255) null
);

Alter table news Add constraint fk_news_category FOREIGN KEY (categoryid) References category(id);

Create Table comment(
	id bigint Not Null Primary Key auto_increment,
	content text not null,
    user_id bigint not null,
    new_id bigint not null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby VARCHAR(255)	null,
    modifiedby VARCHAR(255) null
);

Alter table comment Add constraint fk_comment_user FOREIGN KEY (user_id) References user(id);
Alter table comment Add constraint fk_comment_new FOREIGN KEY (new_id) References news(id);