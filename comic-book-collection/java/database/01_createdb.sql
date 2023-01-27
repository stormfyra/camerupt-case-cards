-- The following line terminates any active connections to the database so that it can be dropped
SELECT pg_terminate_backend(pid) 
FROM pg_stat_activity 
WHERE datname = 'comic_book';

DROP DATABASE IF EXISTS comic_book;

DROP USER IF EXISTS comic_book_owner;
DROP USER IF EXISTS comic_book_appuser;

-- then create the database
CREATE DATABASE comic_book;
