-- test
SELECT country.Code AS 'Country Code', country.Name AS 'Country', country.Continent AS 'Continent', country.Region AS 'Region', country.Population AS 'Country Population', city.Name AS 'Capital City'
FROM country
LEFT JOIN city ON country.Capital = city.ID
ORDER BY country.Population DESC;

-- check this
SELECT country.Code AS 'Country Code', country.Name AS 'Country', country.Continent AS 'Continent', country.Region AS 'Region', country.Population AS 'Country Population', city.Name AS 'Capital City'
FROM country
LEFT JOIN city ON country.Capital = city.ID
WHERE country.Continent = 'Asia'
ORDER BY country.Population DESC;

-- hmm
SELECT country.Code AS 'Country Code', country.Name AS 'Country', country.Continent AS 'Continent', country.Region AS 'Region', country.Population AS 'Country Population', city.Name AS 'Capital City'
FROM country
LEFT JOIN city ON country.Capital = city.ID
WHERE country.Region = 'Caribbean'
ORDER BY country.Population DESC;

-- limit test
-- check back at w3 for tut
SELECT country.Code AS 'Country Code', country.Name AS 'Country', country.Continent AS 'Continent', country.Region AS 'Region', country.Population AS 'Country Population', city.Name AS 'Capital City'
FROM country
LEFT JOIN city ON country.Capital = city.ID
ORDER BY country.Population DESC
LIMIT 5;

-- try this
SELECT country.Code AS 'Country Code', country.Name AS 'Country', country.Continent AS 'Continent', country.Region AS 'Region', country.Population AS 'Country Population', city.Name AS 'Capital City'
FROM country
LEFT JOIN city ON country.Capital = city.ID
WHERE country.Continent = 'Europe'
ORDER BY country.Population DESC
LIMIT 3;

-- test again
SELECT country.Code AS 'Country Code', country.Name AS 'Country', country.Continent AS 'Continent', country.Region AS 'Region', country.Population AS 'Country Population', city.Name AS 'Capital City'
FROM country
LEFT JOIN city ON country.Capital = city.ID
WHERE country.Region = 'Caribbean'
ORDER BY country.Population DESC
LIMIT 3;

-- check join
SELECT city.Name AS 'City', country.Name AS 'Country', city.District AS 'District', city.Population AS 'City Population'
FROM city
JOIN country ON city.CountryCode = country.Code
ORDER BY city.Population DESC;

-- maybe
SELECT city.Name AS 'City', country.Name AS 'Country', city.District AS 'District', city.Population AS 'City Population'
FROM city
JOIN country ON city.CountryCode = country.Code
WHERE country.Continent = 'Oceania'
ORDER BY city.Population DESC;

-- same thing
SELECT city.Name AS 'City', country.Name AS 'Country', city.District AS 'District', city.Population AS 'City Population'
FROM city
JOIN country ON city.CountryCode = country.Code
WHERE country.Region = 'Caribbean'
ORDER BY city.Population DESC;

-- check this one
SELECT city.Name AS 'City', country.Name AS 'Country', city.District AS 'District', city.Population AS 'City Population'
FROM city
JOIN country ON city.CountryCode = country.Code
WHERE country.Name = 'Japan'
ORDER BY city.Population DESC;

-- check back at
SELECT city.Name AS 'City', country.Name AS 'Country', city.District AS 'District', city.Population AS 'City Population'
FROM city
JOIN country ON city.CountryCode = country.Code
WHERE city.District = 'Kabol'
ORDER BY city.Population DESC;

-- quick check
SELECT city.Name AS 'City', country.Name AS 'Country', city.District AS 'District', city.Population AS 'City Population'
FROM city
JOIN country ON city.CountryCode = country.Code
ORDER BY city.Population DESC
LIMIT 5;

-- v2
SELECT city.Name AS 'City', country.Name AS 'Country', city.District AS 'District', city.Population AS 'City Population'
FROM city
JOIN country ON city.CountryCode = country.Code
WHERE country.Continent = 'Africa'
ORDER BY city.Population DESC
LIMIT 3;

-- temp
SELECT city.Name AS 'City', country.Name AS 'Country', city.District AS 'District', city.Population AS 'City Population'
FROM city
JOIN country ON city.CountryCode = country.Code
WHERE country.Region = 'Caribbean'
ORDER BY city.Population DESC
LIMIT 3;

-- testing filter
SELECT city.Name AS 'City', country.Name AS 'Country', city.District AS 'District', city.Population AS 'City Population'
FROM city
JOIN country ON city.CountryCode = country.Code
WHERE country.Name = 'Japan'
ORDER BY city.Population DESC
LIMIT 3;

-- test
SELECT city.Name AS 'City', country.Name AS 'Country', city.District AS 'District', city.Population AS 'City Population'
FROM city
JOIN country ON city.CountryCode = country.Code
WHERE city.District = 'Kabol'
ORDER BY city.Population DESC
LIMIT 3;

-- check id
SELECT city.Name AS 'Capital City', country.Name AS 'Country', city.Population AS 'Capital Population'
FROM country
JOIN city ON country.Capital = city.ID
ORDER BY city.Population DESC;

-- another one
SELECT city.Name AS 'Capital City', country.Name AS 'Country', city.Population AS 'Capital Population'
FROM country
JOIN city ON country.Capital = city.ID
WHERE country.Continent = 'Europe'
ORDER BY city.Population DESC;

-- works?
SELECT city.Name AS 'Capital City', country.Name AS 'Country', city.Population AS 'Capital Population'
FROM country
JOIN city ON country.Capital = city.ID
WHERE country.Region = 'Caribbean'
ORDER BY city.Population DESC;

-- limit test
SELECT city.Name AS 'Capital City', country.Name AS 'Country', city.Population AS 'Capital Population'
FROM country
JOIN city ON country.Capital = city.ID
ORDER BY city.Population DESC
LIMIT 5;

-- test again
SELECT city.Name AS 'Capital City', country.Name AS 'Country', city.Population AS 'Capital Population'
FROM country
JOIN city ON country.Capital = city.ID
WHERE country.Continent = 'Asia'
ORDER BY city.Population DESC
LIMIT 3;

-- final check
SELECT city.Name AS 'Capital City', country.Name AS 'Country', city.Population AS 'Capital Population'
FROM country
JOIN city ON country.Capital = city.ID
WHERE country.Region = 'Caribbean'
ORDER BY city.Population DESC
LIMIT 3;

-- go back to w3 and check for relations
-- all up and working
-- see for filter later on and do it 38392
