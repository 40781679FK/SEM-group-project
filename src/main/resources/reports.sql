-- test
SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name
FROM country
LEFT JOIN city ON country.Capital = city.ID
ORDER BY country.Population DESC;

-- check this
SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name
FROM country
LEFT JOIN city ON country.Capital = city.ID
WHERE country.Continent = 'Asia'
ORDER BY country.Population DESC;

-- hmm
SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name
FROM country
LEFT JOIN city ON country.Capital = city.ID
WHERE country.Region = 'Caribbean'
ORDER BY country.Population DESC;

-- limit test
SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name
FROM country
LEFT JOIN city ON country.Capital = city.ID
ORDER BY country.Population DESC
LIMIT 5;

-- try this
SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name
FROM country
LEFT JOIN city ON country.Capital = city.ID
WHERE country.Continent = 'Europe'
ORDER BY country.Population DESC
LIMIT 3;

-- test again
SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name
FROM country
LEFT JOIN city ON country.Capital = city.ID
WHERE country.Region = 'Caribbean'
ORDER BY country.Population DESC
LIMIT 3;

-- check join
SELECT city.Name, country.Name, city.District, city.Population
FROM city
JOIN country ON city.CountryCode = country.Code
ORDER BY city.Population DESC;

-- maybe
SELECT city.Name, country.Name, city.District, city.Population
FROM city
JOIN country ON city.CountryCode = country.Code
WHERE country.Continent = 'Oceania'
ORDER BY city.Population DESC;

-- same thing
SELECT city.Name, country.Name, city.District, city.Population
FROM city
JOIN country ON city.CountryCode = country.Code
WHERE country.Region = 'Caribbean'
ORDER BY city.Population DESC;

-- check this one
SELECT city.Name, country.Name, city.District, city.Population
FROM city
JOIN country ON city.CountryCode = country.Code
WHERE country.Name = 'Japan'
ORDER BY city.Population DESC;

-- check back at
SELECT city.Name, country.Name, city.District, city.Population
FROM city
JOIN country ON city.CountryCode = country.Code
WHERE city.District = 'Kabol'
ORDER BY city.Population DESC;

-- quick check
SELECT city.Name, country.Name, city.District, city.Population
FROM city
JOIN country ON city.CountryCode = country.Code
ORDER BY city.Population DESC
LIMIT 5;

-- v2
SELECT city.Name, country.Name, city.District, city.Population
FROM city
JOIN country ON city.CountryCode = country.Code
WHERE country.Continent = 'Africa'
ORDER BY city.Population DESC
LIMIT 3;

-- temp
SELECT city.Name, country.Name, city.District, city.Population
FROM city
JOIN country ON city.CountryCode = country.Code
WHERE country.Region = 'Caribbean'
ORDER BY city.Population DESC
LIMIT 3;

-- testing filt
SELECT city.Name, country.Name, city.District, city.Population
FROM city
JOIN country ON city.CountryCode = country.Code
WHERE country.Name = 'Japan'
ORDER BY city.Population DESC
LIMIT 3;

-- test
SELECT city.Name, country.Name, city.District, city.Population
FROM city
JOIN country ON city.CountryCode = country.Code
WHERE city.District = 'Kabol'
ORDER BY city.Population DESC
LIMIT 3;

-- check id
SELECT city.Name, country.Name, city.Population
FROM country
JOIN city ON country.Capital = city.ID
ORDER BY city.Population DESC;

-- another one
SELECT city.Name, country.Name, city.Population
FROM country
JOIN city ON country.Capital = city.ID
WHERE country.Continent = 'Europe'
ORDER BY city.Population DESC;

-- works?
SELECT city.Name, country.Name, city.Population
FROM country
JOIN city ON country.Capital = city.ID
WHERE country.Region = 'Caribbean'
ORDER BY city.Population DESC;

-- limit test
SELECT city.Name, country.Name, city.Population
FROM country
JOIN city ON country.Capital = city.ID
ORDER BY city.Population DESC
LIMIT 5;

-- test again
SELECT city.Name, country.Name, city.Population
FROM country
JOIN city ON country.Capital = city.ID
WHERE country.Continent = 'Asia'
ORDER BY city.Population DESC
LIMIT 3;

-- final check
SELECT city.Name, country.Name, city.Population
FROM country
JOIN city ON country.Capital = city.ID
WHERE country.Region = 'Caribbean'
ORDER BY city.Population DESC
LIMIT 3;