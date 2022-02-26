
drop table g5_branch;

create table g5_Cust1(
		 account_no NUMBER PRIMARY KEY,
		 cust_name VARCHAR2(30),
		 cust_mob_no VARCHAR2(13),
		 cust_gender VARCHAR2(6),
		 cust_email VARCHAR2(70),
		 cust_dob DATE,
		 cust_house_no_name varchar2(70),
		 cust_street_name varchar2(70),
		 cust_landmark varchar2(70),
		 cust_city varchar2(30),
		 cust_state varchar2(20),
		 cust_country varchar2(20),
		 cust_pincode varchar2(8),
		 cust_branch varchar2(30),
		 cust_aadhar_no varchar2(20),
		 cust_pan_no varchar2(30)
);

alter table g5_Cust drop column cust_signature;

 
		  create table g5_account1( 
		 account_no NUMBER,
		 account_balance NUMBER(10,2),
		 account_type VARCHAR2(30),
		 IFSC  VARCHAR2(30),
		 FOREIGN KEY (account_no) REFERENCES g5_Cust(account_no)
		 );
		 
create table g5_cust_login1( 
 cust_account_no NUMBER PRIMARY KEY,
 cust_user_id VARCHAR2(20) ,
 cust_password VARCHAR2(30)
 );
 
 create table g5_branch(
 IFSC varchar2(20) primary key,
 branch_name varchar2(30)
 );
 
 select * from g5_account1;
 select * from g5_cust_login1;
		 
 create table transactions(
 transaction_id NUMBER,
 transaction_date_time DATE,
 sender_account_no NUMBER,
 reciever_account_no NUMBER,
 transaction_amount DECIMAL(11,3),
 transaction_type varchar2(30),
 available_balance decimal(11,3)
 );
 
 alter table transactions drop column transaction_note;
 
 
 
 
 
 insert into g5_branch values('IN0016149','Ahmednagar');
 insert into g5_branch values('IN0017553','Koparkhairne');
 insert into g5_branch values('IN0013275','Ghansoli');
 insert into g5_branch values('IN0012306','Thane');
 insert into g5_branch values('IN0014796','Mulund');
 insert into g5_branch values('IN0014397','Fort');
 insert into g5_branch values('IN0014998','Bandra');
 insert into g5_branch values('IN0014099','Churchgate');
 insert into g5_branch values('IN0014868','Kharghar');
 insert into g5_branch values('IN0014870','Seawoods');
 insert into g5_branch values('IN0014881','Vashi');
 insert into g5_branch values('IN0014888','Nerul');
 insert into g5_branch values('IN0014811','Kalyan');
 insert into g5_branch values('IN0014938','Patel Nagar');
 insert into g5_branch values('IN0014668','Janak Puri');
 insert into g5_branch values('IN0014638','Cannaught Place');
 insert into g5_branch values('IN0014898','Karol Bagh');
 insert into g5_branch values('IN0014800','Rajaori Garden');
 
  select * from g5_branch;
  create sequence accountno_Seq 
  minvalue  1000000000
  start with 1000000000 increment by 1 
  maxvalue 99999999999;
  
   select * from transactions;
  delete from transactions;
   insert into  account(account_no,customer_name) values(Registration_Seq.nextval,'Anv');
   delete from g5_account1;
   select account_no,customer_name from Registration;
   
   select * from g5_cust_login1;
   select * from g5_cust1;
   select * from payee;
   select * from g5_account1;
   select * from payee;
   drop table g5_cust_login1;
   delete from g5_cust1;
   create table payee(
   account_no NUMBER  primary key,
    IFSC varchar2(20),
   account_type VARCHAR2(30),
   payee_name varchar2(30)
  );
  
  insert into payee values(12345,'IN0016149','Saving','Akash');

   