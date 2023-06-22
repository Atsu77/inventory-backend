CREATE TABLE IF NOT EXISTS items (
  code VARCHAR(10) PRIMARY KEY,
  name VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS inventory_transactions (
  id INT AUTO_INCREMENT PRIMARY KEY,
  type ENUM('ADJUST', 'RECEPT', 'ISSUE') NOT NULL,
  date_time TIMESTAMP NOT NULL,
  item_code VARCHAR(10) NOT NULL,
  quantity INT NOT NULL,
  CONSTRAINT check_quantity_recept CHECK ((type = 'RECEPT' AND quantity > 0) OR type <> 'RECEPT'),
  CONSTRAINT check_quantity_issue CHECK ((type = 'ISSUE' AND quantity < 0) OR type <> 'ISSUE'),
  description VARCHAR(20)
);
