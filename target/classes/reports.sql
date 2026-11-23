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

-- remaining 3 queries from list
SELECT
    country.Continent AS 'Continent',
    SUM(country.Population) AS 'Total Population',
    SUM(city.Population) AS 'Population Living in Cities',
    SUM(country.Population) - SUM(city.Population) AS 'Population Not Living in Cities'
FROM country
         LEFT JOIN city ON country.Code = city.CountryCode
GROUP BY country.Continent
ORDER BY SUM(country.Population) DESC;

SELECT
    country.Region AS 'Region',
    SUM(country.Population) AS 'Total Population',
    SUM(city.Population) AS 'Population Living in Cities',
    SUM(country.Population) - SUM(city.Population) AS 'Population Not Living in Cities'
FROM country
         LEFT JOIN city ON country.Code = city.CountryCode
GROUP BY country.Region
ORDER BY SUM(country.Population) DESC;

SELECT
    country.Name AS 'Country',
    country.Population AS 'Total Population',
    SUM(city.Population) AS 'Population Living in Cities',
    country.Population - SUM(city.Population) AS 'Population Not Living in Cities'
FROM country
         LEFT JOIN city ON country.Code = city.CountryCode
GROUP BY country.Code, country.Name, country.Population
ORDER BY country.Population DESC;

-- go back to w3 and check for relations
-- all up and working
-- see for filter later on and do it 38392

-- Population of whatever

-- population of world
SELECT
    SUM(Population) AS 'World Population'
FROM country;

-- population of continent using asia
SELECT
    Continent AS 'Continent',
    SUM(Population) AS 'Population'
FROM country
WHERE Continent = 'Asia'
GROUP BY Continent;

-- population of region using Carribean
SELECT
    Region AS 'Region',
    SUM(Population) AS 'Population'
FROM country
WHERE Region = 'Caribbean'
GROUP BY Region;

-- population of country
SELECT
    Name AS 'Country',
    Population AS 'Population'
FROM country
WHERE Name = 'Japan';

-- population of district
SELECT
    District AS 'District',
    SUM(Population) AS 'Population'
FROM city
WHERE District = 'Scotland'
GROUP BY District;

-- population of city
SELECT
    Name AS 'City',
    Population AS 'Population'
FROM city
WHERE Name = 'Edinburgh';

-- Language population

SELECT
    countrylanguage.Language AS 'Language',
    SUM(country.Population * countrylanguage.Percentage / 100) AS 'Number of Speakers',
    ROUND(
            SUM(country.Population * countrylanguage.Percentage / 100)
                / (SELECT SUM(Population) FROM country) * 100,
            2
    ) AS 'Percentage of World Population'
FROM countrylanguage
         JOIN country ON countrylanguage.CountryCode = country.Code
WHERE countrylanguage.Language IN (
                                   'Chinese',
                                   'English',
                                   'Hindi',
                                   'Spanish',
                                   'Arabic'
    )
GROUP BY countrylanguage.Language
ORDER BY SUM(country.Population * countrylanguage.Percentage / 100) DESC;