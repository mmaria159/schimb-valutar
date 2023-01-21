INSERT INTO currency_dictionary (id, code, name)
VALUES (1,'EUR', 'Euro'),
       (2,'USD', 'Dollars');

INSERT INTO Employee (id, first_name, last_name, email, phone, function)
VALUES (1, 'Latoya', 'Natosha', 'natosha@gmail.com', 060270242, 'OPERATOR1'),
       (2, 'Enrique', 'Ebert', 'ebert@gmail.com', 061270224, 'OPERATOR2'),
       (3, 'Curtis', 'Doyle', 'doyle@gmail.com', 062270352, 'OPERATOR3');

INSERT INTO exchange_rate (id, rate, exchange, created_at, currency_dictionary_id, employee_id)
VALUES (1, 1, 19.30, '2022-01-01', 1, 1),
       (2, 1, 19.15, '2022-01-01', 2, 2);

INSERT INTO cash (id, amount_to_exchange, exchange_rate_id)
VALUES (1, 1000, 1),
       (2, 2000, 1),
       (3, 500,  2),
       (4, 3000, 1),
       (5, 1500, 2),
       (6, 2300, 2);

INSERT INTO Client (id, first_name, last_name, email, phone, idnp)
VALUES (1, 'Andres', 'Schaden', 'schaden@gamil.com', 060270280, 256419668543),
       (2, 'Miles', 'Gibson', 'gibson@gamil.com', 061220284, 256419668545),
       (3, 'Alfons', 'Donnelly', 'donnelly@gamil.com', 062270284, 2656419668542);

INSERT INTO currency_exchange (id, created_at, amount_received, client_id, employee_id, exchange_rate_id, cash_id)
VALUES (1, '2022-01-01', NULL, 1, 2, 1, 1),
       (2, '2022-01-01', NULL, 2, 3, 1, 3),
       (3, '2022-01-02', NULL, 3, 1, 1, 2);