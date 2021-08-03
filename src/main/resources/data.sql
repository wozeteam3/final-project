INSERT INTO 
	benefits (dental,life,health,401k_match_amount)
VALUES
	(0,0,1,5),
    (1,0,1,5),
    (0,1,1,5),
    (1,1,1,5),
    (0,0,1,20),
    (1,0,1,20),
    (0,1,1,20),
    (1,1,1,20);    
INSERT INTO
	paygrade_hourly (grade,step0,step1,step2,step3,step4)
VALUES
	(0,8.75,9,9.5,10,10.5),
    (1,10,10.5,11,11.5,12),
    (2,15,16,16.5,17,18),
    (3,20,21,22,23,24),
    (4,30,32,33,34,34.75),
    (5,40,41,42.5,45,50);
    
INSERT INTO
	paygrade_salary (grade,step0,step1,step2,step3,step4)
VALUES
	(0,20000,22000,24000,25500,28000),
    (1,35000,40000,42000,44000,46000),
    (2,50000,52000,53000,55000,58000),
    (3,65000,70000,75000,77500,80000),
    (4,90000,92000,95000,100000,103000),
    (5,100000,120000,125000,130000,135000);

INSERT INTO
	employee (benefit_id,first_name,last_name,email,phone_num,pay_grade,pay_step,salaried)
VALUES
	(9,'andy','Dorf','andy_dorf@gmail.com','1919414202',2,0,0),
    (10,'mins','Cart','minniec@hotmail.com','1919414202',4,4,1),
    (11,'フブキ','白上','aidcostello@gmail.com','1919414202',0,1,0),
    (12,'Blaise','Pascal','aidcostello@gmail.com','1919414202',2,3,1),
    (9,'Carl','Pierre','aidcostello@gmail.com','1919414202',0,4,1),
    (14,'Angela','Caldwel','aidcostello@gmail.com','1919414202',4,0,0),
    (10,'Diana','Smith','aidcostello@gmail.com','1919414202',1,1,0);

    