ALTER TABLE ACCOUNT DROP CONSTRAINT ACCOUNT_owned_by
ALTER TABLE TRANSACTIONS DROP CONSTRAINT TRNSCTNStrgtccntno
ALTER TABLE TRANSACTIONS DROP CONSTRAINT TRNSCTONSsrccuntno
ALTER TABLE types DROP CONSTRAINT tytrnsctnstrnsctnn
DROP TABLE ACCOUNT
DROP TABLE TRANSACTIONS
DROP TABLE SYS_USER
DROP TABLE types
