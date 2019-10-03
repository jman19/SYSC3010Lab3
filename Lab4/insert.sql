BEGIN;
INSERT INTO temps values(date('now', '-1 day'), time('now'), "kitchen", 20.6);
COMMIT;