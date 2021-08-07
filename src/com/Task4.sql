Create table If Not Exists Trips 
(
    Id INT(5),
    Client_Id INT(5),
    Driver_Id INT(5), 
    City_Id INT(5), 
    Status ENUM('completed','cancelled_by_driver', 'cancelled_by_client'),
    Request_at varchar(50)
);
INSERT INTO Trips(Id, Client_Id, Driver_Id,City_Id, Status, Request_at)  
           VALUES
                 ('1', '1', '10', '1', 'completed', '2013-10-01'),
                 ('2', '2', '11', '1', 'cancelled_by_driver', '2013-10-01'),
                 ('3', '3', '12', '6', 'completed', '2013-10-01'),
                 ('4', '4', '13', '6','cancelled_by_client', '2013-10-01'),
                 ('5', '1', '10', '1', 'completed', '2013-10-02'),
                 ('6', '2', '11', '6', 'completed', '2013-10-02'),
                 ('7', '3', '12', '6', 'completed', '2013-10-02'),
                 ('8', '2', '12', '12', 'completed', '2013-10-03'),
                 ('9', '3', '10', '12', 'completed', '2013-10-03'),
                 ('10', '4', '13', '12','cancelled_by_driver', '2013-10-03');



Create table If Not Exists Users 
(
    Users_Id INT(5),
    Banned VARCHAR(50), 
    Role ENUM('client', 'driver', 'partner')
);
INSERT INTO Users (Users_Id, Banned, Role)
            VALUES 
                  ('1', 'No', 'client'),
                  ('2', 'Yes', 'client'),
                  ('3', 'No', 'client'),
                  ('4', 'No', 'client'),
                  ('10', 'No', 'driver'),
                  ('11', 'No', 'driver'),
                  ('12', 'No', 'driver'),
                  ('13', 'No', 'driver');

select 
t.Request_at Day, 
round(sum(case when t.Status = 'completed' then 0 else 1 end) / count(*), 2) 'Cancellation Rate'
from Trips t
inner join Users u 
on t.Client_Id = u.Users_Id and u.Banned = 'No'
where t.Request_at between '2013-10-01' and '2013-10-03'
group by t.Request_at