-- itemsテーブルにダミーデータを挿入
INSERT IGNORE INTO items (code, name) VALUES
('0001', 'Item 1'),
('0002', 'Item 2'),
('0003', 'Item 3'),
('0004', 'Item 4');

-- inventory_transactionsテーブルにダミーデータを挿入
INSERT IGNORE INTO inventory_transactions (type, date_time, item_code, quantity, description) VALUES
('ADJUST', '2023-06-22 10:00:00', '0001', 10, 'Adjustment 1'),
('RECEPT', '2023-06-22 11:00:00', '0002', 5, 'Receipt 1'),
('ISSUE', '2023-06-22 12:00:00', '0003', -3, 'Issue 1'),
('ADJUST', '2023-06-23 09:00:00', '0004', 8, 'Adjustment 2'),
('RECEPT', '2023-06-23 10:00:00', '0001', 2, 'Receipt 2'),
('ISSUE', '2023-06-23 11:00:00', '0002', -4, 'Issue 2');
