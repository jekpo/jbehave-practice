
### BUSINESS RULES USED IN THE CODE ###

#### Customer Business Rules ####

* Customers with age less than or equal to 2 are considered infants
* Customers with age less than 18 are considered children
* Customers with age equal to or greater than 18 are considered adults
* Adults are allowed to buy cigarettes
* Only adults with age greater than or equal to 21 are allowed to purchase or consume alcohol

* The default age for a person or customer is 0
* The default name for a person is John Doe

#### Banking Business Rules ####

* When a deposit is made in the account the balance increases by that amount
* When a withdrawal is made on the account the balance reduces by that amount
* If not specified, then by default all accounts start with a balance of $0.00
* Customers are always able to make a deposit regardless of their account balance
* Customers are only able to make a withdrawal if the have a balance greater than $0.00
