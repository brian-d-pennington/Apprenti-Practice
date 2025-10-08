CREATE TABLE Movies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    year INT,
    rating VARCHAR(10) -- Stores MPAA ratings like 'G', 'PG', 'PG-13', 'R', 'NC-17'
    genre VARCHAR(100) -- Stores genre like 'Action', 'Drama', 'Comedy', etc.
);


CREATE TABLE Actors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    total_credits INT DEFAULT 0
);

-- Create Credits table (junction table for many-to-many relationship)
CREATE TABLE Credits (
    id INT AUTO_INCREMENT PRIMARY KEY,
    movie_id INT NOT NULL,
    actor_id INT NOT NULL,
    role VARCHAR(255), -- Character name or role description
    billing_order INT, -- Order of appearance in credits (1 = lead, 2 = supporting, etc.)
    FOREIGN KEY (movie_id) REFERENCES Movies(id) ON DELETE CASCADE,
    FOREIGN KEY (actor_id) REFERENCES Actors(id) ON DELETE CASCADE,
    UNIQUE KEY unique_movie_actor (movie_id, actor_id) -- Prevents duplicate entries
);