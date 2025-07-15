CREATE DATABASE IF NOT EXISTS BankDB;
USE BankDB;

DROP TABLE IF EXISTS accounts;
CREATE TABLE accounts (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          balance DECIMAL(15,2) NOT NULL DEFAULT 0
);

INSERT INTO accounts(balance) VALUES (50000), (50000), (50000);

DELIMITER $$
CREATE PROCEDURE transfer_funds(IN sender_id INT, IN receiver_id INT, IN amount DECIMAL(15,2))
BEGIN
    DECLARE sender_balance DECIMAL(15,2);

    IF NOT EXISTS (SELECT 1 FROM accounts WHERE id = sender_id) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Không tìm thấy người gửi';
END IF;

    IF NOT EXISTS (SELECT 1 FROM accounts WHERE id = receiver_id) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Không tìm thấy người nhận';
END IF;

SELECT balance INTO sender_balance FROM accounts WHERE id = sender_id;
IF sender_balance < amount THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Người gửi không đủ tiền';
END IF;

START TRANSACTION;
UPDATE accounts SET balance = balance - amount WHERE id = sender_id;
UPDATE accounts SET balance = balance + amount WHERE id = receiver_id;
COMMIT;
END$$
DELIMITER ;

SELECT * FROM accounts;