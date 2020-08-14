CREATE SCHEMA IF NOT EXISTS test;

SET SCHEMA test;

DROP TABLE IF EXISTS test.SAMPLE CASCADE;

CREATE TABLE test.SAMPLE (
  id SERIAL NOT NULL PRIMARY KEY,
  model varchar(4000) NOT NULL,
  price NUMERIC(20, 3) NOT NULL
);

INSERT INTO test.SAMPLE
(model, price)
VALUES
(
    'UNKNOWN',
    10000
),
(
    'SM-G973N',
    20000
),
(
    'SM-N976N',
    30000
),
(
    'SM-G960N',
    40000
),
(
    'SM-G955N',
    50000
),
(
    'SM-N960N',
    60000
)
;

COMMIT;
