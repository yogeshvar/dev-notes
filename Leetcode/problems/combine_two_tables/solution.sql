# Write your MySQL query statement below
SELECT 
  Person.firstName, 
  Person.lastName, 
  COALESCE(Address.city, NULL) AS city, 
  COALESCE(Address.state, NULL) AS state 
FROM 
  Person 
LEFT JOIN 
  Address 
ON 
  Person.personId = Address.personId;