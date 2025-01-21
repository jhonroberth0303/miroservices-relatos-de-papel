CREATE TABLE relatosdepapel.Book (
      isbn BIGINT AUTO_INCREMENT PRIMARY KEY,
      title VARCHAR(255) NOT NULL,
      author VARCHAR(255) NOT NULL,
      genre VARCHAR(255),
      editorial VARCHAR(255),
      language VARCHAR(255),
      pages INT,
      year INT,
      description TEXT,
      price DOUBLE DEFAULT 0.0,
      image VARCHAR(255),
      create_at DATE
);