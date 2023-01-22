INSERT INTO currency_dictionary (id, code, name)
VALUES (1000,'EUR', 'Euro'),
       (2000,'USD', 'Dollars');

INSERT INTO Employee (id, first_name, last_name, email, phone, function)
VALUES (1000, 'Latoya', 'Natosha', 'natosha@gmail.com', 060270242, 'OPERATOR1'),
       (2000, 'Enrique', 'Ebert', 'ebert@gmail.com', 061270224, 'OPERATOR2'),
       (3000, 'Curtis', 'Doyle', 'doyle@gmail.com', 062270352, 'OPERATOR3');

INSERT INTO exchange_rate (id, rate, exchange, created_at, currency_dictionary_id, employee_id)
VALUES (1000, 1, 19.30, '2022-01-01', 1000, 1000),
       (2000, 1, 19.15, '2022-01-01', 2000, 2000);

INSERT INTO cash (id, amount_to_exchange, exchange_rate_id)
VALUES (1000, 1000, 1000),
       (2000, 2000, 1000),
       (3000, 5000,  2000),
       (4000, 3000, 1000),
       (5000, 1500, 2000),
       (6000, 2300, 2000);

INSERT INTO Client (id, first_name, last_name, email, phone, idnp)
VALUES (1000, 'Andres', 'Schaden', 'schaden@gamil.com', 060270280, 256419668543),
       (2000, 'Miles', 'Gibson', 'gibson@gamil.com', 061220284, 256419668545),
       (3000, 'Alfons', 'Donnelly', 'donnelly@gamil.com', 062270284, 2656419668542);

INSERT INTO currency_exchange (id, created_at, amount_received, client_id, employee_id, cash_id)
VALUES (1000, '2022-01-01', NULL, 1000, 2000, 1000),
       (2000, '2022-01-01', NULL, 2000, 3000, 3000),
       (3000, '2022-01-02', NULL, 3000, 1000, 2000);